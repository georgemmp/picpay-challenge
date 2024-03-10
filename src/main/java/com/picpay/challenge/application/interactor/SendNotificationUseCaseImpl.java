package com.picpay.challenge.application.interactor;

import com.picpay.challenge.application.gateway.ConsumeApiGateway;
import com.picpay.challenge.application.usecase.SendNotificationUseCase;
import com.picpay.challenge.domain.entity.NotificationResponse;
import com.picpay.challenge.domain.exception.InternalServerError;
import com.picpay.challenge.domain.type.ExceptionMessagesType;

public class SendNotificationUseCaseImpl implements SendNotificationUseCase {

    private final ConsumeApiGateway consumeApiGateway;

    public SendNotificationUseCaseImpl(ConsumeApiGateway consumeApiGateway) {
        this.consumeApiGateway = consumeApiGateway;
    }

    @Override
    public void execute() {
        NotificationResponse response = this.consumeApiGateway.sendNotification();

        if (!response.message()) {
            throw new InternalServerError(500, ExceptionMessagesType.NOTIFICATION_ERROR.getMessage());
        }
    }
}
