package android.heimdallr.app.heimdallr.screens.activities;

import androidx.databinding.DataBindingUtil;
import android.heimdallr.app.heimdallr.HeimdallrApplication;
import android.heimdallr.app.heimdallr.R;
import android.heimdallr.app.heimdallr.core.daggger.components.AppMainComponent;
import android.heimdallr.app.heimdallr.core.views.CoreActivity;
import android.heimdallr.app.heimdallr.databinding.ActivityMainBinding;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends CoreActivity {

    private TextView mTextMessage;

    ActivityMainBinding binding;

    AppMainComponent component;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        component = HeimdallrApplication.get(this).getComponent();
        component.inject(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private boolean checkString(){
        boolean value;

        String message = "9Assa";

        char firstChar = message.charAt(0);
        String firstCharAsString =  String.valueOf(firstChar);

        value = firstCharAsString.matches("[A-Z]+");

        return value;
    }

    private boolean checkUpperCase(String value){
        char firstChar = value.charAt(0);
        String firstCharAsString =  String.valueOf(firstChar);

        return firstCharAsString.matches("[A-Z]+");
    }

}
