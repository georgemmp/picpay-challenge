package com.picpay.challenge.application.gateway;

import com.picpay.challenge.domain.entity.Wallet;

public interface WalletGateway {

    Wallet save(Wallet wallet);
}
