package android.heimdallr.app.heimdallr.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.heimdallr.app.heimdallr.core.models.App;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class LayoutSingleAppBinding extends ViewDataBinding {
  @NonNull
  public final ImageView appIcon;

  @NonNull
  public final TextView appLabel;

  @NonNull
  public final LinearLayout singleAppHolder;

  @Bindable
  protected App mModel;

  protected LayoutSingleAppBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView appIcon, TextView appLabel, LinearLayout singleAppHolder) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appIcon = appIcon;
    this.appLabel = appLabel;
    this.singleAppHolder = singleAppHolder;
  }

  public abstract void setModel(@Nullable App model);

  @Nullable
  public App getModel() {
    return mModel;
  }

  @NonNull
  public static LayoutSingleAppBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutSingleAppBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutSingleAppBinding>inflate(inflater, android.heimdallr.app.heimdallr.R.layout.layout_single_app, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutSingleAppBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutSingleAppBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutSingleAppBinding>inflate(inflater, android.heimdallr.app.heimdallr.R.layout.layout_single_app, null, false, component);
  }

  public static LayoutSingleAppBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static LayoutSingleAppBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (LayoutSingleAppBinding)bind(component, view, android.heimdallr.app.heimdallr.R.layout.layout_single_app);
  }
}
