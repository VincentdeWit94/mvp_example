package model.common.store;

import javax.annotation.Nullable;

import model.login.entity.Token;


public interface CredentialStoreInterface {

    @Nullable
    Token getToken();

    void setToken(@Nullable Token token);

}
