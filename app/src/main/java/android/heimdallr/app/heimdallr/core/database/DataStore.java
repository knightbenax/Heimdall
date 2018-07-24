package android.heimdallr.app.heimdallr.core.database;

import javax.inject.Inject;

public class DataStore {

    private OnlineStore onlineStore;
    private OfflineStore offlineStore;

    @Inject
    public DataStore(OfflineStore offlineStore, OnlineStore onlineStore) {
        this.offlineStore = offlineStore;
        this.onlineStore = onlineStore;
    }

    public void saveUser(String name, String email, String phone, String token, String refreshToken, String wallet) {

        offlineStore.saveUser(name, email, phone, token, refreshToken, wallet);

    }


}
