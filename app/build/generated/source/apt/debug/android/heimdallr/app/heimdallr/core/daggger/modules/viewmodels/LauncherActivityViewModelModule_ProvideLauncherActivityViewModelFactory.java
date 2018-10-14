// Generated by Dagger (https://google.github.io/dagger).
package android.heimdallr.app.heimdallr.core.daggger.modules.viewmodels;

import android.heimdallr.app.heimdallr.core.database.DataStore;
import android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class LauncherActivityViewModelModule_ProvideLauncherActivityViewModelFactory
    implements Factory<LauncherActivityViewModel> {
  private final LauncherActivityViewModelModule module;

  private final Provider<DataStore> datastoreProvider;

  private final Provider<Retrofit> retrofitProvider;

  public LauncherActivityViewModelModule_ProvideLauncherActivityViewModelFactory(
      LauncherActivityViewModelModule module,
      Provider<DataStore> datastoreProvider,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.datastoreProvider = datastoreProvider;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public LauncherActivityViewModel get() {
    return Preconditions.checkNotNull(
        module.provideLauncherActivityViewModel(datastoreProvider.get(), retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static LauncherActivityViewModelModule_ProvideLauncherActivityViewModelFactory create(
      LauncherActivityViewModelModule module,
      Provider<DataStore> datastoreProvider,
      Provider<Retrofit> retrofitProvider) {
    return new LauncherActivityViewModelModule_ProvideLauncherActivityViewModelFactory(
        module, datastoreProvider, retrofitProvider);
  }

  public static LauncherActivityViewModel proxyProvideLauncherActivityViewModel(
      LauncherActivityViewModelModule instance, DataStore datastore, Retrofit retrofit) {
    return Preconditions.checkNotNull(
        instance.provideLauncherActivityViewModel(datastore, retrofit),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}