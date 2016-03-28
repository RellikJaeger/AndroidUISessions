package ajitsingh.com.androiduisessions.session2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import ajitsingh.com.androiduisessions.R;

public class CustomAnimation extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.custom_animations);
    LinearLayout container = (LinearLayout) findViewById(R.id.container);

    container.startAnimation(AnimationUtils.loadAnimation(this, R.anim.custom_bounce_entry));
  }

  public void fadeIn(View view) {
    view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
  }

  public void bounce(View view) {
    view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce));
  }

  public void scale(View view) {
    view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
  }

  public void rotate(View view) {
    view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
  }
}