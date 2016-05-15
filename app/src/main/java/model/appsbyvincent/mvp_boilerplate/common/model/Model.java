package model.appsbyvincent.mvp_boilerplate.common.model;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.squareup.otto.Bus;

import javax.annotation.Nonnull;

import model.appsbyvincent.mvp_boilerplate.common.network.client.NetworkClient;
import model.appsbyvincent.mvp_boilerplate.common.utils.SharedPreferencesWrapper;
import model.common.network.NetworkClientInterface;
import model.common.store.CredentialStore;
import model.common.store.CredentialStoreInterface;
import model.common.store.PreferencesInterface;

public class Model {

    @NonNull private final Context context;
    @NonNull private final Bus eventBus;

    @NonNull private final CredentialStoreInterface credentialStore;
    @NonNull private final NetworkClientInterface networkClient;

    //@NonNull private final SocketClient socketClient;
    @Nonnull private final PreferencesInterface preferencesInterface;

    public Model(@NonNull Context context) {
        this.context = context;
        this.eventBus = new Bus();

        this.preferencesInterface = new SharedPreferencesWrapper(PreferenceManager.getDefaultSharedPreferences(context));

        this.credentialStore = new CredentialStore(this.preferencesInterface);
        this.networkClient = new NetworkClient(credentialStore, context);
    }

    @NonNull
    public Context getContext() {
        return context;
    }

    @NonNull
    public Bus getEventBus() {
        return eventBus;
    }

    @NonNull
    public CredentialStoreInterface getCredentialStore() {
        return credentialStore;
    }

    @NonNull
    public NetworkClientInterface getNetworkClient() {
        return networkClient;
    }

}
