package com.picpay.challenge.application.usecase;

import com.picpay.challenge.domain.entity.User;

public interface FindUserByIdUseCase {

    User execute(Integer id);
}
