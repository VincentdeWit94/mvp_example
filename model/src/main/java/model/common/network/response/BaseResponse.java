package model.common.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseResponse {

    @SerializedName("message")
    public String message;

    @SerializedName("errors")
    public ArrayList<Error> errors;

}
