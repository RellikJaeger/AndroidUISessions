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
}
