package android.heimdallr.app.heimdallr.core.listeners;


import android.heimdallr.app.heimdallr.screens.activities.LauncherActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewDisabler extends RecyclerView.OnFlingListener {

    RecyclerView recyclerView;
    LauncherActivity launcherActivity;

    public RecyclerViewDisabler(RecyclerView recyclerView, LauncherActivity launcherActivity){
        this.recyclerView = recyclerView;
        this.launcherActivity = launcherActivity;
    }

    @Override
    public boolean onFling(int velocityX, int velocityY) {
        //Log.e("Drag", String.valueOf(velocityY));
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        if (gridLayoutManager.findFirstCompletelyVisibleItemPosition() == 0){
            launcherActivity.hideDrawerListener.hideDrawer();
        }
        return false;
    }
}