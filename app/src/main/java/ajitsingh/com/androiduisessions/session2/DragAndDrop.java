package ajitsingh.com.androiduisessions.session2;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

import ajitsingh.com.androiduisessions.R;

public class DragAndDrop extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.drag_and_drop);

    TextView dragView = (TextView) findViewById(R.id.drag_text);
    TextView dropView = (TextView) findViewById(R.id.drop_text);

    dragView.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View v) {
        v.startDrag(ClipData.newPlainText("Drag Label", "Drag Text"), new DragShadow(v), v, 0);
        return false;
      }
    });

    dropView.setOnDragListener(new View.OnDragListener() {
      @Override
      public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (action) {
          case DragEvent.ACTION_DROP:
            TextView target = (TextView) v;
            TextView newTextView = (TextView) event.getLocalState();
            target.setText(newTextView.getText());
            return true;
        }

        return true;
      }
    });
  }

  static class DragShadow extends View.DragShadowBuilder {

    private ColorDrawable dragableArea;

    public DragShadow(View view) {
      super(view);
      dragableArea = new ColorDrawable(Color.BLUE);
    }

    @Override
    public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
      View view = getView();
      final int height = view.getHeight();
      final int width = view.getWidth();

      dragableArea.setBounds(0, 0, width/2, height/2);

      shadowSize.set(width/2, height/2);
      shadowTouchPoint.set(width/2, height/2);
    }

    @Override
    public void onDrawShadow(Canvas canvas) {
      dragableArea.draw(canvas);
    }
  }
}
