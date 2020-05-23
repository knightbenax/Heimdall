// Generated by data binding compiler. Do not edit!
package android.heimdallr.app.heimdallr.databinding;

import android.heimdallr.app.heimdallr.R;
import android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityLauncherBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout appsListHolder;

  @NonNull
  public final RecyclerView appsListRecycler;

  @NonNull
  public final ImageButton arrowUp;

  @NonNull
  public final LinearLayout buttonsHolder;

  @NonNull
  public final ImageButton chromeApp;

  @NonNull
  public final ImageButton contactApp;

  @NonNull
  public final ConstraintLayout container;

  @NonNull
  public final ImageButton emailApp;

  @NonNull
  public final LinearLayout gestureHolder;

  @NonNull
  public final TextView greetingText;

  @NonNull
  public final View notch;

  @NonNull
  public final ImageButton phoneApp;

  @NonNull
  public final ImageButton smsApp;

  @NonNull
  public final LinearLayout topPanel;

  @NonNull
  public final LinearLayout weatherHolder;

  @NonNull
  public final ImageView weatherIcon;

  @NonNull
  public final TextView weatherTag;

  @NonNull
  public final ImageButton whatsApp;

  @Bindable
  protected LauncherActivityViewModel.UIModel mModel;

  protected ActivityLauncherBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout appsListHolder, RecyclerView appsListRecycler, ImageButton arrowUp,
      LinearLayout buttonsHolder, ImageButton chromeApp, ImageButton contactApp,
      ConstraintLayout container, ImageButton emailApp, LinearLayout gestureHolder,
      TextView greetingText, View notch, ImageButton phoneApp, ImageButton smsApp,
      LinearLayout topPanel, LinearLayout weatherHolder, ImageView weatherIcon, TextView weatherTag,
      ImageButton whatsApp) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appsListHolder = appsListHolder;
    this.appsListRecycler = appsListRecycler;
    this.arrowUp = arrowUp;
    this.buttonsHolder = buttonsHolder;
    this.chromeApp = chromeApp;
    this.contactApp = contactApp;
    this.container = container;
    this.emailApp = emailApp;
    this.gestureHolder = gestureHolder;
    this.greetingText = greetingText;
    this.notch = notch;
    this.phoneApp = phoneApp;
    this.smsApp = smsApp;
    this.topPanel = topPanel;
    this.weatherHolder = weatherHolder;
    this.weatherIcon = weatherIcon;
    this.weatherTag = weatherTag;
    this.whatsApp = whatsApp;
  }

  public abstract void setModel(@Nullable LauncherActivityViewModel.UIModel model);

  @Nullable
  public LauncherActivityViewModel.UIModel getModel() {
    return mModel;
  }

  @NonNull
  public static ActivityLauncherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_launcher, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLauncherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityLauncherBinding>inflateInternal(inflater, R.layout.activity_launcher, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLauncherBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_launcher, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLauncherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityLauncherBinding>inflateInternal(inflater, R.layout.activity_launcher, null, false, component);
  }

  public static ActivityLauncherBinding bind(@NonNull View view) {
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
  public static ActivityLauncherBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityLauncherBinding)bind(component, view, R.layout.activity_launcher);
  }
}
