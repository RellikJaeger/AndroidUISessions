package ajitsingh.com.androiduisessions.session2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import ajitsingh.com.androiduisessions.R;

public class DraggableView extends AppCompatActivity implements View.OnTouchListener {
  float dX;
  float dY;
  int lastAction;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.draggable_view);

    final View dragView = findViewById(R.id.draggable_view);
    dragView.setOnTouchListener(this);
  }

  @Override
  public boolean onTouch(View view, MotionEvent event) {
    switch (event.getActionMasked()) {
      case MotionEvent.ACTION_DOWN:
        dX = view.getX() - event.getRawX();
        dY = view.getY() - event.getRawY();
        lastAction = MotionEvent.ACTION_DOWN;
        break;

      case MotionEvent.ACTION_MOVE:
        view.setY(event.getRawY() + dY);
        view.setX(event.getRawX() + dX);
        lastAction = MotionEvent.ACTION_MOVE;
        break;

      case MotionEvent.ACTION_UP:
        if (lastAction == MotionEvent.ACTION_DOWN)
          Toast.makeText(DraggableView.this, "Clicked!", Toast.LENGTH_SHORT).show();
        break;

      default:
        return false;
    }
    return true;
  }
}