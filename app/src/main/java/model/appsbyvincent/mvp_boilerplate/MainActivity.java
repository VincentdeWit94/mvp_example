package model.appsbyvincent.mvp_boilerplate;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.inputmethod.InputMethodManager;

import com.appsbyvincent.mvp_boilerplate.R;
import com.appsbyvincent.mvp_boilerplate.databinding.ActivityMainBinding;

import model.appsbyvincent.mvp_boilerplate.common.activity.BaseActivity;
import model.appsbyvincent.mvp_boilerplate.common.fragment.BaseFragment;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if (getIntent() != null && getIntent().getData() != null) {
            //openInternalUri(getIntent().getData());
        }

        startAuthorization();
        getModel().getEventBus().register(this);
    }

    public void startAuthorization(){}


    @Override
    protected void onDestroy() {
        super.onDestroy();
        getModel().getEventBus().unregister(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getApp().activityResumed();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent.getData() != null) {
            //openInternalUri(intent.getData());
        }
    }

    private void switchFragment(BaseFragment fragment, String title, boolean replace) {
        if (replace) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment, title)
                    .commit();
        }
        else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, title)
                    .commit();
        }

        // Hide keyboard when switching fragments
        InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);

        getSupportActionBar().setTitle(title);
    }

    private void pushFragmentOnCurrentStack(BaseFragment fragment, String title, boolean replace) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, title)
                .addToBackStack(fragment.getClass().getName())
                .commit();

        getSupportActionBar().setTitle(title);
    }

    public Fragment getCurrentFragment(){
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        return currentFragment;
    }

}
