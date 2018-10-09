package android.heimdallr.app.heimdallr.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class ActivityLauncherBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout appsListHolder;

  @NonNull
  public final RecyclerView appsListRecycler;

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

  protected ActivityLauncherBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout appsListHolder, RecyclerView appsListRecycler,
      LinearLayout buttonsHolder, ImageButton chromeApp, ImageButton contactApp,
      ConstraintLayout container, ImageButton emailApp, LinearLayout gestureHolder,
      ImageButton phoneApp, ImageButton smsApp, LinearLayout topPanel, LinearLayout weatherHolder,
      ImageView weatherIcon, TextView weatherTag, ImageButton whatsApp) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appsListHolder = appsListHolder;
    this.appsListRecycler = appsListRecycler;
    this.buttonsHolder = buttonsHolder;
    this.chromeApp = chromeApp;
    this.contactApp = contactApp;
    this.container = container;
    this.emailApp = emailApp;
    this.gestureHolder = gestureHolder;
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

  @NonNull
  public static ActivityLauncherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLauncherBinding>inflate(inflater, android.heimdallr.app.heimdallr.R.layout.activity_launcher, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLauncherBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLauncherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLauncherBinding>inflate(inflater, android.heimdallr.app.heimdallr.R.layout.activity_launcher, null, false, component);
  }

  public static ActivityLauncherBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityLauncherBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityLauncherBinding)bind(component, view, android.heimdallr.app.heimdallr.R.layout.activity_launcher);
  }
}
