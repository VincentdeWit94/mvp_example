package model.common.entity;

import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("title")
    public String title;

    @SerializedName("detail")
    public String detail;

    @SerializedName("status")
    public int status;

}
