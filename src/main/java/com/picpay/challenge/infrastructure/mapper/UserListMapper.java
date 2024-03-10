package com.picpay.challenge.infrastructure.mapper;

import com.picpay.challenge.domain.entity.Transaction;
import com.picpay.challenge.domain.entity.TransactionPin;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.domain.entity.Wallet;
import com.picpay.challenge.infrastructure.model.TransactionModel;
import com.picpay.challenge.infrastructure.model.TransactionPinModel;
import com.picpay.challenge.infrastructure.model.UserModel;
import com.picpay.challenge.infrastructure.model.WalletModel;

import java.util.List;

public class UserListMapper {

    private UserListMapper() {}

    public static List<UserModel> toModelList(List<User> users) {
        return users.stream().map(user -> UserModel.builder()
                .cpfCnpj(user.getCpfCnpj())
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .password(user.getPassword())
                .userType(user.getUserType())
                .build()).toList();
    }

    public static List<User> toEntityList(List<UserModel> users) {
        return users.stream().map(user -> {
            List<Transaction> transactions = TransactionMapper.toEntityList(user.getTransactionModelList());
            Wallet wallet = WalletMapper.toEntity(user.getWallet());
            TransactionPin transactionPin = TransactionPinMapper.toEntity(user.getTransactionPin());
            return new User(user.getId(), user.getFullName(), user.getCpfCnpj(), user.getPassword(), user.getEmail(),
                    wallet, user.getUserType(), transactionPin, transactions);
        }).toList();
    }
}
