package com.picpay.challenge.domain.entity;

import com.picpay.challenge.domain.exception.BadRequestException;
import com.picpay.challenge.domain.type.ExceptionMessagesType;

public class TransactionPin {

    private Integer id;
    private String pin;
    private User user;

    public TransactionPin(Integer id, String pin, User user) {
        this.id = id;
        this.pin = pin;
        this.user = user;
    }

    public TransactionPin(User user, String pin) {
        this.user = user;
        this.pin = pin;
    }

    public TransactionPin(String pin) {
        this.pin = pin;
    }

    public TransactionPin() {
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getPin() {
        return pin;
    }

    public void checkPinCode() {
        if(this.pin.toString().length() != 4) {
            throw new BadRequestException(400, ExceptionMessagesType.PIN_CODE_LENGTH.getMessage());
        }
    }
}
