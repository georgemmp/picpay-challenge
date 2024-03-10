package com.picpay.challenge.application.gateway;

import com.picpay.challenge.domain.entity.TransactionPin;

public interface TransactionPinGateway {

    TransactionPin save(TransactionPin transactionPin);
}
