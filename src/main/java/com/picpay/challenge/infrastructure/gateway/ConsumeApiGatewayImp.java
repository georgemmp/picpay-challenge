package com.picpay.challenge.infrastructure.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.picpay.challenge.application.gateway.ConsumeApiGateway;
import com.picpay.challenge.domain.entity.AuthorizationResponse;
import com.picpay.challenge.domain.entity.NotificationResponse;
import com.picpay.challenge.infrastructure.api.ApiConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumeApiGatewayImp implements ConsumeApiGateway {

    private final ApiConsumer transferAuthorizationClient;

    private final ApiConsumer notificationClient;

    @Override
    public AuthorizationResponse consultTransferAthorization() {
        return (AuthorizationResponse) this.transferAuthorizationClient.get();
    }

    @Override
    public NotificationResponse sendNotification() {
        return (NotificationResponse) this.notificationClient.get();
    }
}
