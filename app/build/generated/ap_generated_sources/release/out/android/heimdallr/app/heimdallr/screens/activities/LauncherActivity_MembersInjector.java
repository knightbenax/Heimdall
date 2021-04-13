// Generated by Dagger (https://dagger.dev).
package android.heimdallr.app.heimdallr.screens.activities;

import android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LauncherActivity_MembersInjector implements MembersInjector<LauncherActivity> {
  private final Provider<LauncherActivityViewModel> launcherActivityViewModelProvider;

  public LauncherActivity_MembersInjector(
      Provider<LauncherActivityViewModel> launcherActivityViewModelProvider) {
    this.launcherActivityViewModelProvider = launcherActivityViewModelProvider;
  }

  public static MembersInjector<LauncherActivity> create(
      Provider<LauncherActivityViewModel> launcherActivityViewModelProvider) {
    return new LauncherActivity_MembersInjector(launcherActivityViewModelProvider);}

  @Override
  public void injectMembers(LauncherActivity instance) {
    injectLauncherActivityViewModel(instance, launcherActivityViewModelProvider.get());
  }

  @InjectedFieldSignature("android.heimdallr.app.heimdallr.screens.activities.LauncherActivity.launcherActivityViewModel")
  public static void injectLauncherActivityViewModel(LauncherActivity instance,
      LauncherActivityViewModel launcherActivityViewModel) {
    instance.launcherActivityViewModel = launcherActivityViewModel;
  }
}