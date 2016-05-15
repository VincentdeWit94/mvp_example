package model.login.datamanager;

import javax.annotation.Nonnull;

import model.common.network.NetworkClientInterface;
import model.common.store.CredentialStoreInterface;
import model.login.entity.Authorize;
import model.login.entity.Token;
import rx.Observable;

public class LoginDataManager {

    private static final String TAG = "Login";

    @Nonnull
    private final CredentialStoreInterface credentialStore;

    @Nonnull
    private final NetworkClientInterface networkClient;

    public LoginDataManager(@Nonnull CredentialStoreInterface credentialStore, @Nonnull NetworkClientInterface networkClient) {
        this.credentialStore = credentialStore;
        this.networkClient = networkClient;
    }

    public boolean isLoggedIn() {
        return credentialStore.getToken() != null;
    }

    @Nonnull
    public Observable<Authorize> login(String username, String password) {
        credentialStore.setToken(null);

        return clearAll()
                .flatMap(success -> {
                    if (success) {
                        return authorize(username, password);
                    }
                    else {
                        return Observable.just(null);
                    }
                });
    }

    @Nonnull
    public Observable<Boolean> logout() {
        return clearAll();
    }

    @Nonnull
    private Observable<Boolean> clearAll() {
        return Observable.create(subscriber -> {
            credentialStore.setToken(null);
            subscriber.onNext(true);
            subscriber.onCompleted();
        });
    }

    @Nonnull
    private Observable<Authorize> authorize(@Nonnull String username, @Nonnull String password) {
        return networkClient.authorize(username, password)
                .map(response -> {
                    if(response.getData().accessToken.length() > 0 && response.getData().refreshToken.length() > 0){
                        Token token = new Token(response.getData().accessToken, response.getData().refreshToken);
                        credentialStore.setToken(token);
                    }
                    return response.getData();
                });
    }

}
