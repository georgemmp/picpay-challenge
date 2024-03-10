package com.picpay.challenge.infrastructure.gateway;

import com.picpay.challenge.application.gateway.PasswordEncoderGateway;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderGatewayImpl implements PasswordEncoderGateway {

    @Override
    public String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
