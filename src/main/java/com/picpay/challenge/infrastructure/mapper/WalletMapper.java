package com.picpay.challenge.infrastructure.mapper;

import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.domain.entity.Wallet;
import com.picpay.challenge.infrastructure.model.UserModel;
import com.picpay.challenge.infrastructure.model.WalletModel;

public class WalletMapper {

    private WalletMapper() {
    }

    public static WalletModel toModel(Wallet wallet) {
        UserModel userModel = UserMapper.toModel(wallet.getUser());
        return WalletModel.builder()
                .id(wallet.getId())
                .balance(wallet.getBalance())
                .user(userModel)
                .build();
    }

    public static Wallet toEntity(WalletModel walletModel) {
        User user = UserMapper.toEntity(walletModel.getUser());
        return new Wallet(walletModel.getId(), user, walletModel.getBalance());
    }
}
