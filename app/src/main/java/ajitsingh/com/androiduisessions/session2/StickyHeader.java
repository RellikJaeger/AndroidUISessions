package ajitsingh.com.androiduisessions.session2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import ajitsingh.com.androiduisessions.R;

public class StickyHeader extends AppCompatActivity implements AbsListView.OnScrollListener {

  private ImageView image;
  private ListView listView;
  private TextView heading;
  private View headingPlaceholder;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sticky_header_parent);

    FrameLayout parent = (FrameLayout) findViewById(R.id.container);
    LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

    LinearLayout headerPlaceholder = (LinearLayout) inflater.inflate(R.layout.header_placeholder, parent, false);
    image = (ImageView) findViewById(R.id.image);
    heading = (TextView) findViewById(R.id.heading);
    headingPlaceholder = headerPlaceholder.findViewById(R.id.heading_placeholder);

    listView = (ListView) findViewById(R.id.list);
    listView.setAdapter(new ArrayAdapter<>(this, R.layout.list_item, this.getResources().getStringArray(R.array.android_versions)));
    listView.addHeaderView(headerPlaceholder);
    listView.setOnScrollListener(this);
  }

  @Override
  public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    if (listView.getFirstVisiblePosition() == 0) {
      View firstChild = listView.getChildAt(0);
      if (firstChild != null) {
        float listViewHeadersTopY = firstChild.getTop();
        image.setY(listViewHeadersTopY * 0.5f);
        heading.setY(Math.max(0, headingPlaceholder.getTop() + listViewHeadersTopY));
      }
    }
  }

  @Override
  public void onScrollStateChanged(AbsListView view, int scrollState) {
  }
}