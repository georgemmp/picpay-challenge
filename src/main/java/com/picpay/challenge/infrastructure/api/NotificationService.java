package com.picpay.challenge.infrastructure.api;

import com.picpay.challenge.domain.entity.NotificationResponse;
import com.picpay.challenge.domain.exception.ApiConsumerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.picpay.challenge.domain.type.ExceptionMessagesType.API_CONSUMER_EXCEPTION;

@Component
public class NotificationService implements ApiConsumer {

    private final RestTemplate restTemplate;

    @Value("${notification-service.url}")
    private String url;

    public NotificationService() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Object get() {

        ResponseEntity<NotificationResponse> response = this.restTemplate.getForEntity(this.url, NotificationResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        throw new ApiConsumerException(response.getStatusCode().value(), API_CONSUMER_EXCEPTION.getMessage());
    }
}
