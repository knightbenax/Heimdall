// Generated by Dagger (https://dagger.dev).
package android.heimdallr.app.heimdallr.core.daggger.modules.network;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.io.File;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_CacheFileFactory implements Factory<File> {
  private final NetworkModule module;

  private final Provider<Context> contextProvider;

  public NetworkModule_CacheFileFactory(NetworkModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public File get() {
    return cacheFile(module, contextProvider.get());
  }

  public static NetworkModule_CacheFileFactory create(NetworkModule module,
      Provider<Context> contextProvider) {
    return new NetworkModule_CacheFileFactory(module, contextProvider);
  }

  public static File cacheFile(NetworkModule instance, Context context) {
    return Preconditions.checkNotNull(instance.cacheFile(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
