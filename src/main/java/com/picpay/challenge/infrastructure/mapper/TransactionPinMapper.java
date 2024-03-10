package com.picpay.challenge.infrastructure.mapper;

import com.picpay.challenge.domain.entity.TransactionPin;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.infrastructure.model.TransactionPinModel;
import com.picpay.challenge.infrastructure.model.UserModel;

public class TransactionPinMapper {

    private TransactionPinMapper() {
    }

    public static TransactionPinModel toModel(TransactionPin transactionPin) {
        UserModel userModel = UserMapper.toModel(transactionPin.getUser());

        return TransactionPinModel.builder()
                .pin(transactionPin.getPin())
                .id(transactionPin.getId())
                .user(userModel)
                .build();
    }

    public static TransactionPin toEntity(TransactionPinModel transactionPinModel) {
        User user = UserMapper.toEntity(transactionPinModel.getUser());

        return new TransactionPin(transactionPinModel.getId(), transactionPinModel.getPin(), user);
    }
}
