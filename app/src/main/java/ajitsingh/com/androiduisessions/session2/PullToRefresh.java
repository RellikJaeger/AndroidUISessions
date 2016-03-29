package ajitsingh.com.androiduisessions.session2;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ajitsingh.com.androiduisessions.R;

public class PullToRefresh extends AppCompatActivity {

  private SwipeRefreshLayout swipeToRefreshContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.pull_to_refresh);
    final TextView textView = (TextView) findViewById(R.id.swipe_text);
    swipeToRefreshContainer = (SwipeRefreshLayout) findViewById(R.id.swip_refresh_layout);

    swipeToRefreshContainer.setColorSchemeResources(
        R.color.colorAccent,
        R.color.link_text_material_light,
        R.color.colorPrimary
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

  public void refresh(View view) {
    final Button button = (Button) view;
    button.setText("Refreshing...");
    swipeToRefreshContainer.setRefreshing(true);

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        swipeToRefreshContainer.setRefreshing(false);
        button.setText("Refresh");
      }
    }, 5000L);
  }
}
