package android.heimdallr.app.heimdallr;

import android.heimdallr.app.heimdallr.databinding.ActivityLauncherBindingImpl;
import android.heimdallr.app.heimdallr.databinding.ActivityMainBindingImpl;
import android.heimdallr.app.heimdallr.databinding.LayoutSingleAppBindingImpl;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYLAUNCHER = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_LAYOUTSINGLEAPP = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(android.heimdallr.app.heimdallr.R.layout.activity_launcher, LAYOUT_ACTIVITYLAUNCHER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(android.heimdallr.app.heimdallr.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(android.heimdallr.app.heimdallr.R.layout.layout_single_app, LAYOUT_LAYOUTSINGLEAPP);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYLAUNCHER: {
          if ("layout/activity_launcher_0".equals(tag)) {
            return new ActivityLauncherBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_launcher is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSINGLEAPP: {
          if ("layout/layout_single_app_0".equals(tag)) {
            return new LayoutSingleAppBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_single_app is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "email");
      sKeys.put(2, "model");
      sKeys.put(3, "name");
      sKeys.put(4, "phone");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/activity_launcher_0", android.heimdallr.app.heimdallr.R.layout.activity_launcher);
      sKeys.put("layout/activity_main_0", android.heimdallr.app.heimdallr.R.layout.activity_main);
      sKeys.put("layout/layout_single_app_0", android.heimdallr.app.heimdallr.R.layout.layout_single_app);
    }
  }
}