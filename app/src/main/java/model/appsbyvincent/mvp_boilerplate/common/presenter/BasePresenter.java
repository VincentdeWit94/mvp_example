package model.appsbyvincent.mvp_boilerplate.common.presenter;

import android.support.annotation.NonNull;

import model.appsbyvincent.mvp_boilerplate.common.model.Model;
import model.appsbyvincent.mvp_boilerplate.router.RouterInterface;

/**
 * Created by joris on 18/02/16.
 */
public class BasePresenter<V extends BasePresenter.ViewInterface> extends Presenter<V> {

    public interface ViewInterface extends Presenter.ViewInterface {
    }

    private final RouterInterface router;
    private final Model model;

    public BasePresenter(@NonNull Model model, @NonNull RouterInterface router) {
        this.model = model;
        this.router = router;
    }

    @Override
    protected void onAttachView() {
        super.onAttachView();
    }

    @Override
    protected void onDetachView() {
        super.onDetachView();
    }

    @NonNull
    public RouterInterface getRouter() {
        return router;
    }

    @NonNull
    public Model getModel() {
        return model;
    }

}
