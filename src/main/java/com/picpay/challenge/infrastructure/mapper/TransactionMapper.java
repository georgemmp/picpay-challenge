package com.picpay.challenge.infrastructure.mapper;

import com.picpay.challenge.domain.entity.Transaction;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.infrastructure.model.TransactionModel;
import com.picpay.challenge.infrastructure.model.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {

    private TransactionMapper() {}

    public static List<TransactionModel> toModelList(List<Transaction> transactions) {

        return transactions.stream().map(transaction -> TransactionModel.builder()
                .transactionType(transaction.getTransactionType())
                .paymentValue(transaction.getPaymentValue())
                .id(transaction.getId())
                .createAt(transaction.getCreateAt())
                .build()).toList();
    }

    public static TransactionModel toModel(Transaction transaction) {
        List<UserModel> users = UserListMapper.toModelList(transaction.getUsers());
        return TransactionModel.builder()
                .transactionType(transaction.getTransactionType())
                .paymentValue(transaction.getPaymentValue())
                .id(transaction.getId())
                .users(users)
                .createAt(transaction.getCreateAt())
                .build();
    }

    public static List<Transaction> toEntityList(List<TransactionModel> transactions) {

        return transactions.stream().map(transaction -> new Transaction(transaction.getId(),
                transaction.getPaymentValue(), transaction.getCreateAt(),
                transaction.getTransactionType())).toList();
    }

    public static Transaction toEntity(TransactionModel transactionModel) {

        return new Transaction(transactionModel.getId(), transactionModel.getPaymentValue(),
                transactionModel.getCreateAt(), transactionModel.getTransactionType());
    }
}
