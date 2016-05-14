package model.appsbyvincent.mvp_boilerplate;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import model.appsbyvincent.mvp_boilerplate.common.model.Model;

public class Application extends android.app.Application {

    private static final String TAG = "Application";

    @Nullable
    private Model model = null;

    private boolean activityVisible = false;

    @Override
    public void onCreate() {
        super.onCreate();

        model = new Model(this);
    }

    @NonNull
    public Model getModel() {
        assert model != null;
        return model;
    }

    public boolean isActivityVisible() {
        return activityVisible;
    }

    public void activityResumed() {
        activityVisible = true;
    }

    public void activityPaused() {
        activityVisible = false;
    }

}
