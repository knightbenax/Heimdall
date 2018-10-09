package android.heimdallr.app.heimdallr.core.daggger.modules.store;

import android.heimdallr.app.heimdallr.core.database.RoomManager;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomManagerModule {

    @Provides
    public RoomManager provideRealmManager() {
        return RoomManager.getInstance();
    }
}
