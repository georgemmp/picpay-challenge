package com.picpay.challenge.application.gateway;

import com.picpay.challenge.domain.entity.Transaction;

public interface TransactionGateway {

    Transaction save(Transaction transaction);
}
