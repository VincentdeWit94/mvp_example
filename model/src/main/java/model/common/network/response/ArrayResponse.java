package model.common.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArrayResponse<T> extends BaseResponse {

    @SerializedName("data")
    List<T> items;

    public List<T> getItems() {
        return items;
    }
}
