package android.heimdallr.app.heimdallr.core.database;

import android.heimdallr.app.heimdallr.core.api.services.AuthService;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class OnlineStore {


    private Retrofit retrofit;
    private AuthService authService;


    @Inject
    public OnlineStore(Retrofit retrofit){
        this.retrofit = retrofit;

        authService = retrofit.create(AuthService.class);

    }

}
