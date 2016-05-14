package model.appsbyvincent.mvp_boilerplate.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import model.appsbyvincent.mvp_boilerplate.Application;
import model.appsbyvincent.mvp_boilerplate.common.model.Model;
import model.appsbyvincent.mvp_boilerplate.router.Router;
import model.appsbyvincent.mvp_boilerplate.router.RouterInterface;

public class BaseActivity extends Activity {

    private RouterInterface router;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        router = new Router(this);
    }

    @Override
    protected void onDestroy() {
        router = null;

        super.onDestroy();
    }

    public Model getModel() {
        return getApp().getModel();
    }

    public Application getApp() {
        return ((Application) getApplication());
    }

    public RouterInterface getRouter() {
        return router;
    }

}
