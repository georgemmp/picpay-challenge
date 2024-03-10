package com.picpay.challenge.application.interactor;

import com.picpay.challenge.application.gateway.ConsumeApiGateway;
import com.picpay.challenge.application.usecase.ConsultAuthorizingServiceUseCase;
import com.picpay.challenge.domain.entity.AuthorizationResponse;
import com.picpay.challenge.domain.exception.BadRequestException;
import com.picpay.challenge.domain.type.ExceptionMessagesType;

public class ConsultAuthorizingServiceUseCaseImpl implements ConsultAuthorizingServiceUseCase {

    private final ConsumeApiGateway consumeApiGateway;

    public ConsultAuthorizingServiceUseCaseImpl(ConsumeApiGateway consumeApiGateway) {
        this.consumeApiGateway = consumeApiGateway;
    }

    @Override
    public void execute() {
        AuthorizationResponse authorizationResponse = this.consumeApiGateway.consultTransferAthorization();

        if(!authorizationResponse.message().equals("Autorizado")) {
            throw new BadRequestException(400, ExceptionMessagesType.TRANSFER_NOT_AUTHORIZED.getMessage());
        }
    }
}
