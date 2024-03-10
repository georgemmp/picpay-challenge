package com.picpay.challenge.infrastructure.mapper;

import com.picpay.challenge.domain.entity.TransactionPin;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.domain.entity.Wallet;
import com.picpay.challenge.infrastructure.controller.user.UserReponse;
import com.picpay.challenge.infrastructure.controller.user.UserRequest;
import com.picpay.challenge.infrastructure.model.TransactionModel;
import com.picpay.challenge.infrastructure.model.TransactionPinModel;
import com.picpay.challenge.infrastructure.model.UserModel;
import com.picpay.challenge.infrastructure.model.WalletModel;

import java.util.List;

public class UserMapper {

    private UserMapper(){}

    public static UserModel toModel(User user) {

        return UserModel.builder()
                .cpfCnpj(user.getCpfCnpj())
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .password(user.getPassword())
                .userType(user.getUserType())
                .build();
    }

    public static User toEntity(UserModel userModel) {
        return new User(userModel.getId(), userModel.getFullName(), userModel.getCpfCnpj(), userModel.getPassword(), userModel.getEmail(),
                userModel.getUserType());
    }

    public static User requestToEntity(UserRequest request) {
        TransactionPin transactionPin = new TransactionPin(request.pinCode().toString());
        return new User(request.fullName(), request.cpfCnpj(), request.password(), request.email(), request.userType(), transactionPin);
    }

    public static UserReponse toResponse(User user) {
        return new UserReponse(user.getEmail(), user.getCpfCnpj(), user.getUserType());
    }
}
