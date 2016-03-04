package ajitsingh.com.androiduisessions.session1.basic_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ajitsingh.com.androiduisessions.R;

public class ScrollViewDemo  extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.scroll_layout);
  }

  public void scrollViewWithListView(View view) {
    final Intent intent = new Intent(this, ScrollViewWithListView.class);
    startActivity(intent);
  }
}
