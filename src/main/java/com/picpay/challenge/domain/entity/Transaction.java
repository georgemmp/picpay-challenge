package com.picpay.challenge.domain.entity;

import com.picpay.challenge.domain.type.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private Integer id;
    private List<User> users;
    private BigDecimal paymentValue;
    private LocalDateTime createAt;

    private TransactionType transactionType;

    public Transaction(BigDecimal paymentValue, TransactionType transactionType) {
        this.paymentValue = paymentValue;
        this.transactionType = transactionType;
        this.createAt = LocalDateTime.now();
        this.users = new ArrayList<>();
    }

    public Transaction(Integer id, BigDecimal paymentValue, LocalDateTime createAt, TransactionType transactionType) {
        this.id = id;
        this.paymentValue = paymentValue;
        this.createAt = createAt;
        this.transactionType = transactionType;
    }

    public Transaction() {
    }

    public Integer getId() {
        return id;
    }

    public List<User> getUsers() {
        return users;
    }

    public BigDecimal getPaymentValue() {
        return paymentValue;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
