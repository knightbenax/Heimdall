
package android.heimdallr.app.heimdallr.core.api.models;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Coord {

    @SerializedName("lat")
    private double mLat;
    @SerializedName("lon")
    private double mLon;

    public double getLat() {
        return mLat;
    }

    public void setLat(double lat) {
        mLat = lat;
    }

    public double getLon() {
        return mLon;
    }

    public void setLon(double lon) {
        mLon = lon;
    }

}
