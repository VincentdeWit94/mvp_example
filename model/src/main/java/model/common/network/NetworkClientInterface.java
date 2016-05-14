package model.common.network;

import model.common.network.response.SingleResponse;
import model.login.entity.Authorize;
import rx.Observable;

public interface NetworkClientInterface {

    // Login

    Observable<SingleResponse<Authorize>> authorize(String username, String password);

}
