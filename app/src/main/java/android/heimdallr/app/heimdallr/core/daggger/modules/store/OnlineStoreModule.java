package android.heimdallr.app.heimdallr.core.daggger.modules.store;

import android.heimdallr.app.heimdallr.core.daggger.modules.network.RetrofitModule;
import android.heimdallr.app.heimdallr.core.database.OnlineStore;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module(includes = {RetrofitModule.class})
public class OnlineStoreModule {

    @Provides
    public OnlineStore provideOnlineStore(Retrofit retrofit){
        return new OnlineStore(retrofit);
    }

}
