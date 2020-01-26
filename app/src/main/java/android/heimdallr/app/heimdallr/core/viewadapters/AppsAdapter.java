package android.heimdallr.app.heimdallr.core.viewadapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.heimdallr.app.heimdallr.R;
import android.heimdallr.app.heimdallr.core.models.App;
import android.heimdallr.app.heimdallr.databinding.LayoutSingleAppBinding;
import android.heimdallr.app.heimdallr.screens.activities.LauncherActivity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.ViewHolder> {

    private Context mContext;

    private List<App> appList = new ArrayList<>();

    LauncherActivity activity;

    // 1
    public AppsAdapter(LauncherActivity activity) {
        this.mContext = activity;
        this.activity = activity;
    }

    public List<App> getAppList() {
        return appList;
    }

    public void setAppList(List<App> appList) {
        this.appList = appList;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutSingleAppBinding layoutSingleAppBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.layout_single_app, parent, false);
        return new ViewHolder(layoutSingleAppBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        App app = appList.get(position);
        holder.layoutSingleAppBinding.setModel(app);
        holder.layoutSingleAppBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(appList.get(position).getPackage_name());
                mContext.startActivity(intent);
            }
        });

        holder.layoutSingleAppBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                activity.shouldHideView = false;
                Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + appList.get(position).getPackage_name()));
                mContext.startActivity(intent);
                activity.moveViewToBottom();
                activity.shouldHideView = true;
                return false;
            }
        });
        //holder.layoutSingleAppBinding.setGame(extendedGame);
        //holder.layoutSingleAppBinding.setPosition(position);
    }


    @Override
    public int getItemCount() {
        return appList.size();
    }


    public void removeAt(int position){
        //removeExtendGame(position);
        appList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, appList.size());

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public LayoutSingleAppBinding layoutSingleAppBinding;

        public ViewHolder(LayoutSingleAppBinding layoutSingleAppBinding) {
            super(layoutSingleAppBinding.getRoot());
            this.layoutSingleAppBinding = layoutSingleAppBinding;
            //layoutSingleAppBinding.getRoot().setOnClickListener(this);
            //layoutSingleAppBinding.getRoot().setOnLongClickListener(this);


        }

    }

}
