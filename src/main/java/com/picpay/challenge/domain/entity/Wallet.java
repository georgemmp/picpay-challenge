package com.picpay.challenge.domain.entity;

import com.picpay.challenge.domain.exception.BadRequestException;
import com.picpay.challenge.domain.type.ExceptionMessagesType;

import java.math.BigDecimal;

public class Wallet {

    private Integer id;
    private User user;
    private BigDecimal balance;

    public Wallet(Integer id, User user, BigDecimal balance) {
        this.id = id;
        this.user = user;
        this.balance = balance;
    }

    public Wallet(User user) {
        this.user = user;
        this.balance = BigDecimal.ZERO;
    }

    public Wallet() {
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void checkBalance() {
        if (this.balance.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException(400, ExceptionMessagesType.NO_BALANCE.getMessage());
        }
    }

    public void pay(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }

    public void receivePayment(BigDecimal value) {
        this.balance = this.balance.add(value);
    }
}
