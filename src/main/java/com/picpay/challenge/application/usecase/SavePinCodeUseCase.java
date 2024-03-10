package com.picpay.challenge.application.usecase;

import com.picpay.challenge.domain.entity.TransactionPin;

public interface SavePinCodeUseCase {

    TransactionPin execute(TransactionPin transactionPin);
}
