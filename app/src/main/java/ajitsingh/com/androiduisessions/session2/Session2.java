package ajitsingh.com.androiduisessions.session2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ajitsingh.com.androiduisessions.R;
import ajitsingh.com.androiduisessions.demo.Demo;

public class Session2 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.session2);
  }

  public void pullToRefresh(View view) {
    final Intent intent = new Intent(this, PullToRefresh.class);
    startActivity(intent);
  }

  public void floatingButton(View view) {
    Demo.start(this, R.layout.floating_button);
  }

  public void dragAndDrop(View view) {
    Intent intent = new Intent(this, DragAndDrop.class);
    startActivity(intent);
  }

  public void draggableView(View view) {
    Intent intent = new Intent(this, DraggableView.class);
    startActivity(intent);
  }

  public void stickyHeader(View view) {
    Intent intent = new Intent(this, StickyHeader.class);
    startActivity(intent);
  }

  public void customAnimation(View view) {
    Intent intent = new Intent(this, CustomAnimation.class);
    startActivity(intent);
  }

  public void activityTransition(View view) {
    Intent intent = new Intent(this, ActivityTransition.class);
    startActivity(intent);
  }
}
