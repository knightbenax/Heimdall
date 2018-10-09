package android.heimdallr.app.heimdallr.core.database;

import android.heimdallr.app.heimdallr.core.api.models.WeatherResponse;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    public Observable<Response<WeatherResponse>> getWeather(String lat, String lng, String apiKey, String units){
        return onlineStore.getWeather(lat, lng, apiKey, units).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


}
