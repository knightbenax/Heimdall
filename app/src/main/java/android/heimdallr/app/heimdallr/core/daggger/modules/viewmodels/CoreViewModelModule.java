package android.heimdallr.app.heimdallr.core.daggger.modules.viewmodels;


import android.heimdallr.app.heimdallr.core.daggger.modules.network.RetrofitModule;
import android.heimdallr.app.heimdallr.core.viewmodels.CoreViewModel;

import dagger.Module;
import dagger.Provides;


@Module(includes = {RetrofitModule.class})
public class CoreViewModelModule {

    @Provides
    public CoreViewModel provideCoreViewModel() {
        return new CoreViewModel();
    }
}
