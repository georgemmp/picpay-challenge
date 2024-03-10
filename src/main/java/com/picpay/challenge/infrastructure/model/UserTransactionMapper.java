package com.picpay.challenge.infrastructure.model;

import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.domain.entity.Wallet;
import com.picpay.challenge.infrastructure.mapper.WalletMapper;

public class UserTransactionMapper {

    public static User toEntity(UserModel userModel) {
        Wallet wallet = WalletMapper.toEntity(userModel.getWallet());

        return new User(userModel.getId(), userModel.getFullName(), userModel.getCpfCnpj(), userModel.getPassword(), userModel.getEmail(),
                userModel.getUserType(), wallet);
    }
}
