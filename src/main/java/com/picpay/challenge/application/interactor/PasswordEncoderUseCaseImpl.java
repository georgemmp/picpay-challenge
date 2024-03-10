package com.picpay.challenge.application.interactor;

import com.picpay.challenge.application.gateway.PasswordEncoderGateway;
import com.picpay.challenge.application.usecase.PasswordEncoderUseCase;

public class PasswordEncoderUseCaseImpl implements PasswordEncoderUseCase {

    private final PasswordEncoderGateway passwordEncoderGateway;

    public PasswordEncoderUseCaseImpl(PasswordEncoderGateway passwordEncoderGateway) {
        this.passwordEncoderGateway = passwordEncoderGateway;
    }

    @Override
    public String execute(String password) {
        return this.passwordEncoderGateway.encodePassword(password);
    }
}
