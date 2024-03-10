package com.picpay.challenge.application.usecase;

import com.picpay.challenge.domain.entity.Transaction;

import java.math.BigDecimal;

public interface TransactionUseCase {

    void execute(BigDecimal value, Integer payer, Integer payee);
}
