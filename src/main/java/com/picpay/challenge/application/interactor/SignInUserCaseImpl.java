package com.picpay.challenge.application.interactor;

import com.picpay.challenge.application.gateway.AuthenticationGateway;
import com.picpay.challenge.application.usecase.FindUserByEmailUseCase;
import com.picpay.challenge.application.usecase.SignInUserCase;
import com.picpay.challenge.domain.entity.Token;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.domain.entity.UserAuthentication;
import com.picpay.challenge.domain.exception.ForbiddenException;
import com.picpay.challenge.domain.type.ExceptionMessagesType;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class SignInUserCaseImpl implements SignInUserCase {

    @Value("${security.jwt.token.expire-length:3600000}")
    private Long validityInMilliSeconds;
    private final FindUserByEmailUseCase findUserByEmailUseCase;
    private final AuthenticationGateway authenticationGateway;

    public SignInUserCaseImpl(FindUserByEmailUseCase findUserByEmailUseCase,
                              AuthenticationGateway authenticationGateway) {
        this.findUserByEmailUseCase = findUserByEmailUseCase;
        this.authenticationGateway = authenticationGateway;
    }

    @Override
    public Token execute(UserAuthentication userAuthentication) {
        try {
            Date now = new Date();
            Date accessTokenValidity = new Date(now.getTime() + this.validityInMilliSeconds);
            Date refreshTokenValidity = new Date(now.getTime() + (this.validityInMilliSeconds * 3));

            this.authenticationGateway.authentication(userAuthentication);
            User user = this.findUserByEmailUseCase.execute(userAuthentication.getEmail());

            return this.authenticationGateway.createJwtToken(user.getEmail(), accessTokenValidity, refreshTokenValidity);
        } catch (Exception e) {
            throw new ForbiddenException(403, ExceptionMessagesType.INVALID_CREDENTIALS.getMessage());
        }
    }
}
