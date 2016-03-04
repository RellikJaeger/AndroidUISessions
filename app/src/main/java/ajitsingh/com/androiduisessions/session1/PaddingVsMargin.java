package ajitsingh.com.androiduisessions.session1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ajitsingh.com.androiduisessions.R;
import ajitsingh.com.androiduisessions.demo.Demo;

public class PaddingVsMargin extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.padding_vs_margin);
  }

  public void padding(View view) {
    Demo.start(this, R.layout.padding);
  }

  public void margin(View view) {
    Demo.start(this, R.layout.margin);
  }
}
