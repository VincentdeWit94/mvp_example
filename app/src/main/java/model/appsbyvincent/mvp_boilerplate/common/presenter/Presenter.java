package model.appsbyvincent.mvp_boilerplate.common.presenter;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Presenter<V extends Presenter.ViewInterface> {

    public interface ViewInterface {
    }

    private V view;

    @Nullable
    public final V getView() {
        return view;
    }

    public final void attachView(@NonNull V view) {
        detachView();
        this.view = view;
        onAttachView();
    }

    public final void detachView() {
        if (view != null) {
            onDetachView();
            view = null;
        }
    }

    public final boolean isAttached() {
        return view != null;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        view = null;
    }

    @CallSuper
    public void saveInstanceState(@NonNull Bundle outState) {
    }

    @CallSuper
    public void restoreInstanceState(@NonNull Bundle savedInstanceState) {
    }

    @CallSuper
    protected void onAttachView() {
    }

    @CallSuper
    protected void onDetachView() {
    }

}
