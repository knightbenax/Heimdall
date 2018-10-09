package android.heimdallr.app.heimdallr.core.daggger.components;

import android.heimdallr.app.heimdallr.HeimdallrApplication;
import android.heimdallr.app.heimdallr.core.daggger.modules.network.ContextModule;
import android.heimdallr.app.heimdallr.core.daggger.modules.viewmodels.CoreViewModelModule;
import android.heimdallr.app.heimdallr.core.daggger.modules.viewmodels.LauncherActivityViewModelModule;
import android.heimdallr.app.heimdallr.core.daggger.permissions.PermissionsManagerModule;
import android.heimdallr.app.heimdallr.core.views.CoreActivity;
import android.heimdallr.app.heimdallr.screens.activities.LauncherActivity;
import android.heimdallr.app.heimdallr.screens.activities.MainActivity;

import dagger.Component;


@Component(modules = {ContextModule.class, CoreViewModelModule.class, LauncherActivityViewModelModule.class, PermissionsManagerModule.class})

public interface AppMainComponent {
    void inject(MainActivity homeActivity);
    void inject(LauncherActivity homeActivity);
    void inject(HeimdallrApplication application);
    void inject(CoreActivity coreActivity);
}
