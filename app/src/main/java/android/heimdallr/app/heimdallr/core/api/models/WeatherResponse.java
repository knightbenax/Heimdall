
package android.heimdallr.app.heimdallr.core.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class WeatherResponse {

    @SerializedName("clouds")
    private Clouds mClouds;
    @SerializedName("cod")
    private int mCod;
    @SerializedName("coord")
    private Coord mCoord;
    @SerializedName("dt")
    private Long mDt;
    @SerializedName("id")
    private Long mId;
    @SerializedName("main")
    private Main mMain;
    @SerializedName("name")
    private String mName;
    @SerializedName("rain")
    private Rain mRain;
    @SerializedName("sys")
    private Sys mSys;
    @SerializedName("weather")
    private List<Weather> mWeather;
    @SerializedName("wind")
    private Wind mWind;

    public Clouds getClouds() {
        return mClouds;
    }

    public void setClouds(Clouds clouds) {
        mClouds = clouds;
    }

    public int getCod() {
        return mCod;
    }

    public void setCod(int cod) {
        mCod = cod;
    }

    public Coord getCoord() {
        return mCoord;
    }

    public void setCoord(Coord coord) {
        mCoord = coord;
    }

    public Long getDt() {
        return mDt;
    }

    public void setDt(Long dt) {
        mDt = dt;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Main getMain() {
        return mMain;
    }

    public void setMain(Main main) {
        mMain = main;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Rain getRain() {
        return mRain;
    }

    public void setRain(Rain rain) {
        mRain = rain;
    }

    public Sys getSys() {
        return mSys;
    }

    public void setSys(Sys sys) {
        mSys = sys;
    }

    public List<Weather> getWeather() {
        return mWeather;
    }

    public void setWeather(List<Weather> weather) {
        mWeather = weather;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind wind) {
        mWind = wind;
    }

}
