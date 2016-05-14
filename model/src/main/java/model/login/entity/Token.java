package model.login.entity;

import javax.annotation.Nonnull;

public class Token {

    @Nonnull
    private final String accessToken;

    @Nonnull
    private final String refreshToken;

    public Token(@Nonnull String accessToken, @Nonnull String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    @Nonnull
    public String getAccessToken() {
        return accessToken;
    }

    @Nonnull
    public String getRefreshToken() {
        return refreshToken;
    }

}
