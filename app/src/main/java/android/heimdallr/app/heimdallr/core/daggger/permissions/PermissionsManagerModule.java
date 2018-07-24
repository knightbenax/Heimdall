package android.heimdallr.app.heimdallr.core.daggger.permissions;

import android.app.Activity;
import android.heimdallr.app.heimdallr.core.daggger.modules.externaldependency.ActivityModule;
import android.heimdallr.app.heimdallr.core.permissions.PermissionsManager;

import dagger.Module;
import dagger.Provides;


@Module(includes = {ActivityModule.class})
public class PermissionsManagerModule {

    @Provides
    public PermissionsManager providePermissionsManager(Activity activity) {
        return new PermissionsManager(activity);
    }
}
