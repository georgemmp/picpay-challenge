package com.picpay.challenge.application.interactor;

import com.picpay.challenge.application.gateway.UserGateway;
import com.picpay.challenge.application.usecase.FindUserByEmailUseCase;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.domain.exception.NotFoundException;
import com.picpay.challenge.domain.type.ExceptionMessagesType;

public class FindUserByEmailUseCaseImpl implements FindUserByEmailUseCase {

    private final UserGateway userGateway;

    public FindUserByEmailUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(String email) {
        User user = this.userGateway.findByEmail(email);

        if (user == null) {
            throw new NotFoundException(404, ExceptionMessagesType.USER_NOT_FOUND.getMessage());
        }

        return user;
    }
}
