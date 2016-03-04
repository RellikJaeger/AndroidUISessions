package ajitsingh.com.androiduisessions.demo;

import android.content.Context;
import android.content.Intent;

public class Demo {
  public static void start(Context ctx, int layout){
    Intent intent = new Intent(ctx, DemoActivity.class);
    intent.putExtra(DemoActivity.VIEW_TO_LOAD, layout);

    ctx.startActivity(intent);
  }
}
