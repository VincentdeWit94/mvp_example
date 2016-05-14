package model.appsbyvincent.mvp_boilerplate.common.fragment;

import android.os.Bundle;

import model.appsbyvincent.mvp_boilerplate.Application;
import model.appsbyvincent.mvp_boilerplate.MainActivity;
import model.appsbyvincent.mvp_boilerplate.common.activity.BaseActivity;
import model.appsbyvincent.mvp_boilerplate.common.model.Model;
import model.appsbyvincent.mvp_boilerplate.router.RouterInterface;

/**
 * Created by joris on 18/02/16.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public Model getModel() {
        return ((Application) getActivity().getApplication()).getModel();
    }

    public RouterInterface getRouter() {
        return ((BaseActivity) getActivity()).getRouter();
    }

    public void setTitle(int title) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(this.getString(title));
    }
}
