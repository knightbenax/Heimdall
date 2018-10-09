package android.heimdallr.app.heimdallr.core.utils;

public class HeimdallrState {

    private static HeimdallrState heimdallrState;

    public static final String HOME = "home";
    public static final String DRAWER = "drawer";

    private String currentScreen = "";

    public String getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(String currentScreen) {
        this.currentScreen = currentScreen;
    }

    public static  HeimdallrState getInstance(){
        /**
         * Only need this created once
         * **/

        if (heimdallrState == null) {
            synchronized (HeimdallrState.class) {
                if (heimdallrState == null) {
                    heimdallrState = new  HeimdallrState();
                }
            }
        }

        return heimdallrState;
    }

}
