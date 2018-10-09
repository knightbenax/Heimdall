
package android.heimdallr.app.heimdallr.core.api.models;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Rain {

    @SerializedName("3h")
    private Long mH;

    public Long getH() {
        return mH;
    }

    public void setH(Long h) {
        mH = h;
    }

}
