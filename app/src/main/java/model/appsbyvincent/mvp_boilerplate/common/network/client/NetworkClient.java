package model.appsbyvincent.mvp_boilerplate.common.network.client;

import android.content.Context;

import com.appsbyvincent.mvp_boilerplate.BuildConfig;
import com.appsbyvincent.mvp_boilerplate.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import model.common.network.NetworkClientInterface;
import model.common.network.response.SingleResponse;
import model.common.store.CredentialStoreInterface;
import model.login.entity.Authorize;
import model.login.entity.Token;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class NetworkClient implements NetworkClientInterface {

    private static final String TAG = "NetworkClient";

    private final ApiService service;
    private final CredentialStoreInterface credentialStore;

    public NetworkClient(CredentialStoreInterface credentialStore, Context ctx) {
        this.credentialStore = credentialStore;

        OkHttpClient ok = new OkHttpClient();
        ok.setReadTimeout(30, TimeUnit.SECONDS);
        ok.setConnectTimeout(30, TimeUnit.SECONDS);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        String endpoint = ctx.getString(R.string.api_url);

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(request -> {
                    request.addHeader("Accept", "application/json");
                    if (credentialStore.getToken() != null) {
                        request.addHeader("X-Api-Token", credentialStore.getToken().getAccessToken());
                    }
                })
                .setClient(new OkClient(ok));

        if (BuildConfig.DEBUG) {
            builder.setLogLevel(RestAdapter.LogLevel.FULL);
        }

        service = builder.build().create(ApiService.class);
    }

    private void saveTokenFromResponse(Authorize authorize) {
        if (authorize != null) {
            Token oldToken = credentialStore.getToken();

            String accessToken = authorize.accessToken != null ? authorize.accessToken : (oldToken != null ? oldToken.getAccessToken() : null);
            String refreshToken = authorize.refreshToken != null ? authorize.refreshToken : (oldToken != null ? oldToken.getRefreshToken() : null);

            if (refreshToken != null && accessToken != null) {
                Token token = new Token(accessToken, refreshToken);
                credentialStore.setToken(token);
            }
        }
    }

    @Override
    public Observable<SingleResponse<Authorize>> authorize(String username, String password) {
        return service.authorize(username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> {
                    saveTokenFromResponse(response.getData());
                    return response;
                });
    }


}
