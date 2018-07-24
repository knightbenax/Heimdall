package android.heimdallr.app.heimdallr.core.daggger.modules.viewmodels;

import android.heimdallr.app.heimdallr.core.daggger.modules.network.RetrofitModule;
import android.heimdallr.app.heimdallr.core.daggger.modules.store.DataStoreModule;
import android.heimdallr.app.heimdallr.core.database.DataStore;
import android.heimdallr.app.heimdallr.screens.mainactivity.viewmodel.MainActivityViewModel;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module(includes = {DataStoreModule.class, RetrofitModule.class})
public class MainActivityViewModelModule {

    @Provides
    public MainActivityViewModel provideHomeActivityViewModel(DataStore datastore, Retrofit retrofit) {
        return new MainActivityViewModel(datastore, retrofit);
    }
}
