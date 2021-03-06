// Generated by data binding compiler. Do not edit!
package android.heimdallr.app.heimdallr.databinding;

import android.heimdallr.app.heimdallr.R;
import android.heimdallr.app.heimdallr.core.models.App;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class LayoutSingleAppBinding extends ViewDataBinding {
  @NonNull
  public final ImageView appIcon;

  @NonNull
  public final TextView appLabel;

  @NonNull
  public final LinearLayout singleAppHolder;

  @Bindable
  protected App mModel;

  protected LayoutSingleAppBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView appIcon, TextView appLabel, LinearLayout singleAppHolder) {
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

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_single_app, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayoutSingleAppBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayoutSingleAppBinding>inflateInternal(inflater, R.layout.layout_single_app, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutSingleAppBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_single_app, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayoutSingleAppBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayoutSingleAppBinding>inflateInternal(inflater, R.layout.layout_single_app, null, false, component);
  }

  public static LayoutSingleAppBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static LayoutSingleAppBinding bind(@NonNull View view, @Nullable Object component) {
    return (LayoutSingleAppBinding)bind(component, view, R.layout.layout_single_app);
  }
}
