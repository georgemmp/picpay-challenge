package com.picpay.challenge.infrastructure.gateway;

import com.picpay.challenge.application.gateway.AuthenticationGateway;
import com.picpay.challenge.domain.entity.Token;
import com.picpay.challenge.domain.entity.UserAuthentication;
import com.picpay.challenge.infrastructure.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthenticationGatewayImpl implements AuthenticationGateway {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public void authentication(UserAuthentication userAuthentication) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthentication.getEmail(),
                userAuthentication.getPassword()));
    }

    @Override
    public Token createJwtToken(String email, Date accessTokenValidity, Date refreshTokenValidity) {
        String accessToken = this.jwtService.getAccessToken(email, accessTokenValidity);
        String refreshToken = this.jwtService.getRefreshToken(email, refreshTokenValidity);

        return this.jwtService.createAccessToken(email, accessTokenValidity, accessToken, refreshToken);
    }
}
