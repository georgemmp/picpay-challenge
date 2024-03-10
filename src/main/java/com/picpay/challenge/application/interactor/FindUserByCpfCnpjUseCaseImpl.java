package com.picpay.challenge.application.interactor;

import com.picpay.challenge.application.gateway.UserGateway;
import com.picpay.challenge.application.usecase.FindUserByCpfCnpjUseCase;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.domain.exception.NotFoundException;
import com.picpay.challenge.domain.type.ExceptionMessagesType;

public class FindUserByCpfCnpjUseCaseImpl implements FindUserByCpfCnpjUseCase {

    private final UserGateway userGateway;

    public FindUserByCpfCnpjUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(String cpfCnpj) {
        User user = this.userGateway.findByCpfCnpj(cpfCnpj);

        if (user == null) {
            throw new NotFoundException(404, ExceptionMessagesType.USER_NOT_FOUND.getMessage());
        }

        return user;
    }
}
