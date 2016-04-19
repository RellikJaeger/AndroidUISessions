package ajitsingh.com.androiduisessions.session2;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ajitsingh.com.androiduisessions.R;

import static java.util.Arrays.asList;

public class DragAndDrop extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.drag_and_drop);

    final TextView dragView1 = (TextView) findViewById(R.id.drag_text1);
    TextView dragView2 = (TextView) findViewById(R.id.drag_text2);
    TextView dragView3 = (TextView) findViewById(R.id.drag_text3);
    TextView dropView = (TextView) findViewById(R.id.drop_text);

    List<TextView> options = asList(dragView1, dragView2, dragView3);

    for (final TextView option : options) {
      option.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
          v.startDrag(ClipData.newPlainText("CI", option.getText()), new DragShadow(v), v, 0);
          return true;
        }
      });
    }

    dropView.setOnDragListener(new View.OnDragListener() {
      @Override
      public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (action) {
          case DragEvent.ACTION_DROP:
            TextView targetTextView = (TextView) v;
            TextView droppedTextView = (TextView) event.getLocalState();
            droppedTextView.setEnabled(false);
            droppedTextView.setTextColor(DragAndDrop.this.getResources().getColor(R.color.dim_foreground_disabled_material_dark));
            targetTextView.setText(droppedTextView.getText());
            return true;
        }

        return true;
      }
    });
  }

  static class DragShadow extends View.DragShadowBuilder {
    private View view;

    public DragShadow(View view) {
      super(view);
      this.view = view;
    }

    @Override
    public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
      View view = getView();

      shadowSize.set(view.getWidth(), view.getHeight());
      shadowTouchPoint.set(view.getWidth()/2, view.getHeight()/2);
    }

    @Override
    public void onDrawShadow(Canvas canvas) {
      view.draw(canvas);
    }
  }
}
