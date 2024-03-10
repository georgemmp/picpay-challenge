package com.picpay.challenge.infrastructure.controller.user;

import com.picpay.challenge.domain.type.UserType;

public record UserRequest(String email, String fullName, String cpfCnpj, String password, UserType userType, Long pinCode) {
}
