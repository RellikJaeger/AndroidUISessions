package ajitsingh.com.androiduisessions.session1.basic_layouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import ajitsingh.com.androiduisessions.R;

public class ScrollViewWithListView extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.scroll_with_list_view);

    ListView listView = (ListView) findViewById(R.id.list_view);
    setListViewHeightBasedOnChildren(listView);
  }

  public static void setListViewHeightBasedOnChildren(ListView listView) {
    ListAdapter listAdapter = listView.getAdapter();
    if (listAdapter == null) {
      // pre-condition
      return;
    }

    int totalHeight = 0;
    for (int i = 0; i < listAdapter.getCount(); i++) {
      View listItem = listAdapter.getView(i, null, listView);
      listItem.measure(0, 0);
      totalHeight += listItem.getMeasuredHeight();
    }

    ViewGroup.LayoutParams params = listView.getLayoutParams();
    params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
    listView.setLayoutParams(params);
    listView.requestLayout();
  }
}
