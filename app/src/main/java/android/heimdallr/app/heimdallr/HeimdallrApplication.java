package android.heimdallr.app.heimdallr;

import android.app.Activity;
import android.app.Application;
import android.heimdallr.app.heimdallr.core.daggger.components.AppMainComponent;
import android.heimdallr.app.heimdallr.core.daggger.components.DaggerAppMainComponent;
import android.heimdallr.app.heimdallr.core.daggger.modules.network.ContextModule;
import android.heimdallr.app.heimdallr.core.daggger.modules.viewmodels.MainActivityViewModelModule;
import android.heimdallr.app.heimdallr.core.database.RoomManager;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class HeimdallrApplication extends Application {

    private AppMainComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initCalligraphy();
        initRoom();

        component = DaggerAppMainComponent.builder()
                .contextModule(new ContextModule(this))
                .mainActivityViewModelModule(new MainActivityViewModelModule())
                .build();
        component.inject(this);
    }

    private void initRoom(){
        RoomManager.getInstance().with(this);
    }



    private void initCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                //.setDefaultFontPath("fonts/montserrat/Montserrat-Regular.otf")
                .setDefaultFontPath("fonts/productsans/Product_Sans_Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    public static HeimdallrApplication get(Activity activity) {
        return (HeimdallrApplication)activity.getApplication();
    }


    public AppMainComponent getComponent() {
        return component;
    }

    public void setComponent(AppMainComponent component) {
        this.component = component;
    }
}
