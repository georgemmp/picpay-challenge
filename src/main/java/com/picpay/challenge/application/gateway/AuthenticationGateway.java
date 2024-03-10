package com.picpay.challenge.application.gateway;

import com.picpay.challenge.domain.entity.Token;
import com.picpay.challenge.domain.entity.UserAuthentication;

import java.util.Date;

public interface AuthenticationGateway {

    void authentication(UserAuthentication userAuthentication);
    Token createJwtToken(String email, Date accessTokenValidity, Date refreshTokenValidity);
}
