package ajitsingh.com.androiduisessions.session2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ajitsingh.com.androiduisessions.R;

public class DummyActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dummy);
  }

  @Override
  protected void onPause() {
    super.onPause();
    overridePendingTransition(R.anim.activity_recreate, R.anim.activity_destroy);
  }
}