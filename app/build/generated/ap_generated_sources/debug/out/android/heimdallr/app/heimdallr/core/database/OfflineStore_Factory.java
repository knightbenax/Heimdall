// Generated by Dagger (https://dagger.dev).
package android.heimdallr.app.heimdallr.core.database;

import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OfflineStore_Factory implements Factory<OfflineStore> {
  private final Provider<RoomManager> roomManagerProvider;

  public OfflineStore_Factory(Provider<RoomManager> roomManagerProvider) {
    this.roomManagerProvider = roomManagerProvider;
  }

  @Override
  public OfflineStore get() {
    return newInstance(roomManagerProvider.get());
  }

  public static OfflineStore_Factory create(Provider<RoomManager> roomManagerProvider) {
    return new OfflineStore_Factory(roomManagerProvider);
  }

  public static OfflineStore newInstance(RoomManager roomManager) {
    return new OfflineStore(roomManager);
  }
}
