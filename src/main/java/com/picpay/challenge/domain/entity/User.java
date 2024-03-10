package com.picpay.challenge.domain.entity;

import com.picpay.challenge.domain.exception.BadRequestException;
import com.picpay.challenge.domain.type.ExceptionMessagesType;
import com.picpay.challenge.domain.type.UserType;

import java.util.List;

public class User {

    private Integer id;
    private String fullName;
    private String cpfCnpj;
    private String password;
    private String email;
    private Wallet wallet;
    private UserType userType;
    private TransactionPin transactionPin;
    private List<Transaction> transactions;

    public User(Integer id, String fullName, String cpfCnpj, String password, String email, UserType userType) {
        this.id = id;
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public User(Integer id, String fullName, String cpfCnpj, String password, String email, UserType userType, Wallet wallet) {
        this.id = id;
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.wallet = wallet;
    }

    public User(String fullName, String cpfCnpj, String password, String email, UserType userType) {
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public User(String fullName, String cpfCnpj, String password, String email, UserType userType, TransactionPin transactionPin) {
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.transactionPin = transactionPin;
    }

    public User(Integer id, String fullName, String cpfCnpj, String password, String email, Wallet wallet, UserType userType, TransactionPin transactionPin, List<Transaction> transactions) {
        this.id = id;
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.password = password;
        this.email = email;
        this.wallet = wallet;
        this.userType = userType;
        this.transactionPin = transactionPin;
        this.transactions = transactions;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public UserType getUserType() {
        return userType;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void checkUserType() {
        if (this.userType == UserType.SHOPKEEPER) {
            throw new BadRequestException(404, ExceptionMessagesType.SHOPKEEPER_CAN_NOT_PAY.getMessage());
        }
    }
}
