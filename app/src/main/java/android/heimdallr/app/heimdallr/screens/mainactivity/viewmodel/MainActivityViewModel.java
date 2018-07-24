package android.heimdallr.app.heimdallr.screens.mainactivity.viewmodel;

import android.databinding.Bindable;
import android.heimdallr.app.heimdallr.core.database.DataStore;
import android.heimdallr.app.heimdallr.core.viewmodels.CoreViewModel;

import javax.inject.Inject;
import retrofit2.Retrofit;

public class MainActivityViewModel extends CoreViewModel {

    private DataStore dataStore;
    private Retrofit retrofit;


    private Boolean signUpFieldsValid, loginFieldsValid;

    @Bindable
    public String name;

    @Bindable
    public String email;

    @Bindable
    public String phone;


    @Inject
    public MainActivityViewModel(DataStore dataStore, Retrofit retrofit){
        this.dataStore = dataStore;
        this.retrofit = retrofit;
    }

}
