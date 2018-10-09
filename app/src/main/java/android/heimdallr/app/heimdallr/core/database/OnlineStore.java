package android.heimdallr.app.heimdallr.core.database;

import android.heimdallr.app.heimdallr.core.api.models.WeatherResponse;
import android.heimdallr.app.heimdallr.core.api.services.WeatherService;

import javax.inject.Inject;

import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OnlineStore {


    private Retrofit retrofit;
    private WeatherService weatherService;


    @Inject
    public OnlineStore(Retrofit retrofit){
        this.retrofit = retrofit;

        weatherService = retrofit.create(WeatherService.class);

    }

    public Observable<Response<WeatherResponse>> getWeather(String lat, String lng, String apiKey, String units){
        return weatherService.getWeather(lat, lng, apiKey, units).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}
