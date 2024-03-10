package com.picpay.challenge.infrastructure.api;

import com.picpay.challenge.domain.entity.AuthorizationResponse;
import com.picpay.challenge.domain.exception.ApiConsumerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.picpay.challenge.domain.type.ExceptionMessagesType.API_CONSUMER_EXCEPTION;

@Component
public class AuthorizationService implements ApiConsumer {

    private final RestTemplate restTemplate;

    @Value("${authorization-service.url}")
    private String url;

    public AuthorizationService() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Object get() {

        ResponseEntity<AuthorizationResponse> response = this.restTemplate.getForEntity(this.url, AuthorizationResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        throw new ApiConsumerException(response.getStatusCode().value(), API_CONSUMER_EXCEPTION.getMessage());
    }
}
