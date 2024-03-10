package com.picpay.challenge.application.usecase;

import com.picpay.challenge.domain.entity.User;

public interface SaveUserUseCase {

    User execute(User user);
}
