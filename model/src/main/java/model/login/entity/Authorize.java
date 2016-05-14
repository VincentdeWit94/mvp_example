package model.login.entity;

import com.google.gson.annotations.SerializedName;

public class Authorize {

    @SerializedName("access_token")
    public String accessToken;

    @SerializedName("refresh_token")
    public String refreshToken;

}
