
package android.heimdallr.app.heimdallr.core.api.models;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Weather {

    @SerializedName("description")
    private String mDescription;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("id")
    private int mId;
    @SerializedName("main")
    private String mMain;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getMain() {
        return mMain;
    }

    public void setMain(String main) {
        mMain = main;
    }

}
