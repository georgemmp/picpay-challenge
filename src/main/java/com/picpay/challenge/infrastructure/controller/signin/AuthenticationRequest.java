package com.picpay.challenge.infrastructure.controller.signin;

public record AuthenticationRequest (String email, String password) {
}
