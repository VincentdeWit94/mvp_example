package model.appsbyvincent.mvp_boilerplate.common.network.client;

import model.common.network.response.SingleResponse;
import model.login.entity.Authorize;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

public interface ApiService {

    // Login
    @FormUrlEncoded
    @POST("/v1/authorize")
    Observable<SingleResponse<Authorize>> authorize(@Field("email") String email, @Field("password") String password);

}
