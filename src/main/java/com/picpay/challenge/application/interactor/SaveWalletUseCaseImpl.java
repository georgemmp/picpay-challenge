package com.picpay.challenge.application.interactor;

import com.picpay.challenge.application.gateway.WalletGateway;
import com.picpay.challenge.application.usecase.SaveWalletUseCase;
import com.picpay.challenge.domain.entity.Wallet;

public class SaveWalletUseCaseImpl implements SaveWalletUseCase {

    private final WalletGateway walletGateway;

    public SaveWalletUseCaseImpl(WalletGateway walletGateway) {
        this.walletGateway = walletGateway;
    }

    @Override
    public Wallet execute(Wallet wallet) {
        return this.walletGateway.save(wallet);
    }
}
