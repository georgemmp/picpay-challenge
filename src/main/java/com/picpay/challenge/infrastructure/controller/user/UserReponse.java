package com.picpay.challenge.infrastructure.controller.user;

import com.picpay.challenge.domain.type.UserType;

public record UserReponse(String email, String cpfCnpj, UserType userType) {
}
