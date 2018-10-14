// Generated by Dagger (https://google.github.io/dagger).
package android.heimdallr.app.heimdallr.core.database;

import dagger.internal.Factory;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class OnlineStore_Factory implements Factory<OnlineStore> {
  private final Provider<Retrofit> retrofitProvider;

  public OnlineStore_Factory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public OnlineStore get() {
    return new OnlineStore(retrofitProvider.get());
  }

  public static OnlineStore_Factory create(Provider<Retrofit> retrofitProvider) {
    return new OnlineStore_Factory(retrofitProvider);
  }
}