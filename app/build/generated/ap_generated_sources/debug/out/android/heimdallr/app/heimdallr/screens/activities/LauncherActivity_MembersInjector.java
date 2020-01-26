// Generated by Dagger (https://google.github.io/dagger).
package android.heimdallr.app.heimdallr.screens.activities;

import android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LauncherActivity_MembersInjector implements MembersInjector<LauncherActivity> {
  private final Provider<LauncherActivityViewModel> launcherActivityViewModelProvider;

  public LauncherActivity_MembersInjector(
      Provider<LauncherActivityViewModel> launcherActivityViewModelProvider) {
    this.launcherActivityViewModelProvider = launcherActivityViewModelProvider;
  }

  public static MembersInjector<LauncherActivity> create(
      Provider<LauncherActivityViewModel> launcherActivityViewModelProvider) {
    return new LauncherActivity_MembersInjector(launcherActivityViewModelProvider);
  }

  @Override
  public void injectMembers(LauncherActivity instance) {
    injectLauncherActivityViewModel(instance, launcherActivityViewModelProvider.get());
  }

  public static void injectLauncherActivityViewModel(
      LauncherActivity instance, LauncherActivityViewModel launcherActivityViewModel) {
    instance.launcherActivityViewModel = launcherActivityViewModel;
  }
}