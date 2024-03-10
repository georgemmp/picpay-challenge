package com.picpay.challenge.application.usecase;

import com.picpay.challenge.domain.entity.Wallet;

public interface SaveWalletUseCase {

    Wallet execute(Wallet wallet);
}
