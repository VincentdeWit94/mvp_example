package model.common.network.response;

import com.google.gson.annotations.SerializedName;

public class SingleResponse<T> extends BaseResponse {

    @SerializedName("data")
    T data;

    public T getData() {
        return data;
    }
}
