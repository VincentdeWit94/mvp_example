package model.login.entity;

import com.google.gson.annotations.SerializedName;

public class Tokens {
    @SerializedName("access_token")
    String access_token;

    @SerializedName("refresh_token")
    String refresh_token;

    public String getAccess_token ()
    {
        return access_token;
    }

    public void setAccess_token (String access_token)
    {
        this.access_token = access_token;
    }

    public String getRefresh_token ()
    {
        return refresh_token;
    }

    public void setRefresh_token (String refresh_token)
    {
        this.refresh_token = refresh_token;
    }
}
