package com.picpay.challenge.application.gateway;

import com.picpay.challenge.domain.entity.AuthorizationResponse;
import com.picpay.challenge.domain.entity.NotificationResponse;

public interface ConsumeApiGateway {

    AuthorizationResponse consultTransferAthorization();
    NotificationResponse sendNotification();
}
