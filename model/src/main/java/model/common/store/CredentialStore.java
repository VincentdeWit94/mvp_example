package model.common.store;

import javax.annotation.Nullable;

import model.login.entity.Token;

public class CredentialStore implements CredentialStoreInterface {

    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_REFRESH_TOKEN = "refresh_token";

    private final PreferencesInterface prefs;

    public CredentialStore(PreferencesInterface prefs) {
        this.prefs = prefs;
    }

    @Override
    public Token getToken() {
        String accessToken = prefs.getString(KEY_ACCESS_TOKEN, null);
        String refreshToken = prefs.getString(KEY_REFRESH_TOKEN, null);

        if (accessToken != null && accessToken.length() > 0 && refreshToken != null && refreshToken.length() > 0) {
            return new Token(accessToken, refreshToken);
        }
        else {
            return null;
        }
    }

    @Override
    public void setToken(@Nullable Token token) {
        if (token != null) {
            prefs.putString(KEY_ACCESS_TOKEN, token.getAccessToken());
            prefs.putString(KEY_REFRESH_TOKEN, token.getRefreshToken());
        }
        else {
            prefs.remove(KEY_ACCESS_TOKEN);
            prefs.remove(KEY_REFRESH_TOKEN);
        }
    }

}
