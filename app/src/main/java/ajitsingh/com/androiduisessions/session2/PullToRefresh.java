package ajitsingh.com.androiduisessions.session2;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import ajitsingh.com.androiduisessions.R;

public class PullToRefresh extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.pull_to_refresh);
    final TextView textView = (TextView) PullToRefresh.this.findViewById(R.id.swipe_text);
    final SwipeRefreshLayout swipeToRefreshContainer = (SwipeRefreshLayout) findViewById(R.id.swip_refresh_layout);

    swipeToRefreshContainer.setColorScheme(
      R.color.colorAccent,
      R.color.link_text_material_light,
      R.color.primary_dark_material_light
    );

    swipeToRefreshContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        textView.setText("Refreshing...");
        new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
            swipeToRefreshContainer.setRefreshing(false);
            textView.setText("Swipe Down...");
          }
        }, 5000L);
      }
    });
  }
}
