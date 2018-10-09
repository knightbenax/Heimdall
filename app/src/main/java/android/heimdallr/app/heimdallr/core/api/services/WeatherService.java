package android.heimdallr.app.heimdallr.core.api.services;

import android.heimdallr.app.heimdallr.core.api.models.WeatherResponse;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by knightbenax on 01/03/2018.
 */

public interface WeatherService {


    @GET("data/2.5/weather")
    Observable<Response<WeatherResponse>> getWeather(@Query("lat")String lat, @Query("lon")String longitude, @Query("appid")String appid, @Query("units")String units);


}
