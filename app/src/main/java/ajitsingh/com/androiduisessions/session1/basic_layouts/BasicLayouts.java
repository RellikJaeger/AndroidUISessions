package ajitsingh.com.androiduisessions.session1.basic_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ajitsingh.com.androiduisessions.R;
import ajitsingh.com.androiduisessions.demo.Demo;

public class BasicLayouts extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.basic_layouts);
  }

  public void showLinearHorizontalLayout(View view) {
    Demo.start(this, R.layout.linear_horizontal);
  }

  public void showLinearVerticalLayout(View view) {
    Demo.start(this, R.layout.linear_vertical);
  }

  public void showTableLayout(View view) {
    Demo.start(this, R.layout.table_layout);
  }

  public void showRelativeLayout(View view) {
    Demo.start(this, R.layout.relative_layout);
  }

  public void showScrollLayout(View view) {
    Intent intent = new Intent(this, ScrollViewDemo.class);
    startActivity(intent);
  }

  public void showFrameLayout(View view) {
    Demo.start(this, R.layout.frame_layout);
  }
}
