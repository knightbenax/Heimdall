package android.heimdallr.app.heimdallr.core.daggger.modules.store;


import android.heimdallr.app.heimdallr.core.database.DataStore;
import android.heimdallr.app.heimdallr.core.database.OfflineStore;
import android.heimdallr.app.heimdallr.core.database.OnlineStore;

import dagger.Module;
import dagger.Provides;


@Module(includes = {OfflineStoreModule.class, OnlineStoreModule.class})
public class DataStoreModule {

    @Provides
    public DataStore provideDataStore(OfflineStore offlineStore, OnlineStore onlineStore) {
        return new DataStore(offlineStore, onlineStore);
    }

}
