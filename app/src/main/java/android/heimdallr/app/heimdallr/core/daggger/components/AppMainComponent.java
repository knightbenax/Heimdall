package android.heimdallr.app.heimdallr.core.daggger.components;

import android.heimdallr.app.heimdallr.HeimdallrApplication;
import android.heimdallr.app.heimdallr.core.daggger.modules.network.ContextModule;
import android.heimdallr.app.heimdallr.core.daggger.modules.viewmodels.CoreViewModelModule;
import android.heimdallr.app.heimdallr.core.daggger.modules.viewmodels.MainActivityViewModelModule;
import android.heimdallr.app.heimdallr.core.daggger.permissions.PermissionsManagerModule;
import android.heimdallr.app.heimdallr.core.views.CoreActivity;
import android.heimdallr.app.heimdallr.screens.mainactivity.activity.MainActivity;

import dagger.Component;


@Component(modules = {ContextModule.class, CoreViewModelModule.class, MainActivityViewModelModule.class, PermissionsManagerModule.class})

public interface AppMainComponent {
    void inject(MainActivity homeActivity);
    void inject(HeimdallrApplication application);
    void inject(CoreActivity coreActivity);
}
