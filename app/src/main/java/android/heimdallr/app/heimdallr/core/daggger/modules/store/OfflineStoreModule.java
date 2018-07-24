package android.heimdallr.app.heimdallr.core.daggger.modules.store;

import android.heimdallr.app.heimdallr.core.database.OfflineStore;
import android.heimdallr.app.heimdallr.core.database.RoomManager;

import dagger.Module;
import dagger.Provides;

@Module(includes = {RoomManagerModule.class})
public class OfflineStoreModule {

    @Provides
    public OfflineStore provideOfflineStore(RoomManager roomManager){
        return new OfflineStore(roomManager);
    }

}
