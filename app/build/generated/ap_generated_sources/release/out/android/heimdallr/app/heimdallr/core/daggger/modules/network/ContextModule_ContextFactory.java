// Generated by Dagger (https://dagger.dev).
package android.heimdallr.app.heimdallr.core.daggger.modules.network;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ContextModule_ContextFactory implements Factory<Context> {
  private final ContextModule module;

  public ContextModule_ContextFactory(ContextModule module) {
    this.module = module;
  }

  @Override
  public Context get() {
    return context(module);
  }

  public static ContextModule_ContextFactory create(ContextModule module) {
    return new ContextModule_ContextFactory(module);
  }

  public static Context context(ContextModule instance) {
    return Preconditions.checkNotNull(instance.context(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
