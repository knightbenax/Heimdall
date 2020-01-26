package android.heimdallr.app.heimdallr.screens.viewmodels;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.heimdallr.app.heimdallr.BR;
import android.heimdallr.app.heimdallr.core.api.models.WeatherResponse;
import android.heimdallr.app.heimdallr.core.database.DataStore;
import android.heimdallr.app.heimdallr.core.models.App;
import android.heimdallr.app.heimdallr.core.viewmodels.CoreViewModel;
import android.heimdallr.app.heimdallr.screens.activities.LauncherActivity;
import android.provider.Telephony;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LauncherActivityViewModel extends CoreViewModel {

    private DataStore dataStore;
    private Retrofit retrofit;

    private Boolean signUpFieldsValid, loginFieldsValid;

    LauncherActivity launcherActivity;

    @Bindable
    public String name;

    @Bindable
    public String email;

    @Bindable
    public String phone;


    @Inject
    public LauncherActivityViewModel(DataStore dataStore, Retrofit retrofit){
        this.dataStore = dataStore;
        this.retrofit = retrofit;
    }

    public LauncherActivity getLauncherActivity() {
        return launcherActivity;
    }

    public void setLauncherActivity(LauncherActivity launcherActivity) {
        this.launcherActivity = launcherActivity;
    }

    public Observable<Response<WeatherResponse>> getWeather(String lat, String lng, String apiKey, String units){
        return dataStore.getWeather(lat, lng, apiKey, units).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<App>> getAppsThread(){
        //Log.e("Apps", "Yes");

        return Observable.create(new Observable.OnSubscribe<List<App>>() {
            @Override
            public void call(Subscriber<? super List<App>> subscriber) {
                try {
                    List<App> appList = getApps();
                    subscriber.onNext(appList);
                    subscriber.onCompleted();
                } catch (Exception e){
                    subscriber.onError(e);
                }//subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io());
    }

    private List<App> getApps(){
        List<App> appsList;
        PackageManager pm = launcherActivity.getPackageManager();
        appsList = new ArrayList<>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> allApps = pm.queryIntentActivities(i, 0);
        for(ResolveInfo ri:allApps) {
            App app = new App();
            app.setName(ri.loadLabel(pm).toString());
            app.setPackage_name(ri.activityInfo.packageName);
            app.setIcon(ri.activityInfo.loadIcon(pm));
            appsList.add(app);
        }
        //Log.e("Apps", String.valueOf(appsList.size()));

        return appsList;
    }

    public UIModel getUiModel() {
        return uiModel;
    }

    public void setUiModel(UIModel uiModel) {
        this.uiModel = uiModel;
    }

    UIModel uiModel;

    public void setUiModelInstance(Activity activity){
        uiModel = new UIModel(activity);
    }

    public class UIModel extends BaseObservable {

        Activity activity;

        public String getGreeting() {
            setGreeting();
            return greeting;
        }

        public void setGreeting(String greeting) {
            this.greeting = greeting;
        }

        String greeting;

        int internal_greeting;

        public int getInternal_greeting() {
            return internal_greeting;
        }

        public void setInternal_greeting(int internal_greeting) {
            this.internal_greeting = internal_greeting;
        }

        UIModel(Activity activity){
            this.activity = activity;
        }

        public void openDrawer(View view){
            launcherActivity.moveViewToTop();
        }

        public void openPhoneApp(View view){
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            activity.startActivity(callIntent);
        }

        public void openContactApp(View view){
            activity.startActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_APP_CONTACTS));
        }

        public void openSMSApp(View view){
            String defaultSMSpackage = Telephony.Sms.getDefaultSmsPackage(activity);
            Intent sendIntent = new Intent(Intent.ACTION_MAIN);
            sendIntent.setPackage(defaultSMSpackage);
            //sendIntent.setData(Uri.parse("sms:"));
            activity.startActivity(sendIntent);
        }

        public void openWhatsApp(View view){
            Intent sendIntent = activity.getPackageManager().getLaunchIntentForPackage("com.gbwhatsapp");
            activity.startActivity(sendIntent);
        }

        public void openEmailApp(View view){
            Intent sendIntent = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_APP_EMAIL);
            activity.startActivity(sendIntent);
        }

        public void openChromeApp(View view){
            Intent sendIntent = activity.getPackageManager().getLaunchIntentForPackage("com.android.chrome");
            //sendIntent.setData(Uri.parse("sms:"));
            activity.startActivity(sendIntent);
        }

        void setGreeting(){
            long timeStamp = System.currentTimeMillis();
            Calendar calendar = Calendar.getInstance(Locale.getDefault());
            calendar.setTimeInMillis(timeStamp);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            if (hour > 0 && hour < 12){
                greeting = "Morning, Bezaleel";
                internal_greeting = 0;
            } else if (hour >= 12 && hour <= 16) {
                greeting = "Afternoon, Bezaleel";
                internal_greeting = 1;
            } else {
                greeting = "Evening, Bezaleel";
                internal_greeting = 2;
            }

            notifyPropertyChanged(BR._all);
        }
    }
}
