package com.picpay.challenge.infrastructure.controller.signin;

public record AuthenticationResponse(String accessToken, String refreshToken) {
}
