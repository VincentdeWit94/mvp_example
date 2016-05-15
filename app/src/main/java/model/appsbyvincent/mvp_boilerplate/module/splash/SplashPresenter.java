package model.appsbyvincent.mvp_boilerplate.module.splash;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.appsbyvincent.mvp_boilerplate.R;

import java.util.concurrent.TimeUnit;

import model.appsbyvincent.mvp_boilerplate.common.model.Model;
import model.appsbyvincent.mvp_boilerplate.common.presenter.BasePresenter;
import model.appsbyvincent.mvp_boilerplate.router.RouterInterface;
import model.login.datamanager.LoginDataManager;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class SplashPresenter extends BasePresenter<SplashPresenter.ViewInterface> {

    private static final String TAG = "Splash";

    public interface ViewInterface extends BasePresenter.ViewInterface {
        void showLoading();
        void hideLoading();
    }

    private static final int SPLASH_TIME = 1000;

    private final LoginDataManager loginDataManager;

    private Subscription nextScreenSubscription;

    public SplashPresenter(@NonNull Model model, @NonNull RouterInterface router) {
        super(model, router);

        LoginDataManager dataManager = new LoginDataManager(getModel().getCredentialStore(), getModel().getNetworkClient());
        this.loginDataManager = dataManager;
    }

    public void showNextScreen() {
        boolean loggedIn = loginDataManager.isLoggedIn();
        if (loggedIn) {
            // Perform the "me" call if needed, and redirect to main screen
//            Observable<Boolean> observable = Observable.zip(
//                    // User call
//                    Observable.just(true)
//                            .delay(SPLASH_TIME, TimeUnit.MILLISECONDS),
//                    (a, b) -> b);
//
//            nextScreenSubscription = observable
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(result -> {
//                        getRouter().openUri(null);
//                    }, error -> {
//                        Log.w(TAG, error);
//                    });
        }
        else {
            // Redirect to login screen
            nextScreenSubscription = Observable.just(true)
                    .delay(SPLASH_TIME, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(result -> {
                        getRouter().openUri(Uri.parse(getModel().getContext().getString(R.string.internal_url_prefix)+"://welcome"));
                    });
        }
    }

    public void cancelShowNextScreen() {
        nextScreenSubscription.unsubscribe();
        nextScreenSubscription = null;
    }

    public void showScreenForUri(@Nullable Uri uri) {
        getRouter().openUri(uri);
    }

}
