package model.appsbyvincent.mvp_boilerplate.module.splash;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.appsbyvincent.mvp_boilerplate.R;
import com.appsbyvincent.mvp_boilerplate.databinding.ActivitySplashBinding;

import model.appsbyvincent.mvp_boilerplate.common.activity.BaseActivity;

public class SplashActivity extends BaseActivity implements SplashPresenter.ViewInterface {

    private ActivitySplashBinding binding;

    private SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        presenter = new SplashPresenter(getModel(), getRouter());

        presenter.attachView(this);

        handleIntent(getIntent());
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        presenter = null;

        binding = null;

        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.showNextScreen();
    }

    @Override
    protected void onStop() {
        presenter.cancelShowNextScreen();
        super.onStop();
    }

    private void handleIntent(Intent intent) {
        if (intent != null) {
            Uri uri = intent.getData();
            if (uri != null) {
                presenter.showScreenForUri(uri);
            }
        }
    }

    @Override
    public void showLoading() {
        binding.loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.loadingView.setVisibility(View.GONE);
    }

}
