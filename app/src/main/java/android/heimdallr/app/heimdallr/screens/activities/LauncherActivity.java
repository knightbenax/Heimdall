package android.heimdallr.app.heimdallr.screens.activities;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.heimdallr.app.heimdallr.BuildConfig;
import android.heimdallr.app.heimdallr.HeimdallrApplication;
import android.heimdallr.app.heimdallr.R;
import android.heimdallr.app.heimdallr.core.api.models.WeatherResponse;
import android.heimdallr.app.heimdallr.core.daggger.components.AppMainComponent;
import android.heimdallr.app.heimdallr.core.listeners.RecyclerViewDisabler;
import android.heimdallr.app.heimdallr.core.models.App;
import android.heimdallr.app.heimdallr.core.permissions.PermissionsManager;
import android.heimdallr.app.heimdallr.core.utils.HeimdallrState;
import android.heimdallr.app.heimdallr.core.viewadapters.AppsAdapter;
import android.heimdallr.app.heimdallr.core.views.CoreActivity;
import android.heimdallr.app.heimdallr.databinding.ActivityLauncherBinding;
import android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel;
import android.location.Location;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.MotionEventCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.recyclerview.widget.GridLayoutManager;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observer;

import static android.heimdallr.app.heimdallr.core.permissions.PermissionsManager.LOCATION_PERMISSION_REQUEST_CODE;

public class LauncherActivity extends CoreActivity{


    private static final int INVALID_POINTER_ID = 5000;
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int UNKNOWN = 3;

    private static final int WHITE = 0;
    private static final int BLACK = 1;

    @Inject
    LauncherActivityViewModel launcherActivityViewModel;

    public boolean shouldHideView = true;

    public HideDrawerListener hideDrawerListener;

    PermissionsManager permissionsManager;

    AppMainComponent component;
    ActivityLauncherBinding activityLauncherBinding;

    private String UNIVERSAL_ERROR_STRING = "Something went wrong. Heimdallr couldn't process the request";
    AppsAdapter appsAdapter;
    //GestureDetectorCompat gestureDetector;
    RecyclerViewDisabler recyclerViewDisabler;

    boolean fetchApps = false;

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLauncherBinding = DataBindingUtil.setContentView(this, R.layout.activity_launcher);
        component = HeimdallrApplication.get(this).getComponent();
        component.inject(this);

        launcherActivityViewModel.setLauncherActivity(this);
        launcherActivityViewModel.setUiModelInstance(this);
        activityLauncherBinding.setModel(launcherActivityViewModel.getUiModel());

        initPermissionsManager();
        initGestureListener();
        setHeimdallrTheme(WHITE);
        loadIcons();
    }

    private void loadIcons(){
        activityLauncherBinding.phoneApp.setImageDrawable(getActivityIcon(this, "com.google.android.dialer", "com.google.android.dialer.extensions.GoogleDialtactsActivity"));
        activityLauncherBinding.contactApp.setImageDrawable(getActivityIcon(this, "com.google.android.contacts", "com.android.contacts.activities.PeopleActivity"));
        activityLauncherBinding.smsApp.setImageDrawable(getActivityIcon(this, "com.truecaller", "com.truecaller.ui.TruecallerInit"));
        //activityLauncherBinding.whatsApp.setImageDrawable(getActivityIcon(this, "com.whatsapp", "com.whatsapp.Main"));
        activityLauncherBinding.whatsApp.setImageDrawable(getActivityIcon(this, "com.gbwhatsapp", "com.gbwhatsapp.0"));
        activityLauncherBinding.emailApp.setImageDrawable(getActivityIcon(this, "com.google.android.gm", "com.google.android.gm.ConversationListActivityGmail"));
        activityLauncherBinding.chromeApp.setImageDrawable(getActivityIcon(this, "com.android.chrome", "com.google.android.apps.chrome.Main"));
    }

    public static Drawable getActivityIcon(Context context, String packageName, String activityName) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);

        return resolveInfo.loadIcon(pm);
    }

    @Override
    public void onBackPressed(){
        if (HeimdallrState.getInstance().getCurrentScreen().equals(HeimdallrState.DRAWER)){
            moveViewToBottom();
        } else {
            super.onBackPressed();
        }
    }

    private void initPermissionsManager() {
        permissionsManager = new PermissionsManager(this);
        //checkLocationPermission();
    }

    private void initGestureListener() {
        mScaleDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.SimpleOnScaleGestureListener());

         gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            public void onLongPress(MotionEvent e) {
                //Log.e("Er", "Longpress detected");
                if (theme == WHITE){
                    //change to black
                    setHeimdallrTheme(BLACK);
                    theme = BLACK;
                } else if (theme == BLACK) {
                    //change to white
                    setHeimdallrTheme(WHITE);
                    theme = WHITE;
                }
            }
        });




        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        activityLauncherBinding.appsListRecycler.setTranslationY(height);
        mPosX = width; mPosY = height;

        hideDrawerListener =  new HideDrawerListener() {
            @Override
            public void hideDrawer() {
                moveViewToBottom();
            }
        };

        recyclerViewDisabler = new RecyclerViewDisabler(activityLauncherBinding.appsListRecycler, this);
        activityLauncherBinding.appsListRecycler.setOnFlingListener(recyclerViewDisabler);
    }


    private void setHeimdallrTheme(int theme){
        switch (theme){
            case WHITE:
                TransitionManager.beginDelayedTransition(activityLauncherBinding.container);
                /*activityLauncherBinding.phoneApp.setColorFilter(null);
                activityLauncherBinding.contactApp.setColorFilter(null);
                activityLauncherBinding.smsApp.setColorFilter(null);
                activityLauncherBinding.whatsApp.setColorFilter(null);
                activityLauncherBinding.emailApp.setColorFilter(null);
                activityLauncherBinding.chromeApp.setColorFilter(null);*/
                activityLauncherBinding.arrowUp.setColorFilter(null);
                activityLauncherBinding.weatherIcon.setColorFilter(null);
                activityLauncherBinding.weatherTag.setTextColor(getResources().getColor(R.color.white));
                activityLauncherBinding.weatherTag.setShadowLayer(4, 0, 0, getResources().getColor(R.color.trans_black));
                activityLauncherBinding.greetingText.setTextColor(getResources().getColor(R.color.white));
                activityLauncherBinding.greetingText.setShadowLayer(4, 0, 0, getResources().getColor(R.color.trans_black));
                setLightStatusBar(true);
                break;
            case BLACK:
                TransitionManager.beginDelayedTransition(activityLauncherBinding.container);
                /*activityLauncherBinding.phoneApp.setColorFilter(getResources().getColor(R.color.dark_black));
                activityLauncherBinding.contactApp.setColorFilter(getResources().getColor(R.color.dark_black));
                activityLauncherBinding.smsApp.setColorFilter(getResources().getColor(R.color.dark_black));
                activityLauncherBinding.whatsApp.setColorFilter(getResources().getColor(R.color.dark_black));
                activityLauncherBinding.emailApp.setColorFilter(getResources().getColor(R.color.dark_black));
                activityLauncherBinding.chromeApp.setColorFilter(getResources().getColor(R.color.dark_black));*/
                activityLauncherBinding.arrowUp.setColorFilter(getResources().getColor(R.color.dark_black));
                activityLauncherBinding.weatherIcon.setColorFilter(getResources().getColor(R.color.dark_black));
                activityLauncherBinding.weatherTag.setTextColor(getResources().getColor(R.color.dark_black));
                activityLauncherBinding.weatherTag.setShadowLayer(0, 0, 0, getResources().getColor(R.color.trans_black));
                activityLauncherBinding.greetingText.setTextColor(getResources().getColor(R.color.dark_black));
                activityLauncherBinding.greetingText.setShadowLayer(0, 0, 0, getResources().getColor(R.color.trans_black));
                setLightStatusBar(true);
                break;
        }
    }

    private void setUpRecycler(List<App> appsList){
        appsAdapter = new AppsAdapter(this);
        appsAdapter.setAppList(appsList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        activityLauncherBinding.appsListRecycler.setAdapter(appsAdapter);
        activityLauncherBinding.appsListRecycler.setLayoutManager(gridLayoutManager);
        activityLauncherBinding.appsListRecycler.setHasFixedSize(true);
        fetchApps = true;



        /*activityLauncherBinding.appsListRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!activityLauncherBinding.appsListRecycler.canScrollVertically(-1)){

                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });*/
    }

    @Override
    public void onPause(){
        if (shouldHideView){
            moveViewToBottom();
        }
        super.onPause();
    }

    @Override
    public void onResume(){
        getApps();
        getLocation();

        super.onResume();
    }


    // The ‘active pointer’ is the one currently moving our object.
    private int mActivePointerId = INVALID_POINTER_ID;
    private ScaleGestureDetector mScaleDetector;
    float mLastTouchX = 0, mLastTouchY = 0, mPosX = 0, mPosY = 0, mDx = 0, mDy = 0;
    int height = 0, width = 0;
    int swipeDirection = UP;
    int theme = WHITE;


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Let the ScaleGestureDetector inspect all events.
        gestureDetector.onTouchEvent(ev);
        mScaleDetector.onTouchEvent(ev);


        final int action = MotionEventCompat.getActionMasked(ev);

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                final int pointerIndex = MotionEventCompat.getActionIndex(ev);
                final float x = MotionEventCompat.getX(ev, pointerIndex);
                final float y = MotionEventCompat.getY(ev, pointerIndex);

                // Remember where we started (for dragging)
                mLastTouchX = x;
                mLastTouchY = y;
                // Save the ID of this pointer (for dragging)
                mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                // Find the index of the active pointer and fetch its position
                final int pointerIndex =
                        MotionEventCompat.findPointerIndex(ev, mActivePointerId);

                final float x = MotionEventCompat.getX(ev, pointerIndex);
                final float y = MotionEventCompat.getY(ev, pointerIndex);

                // Calculate the distance moved
                final float dx = x - mLastTouchX;
                final float dy = y - mLastTouchY;

                //mDx = dx;
                //mDy = dy;

                //Log.e("Direction", String.valueOf(dy));

                if (dy < 0){
                    swipeDirection = UP;
                } else if (dy > 0) {
                    swipeDirection = DOWN;
                } else {
                    swipeDirection = UNKNOWN;
                }

                mPosX += dx;
                mPosY += dy;

                mDx = mPosY;
                mDy = mPosY;

                float alphaValue = (mPosY / height) * 1;
                alphaValue = 1 - alphaValue;
                //Log.e("Alpha", String.valueOf(alphaValue));
                activityLauncherBinding.appsListHolder.setAlpha(alphaValue);
                activityLauncherBinding.appsListRecycler.setTranslationY(mPosY);

                //Remember this touch position for the next move event
                mLastTouchX = x;
                mLastTouchY = y;
                break;
            }

            case MotionEvent.ACTION_UP: {
                mActivePointerId = INVALID_POINTER_ID;

                mDy = mPosY - mLastTouchY;
                //Log.e("Done", "Yes");
                //Log.e("DoneY", String.valueOf(mDy));
                //Log.e("DoneY", String.valueOf(mLastTouchY));

                float value = Math.abs(mDy);

                if (value > 250){
                    if (swipeDirection == UP){
                        //the finger ended up in the top part of the screen.
                        //Check if the difference is much and swipe up;
                        moveViewToTop();
                    } else if (swipeDirection == DOWN || swipeDirection == UNKNOWN){
                        //the finger ended in the bottom, so move down
                        moveViewToBottom();
                    }
                } else {
                    moveViewToBottom();
                }

                break;
            }

            case MotionEvent.ACTION_CANCEL: {
                mActivePointerId = INVALID_POINTER_ID;
                break;
            }

            case MotionEvent.ACTION_POINTER_UP: {

                final int pointerIndex = MotionEventCompat.getActionIndex(ev);
                final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);

                //Log.e("Pointer Done", "Yes");

                if (pointerId == mActivePointerId) {
                    // This was our active pointer going up. Choose a new
                    // active pointer and adjust accordingly.
                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    mLastTouchX = MotionEventCompat.getX(ev, newPointerIndex);
                    mLastTouchY = MotionEventCompat.getY(ev, newPointerIndex);
                    mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
                }
                break;
            }
        }
        return true;
    }

    public void moveViewToBottom(){
        //Log.e("Height", String.valueOf(height));
        activityLauncherBinding.appsListHolder.animate().alpha(0).setDuration(110).setStartDelay(10).setInterpolator(new AccelerateInterpolator());
        activityLauncherBinding.appsListRecycler.animate().translationY(height).setDuration(85).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                activityLauncherBinding.appsListRecycler.setNestedScrollingEnabled(false);
                activityLauncherBinding.appsListRecycler.scrollToPosition(0);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        //set mPosY back to the height;
        mPosY = height;

        HeimdallrState.getInstance().setCurrentScreen(HeimdallrState.HOME);
        setLightStatusBar(false);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(activityLauncherBinding.container);
        TransitionManager.beginDelayedTransition(activityLauncherBinding.container);
        constraintSet.applyTo(activityLauncherBinding.container);

        setVisibility(activityLauncherBinding.gestureHolder, View.VISIBLE);
        setVisibility(activityLauncherBinding.buttonsHolder, View.VISIBLE);
        setVisibility(activityLauncherBinding.topPanel, View.VISIBLE);
        activityLauncherBinding.appsListRecycler.performHapticFeedback(5);

        //activityLauncherBinding.appsListRecycler.removeOnItemTouchListener(recyclerViewDisabler);
        //setVisibility(activityLauncherBinding.appsListRecycler, View.VISIBLE);
    }

    public void moveViewToTop(){
        //setVisibility(activityLauncherBinding.appsListRecycler, View.VISIBLE);
        //activityLauncherBinding.appsListHolder.
        activityLauncherBinding.appsListHolder.animate().alpha(1).setDuration(110).setStartDelay(10).setInterpolator(new AccelerateInterpolator());
        activityLauncherBinding.appsListRecycler.animate().translationY(0).setDuration(85).setInterpolator(new FastOutSlowInInterpolator());
        HeimdallrState.getInstance().setCurrentScreen(HeimdallrState.DRAWER);
        setLightStatusBar(true);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(activityLauncherBinding.container);
        TransitionManager.beginDelayedTransition(activityLauncherBinding.container);
        constraintSet.applyTo(activityLauncherBinding.container);

        setVisibility(activityLauncherBinding.gestureHolder, View.GONE);
        setVisibility(activityLauncherBinding.buttonsHolder, View.GONE);
        setVisibility(activityLauncherBinding.topPanel, View.GONE);

        //activityLauncherBinding.appsListRecycler.addOnItemTouchListener(recyclerViewDisabler);
        activityLauncherBinding.appsListRecycler.setNestedScrollingEnabled(true);
        activityLauncherBinding.appsListRecycler.performHapticFeedback(5);
        //setVisibility(activityLauncherBinding.appsListRecycler, View.VISIBLE);
    }

    private void setVisibility(View view, int visibility){
        view.setVisibility(visibility);
    }

    private int getVisibility(View view){
        return view.getVisibility();
    }

    private void getApps(){
        launcherActivityViewModel.getAppsThread().subscribe(new Observer<List<App>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.e("Apps Error", e.getMessage());
            }

            @Override
            public void onNext(final List<App> apps) {

                Collections.sort(apps, new Comparator<App>() {
                    @Override
                    public int compare(App s1, App s2) {
                        return s1.getName().compareToIgnoreCase(s2.getName());
                    }
                });

                if (fetchApps){
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           appsAdapter.setAppList(apps);
                           appsAdapter.notifyDataSetChanged();
                       }
                   });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setUpRecycler(apps);
                        }
                    });
                }
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation(){
        //Log.e("Get", "Location");
        if (permissionsManager.checkPermissionForLocation()){
            FusedLocationProviderClient mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

            mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        setWeather(location);
                        Log.e("Find Location", "Yes");
                        // Logic to handle location object
                    }
                }
            });
        } else {
            permissionsManager.requestPermissionForLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grantResult){
        super.onRequestPermissionsResult(requestCode, permission, grantResult);
           switch (requestCode){
               case LOCATION_PERMISSION_REQUEST_CODE:
                   if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED){
                       getLocation();
                   }
                   break;
           }
    }

    @SuppressLint("NewApi")
    private void setWeather(Location location){
        launcherActivityViewModel.getWeather(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()), BuildConfig.WeatherAPIKey, "metric").subscribe(new Observer<Response<WeatherResponse>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                //Log.e("Find Location", e.getMessage());
            }

            @Override
            public void onNext(Response<WeatherResponse> weatherResponseResponse) {
                int responseCode = weatherResponseResponse.code();
                //Log.e("Response", String.valueOf(responseCode));
                switch (responseCode){
                    case 200:
                        String temp = weatherResponseResponse.body().getMain().getTemp().toString();
                        //activityLauncherBinding.weatherTag.setText(Html.fromHtml(temp + "<sup>°</sup>C", 0));
                        activityLauncherBinding.weatherTag.setText(temp + "°c");
                        //Log.e("Temp", temp);
                        setWeatherIcon(weatherResponseResponse.body().getWeather().get(0).getId());
                        setVisibility(activityLauncherBinding.weatherHolder, View.VISIBLE);
                        break;
                }
            }
        });
    }


    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    private void setWeatherIcon(int weatherIcon){
        //Log.e("Icon", String.valueOf(weatherIcon));
        if (isBetween(weatherIcon, 200, 232)) {
            //RAIN AND THUNDERSTORM
            activityLauncherBinding.weatherIcon.setImageDrawable(getResources().getDrawable(R.drawable.thunderstorm));
        } else if (isBetween(weatherIcon, 300, 321)) {
            //DRIZZLE
            activityLauncherBinding.weatherIcon.setImageDrawable(getResources().getDrawable(R.drawable.drizzle));
        } else if (isBetween(weatherIcon, 500, 522)) {
            //RAIN
            activityLauncherBinding.weatherIcon.setImageDrawable(getResources().getDrawable(R.drawable.rain));
        } else if (isBetween(weatherIcon, 600, 621)) {
            //SNOW
            activityLauncherBinding.weatherIcon.setImageDrawable(getResources().getDrawable(R.drawable.snow));
        } else if (isBetween(weatherIcon, 701, 741)) {
            //MIST
            activityLauncherBinding.weatherIcon.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        } else if (weatherIcon == 800) {
            //CLOUDS_CLEAR
            if (launcherActivityViewModel.getUiModel().getInternal_greeting() == 2){
                activityLauncherBinding.weatherIcon.setImageDrawable(getResources().getDrawable(R.drawable.moon));
            } else {
                activityLauncherBinding.weatherIcon.setImageDrawable(getResources().getDrawable(R.drawable.sun));
            }
        } else if (isBetween(weatherIcon, 801, 803)) {
            //CLOUDS
            if (launcherActivityViewModel.getUiModel().getInternal_greeting() == 2){
                activityLauncherBinding.weatherIcon.setImageDrawable(getResources().getDrawable(R.drawable.cloud_moon));
            } else {
                activityLauncherBinding.weatherIcon.setImageDrawable(getResources().getDrawable(R.drawable.clouds_sun));
            }
        } else if (weatherIcon == 804){
            activityLauncherBinding.weatherIcon.setImageDrawable(getResources().getDrawable(R.drawable.clouds_few));
        }

    }

    /**
     * This hombre helps us to filter messages from the errorbody
     * **/
    private String getErrorMessageFromStream(ResponseBody errorResponse){
        String message;

        try {
            message = errorResponse.string();
        } catch (IOException e) {
            message = UNIVERSAL_ERROR_STRING;
            e.printStackTrace();
        }

        JSONObject mainObject;
        try {
            mainObject = new JSONObject(message);
            message = mainObject.getString("message");
        } catch (JSONException e) {
            message = UNIVERSAL_ERROR_STRING;
            e.printStackTrace();
        }

        return message;
    }

    public interface HideDrawerListener{
        void hideDrawer();
    }
}
