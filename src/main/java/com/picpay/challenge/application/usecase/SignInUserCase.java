package com.picpay.challenge.application.usecase;

import com.picpay.challenge.domain.entity.Token;
import com.picpay.challenge.domain.entity.UserAuthentication;

public interface SignInUserCase {

    Token execute(UserAuthentication userAuthentication);
}
