package com.picpay.challenge.application.interactor;

import com.picpay.challenge.application.gateway.TransactionPinGateway;
import com.picpay.challenge.application.usecase.PasswordEncoderUseCase;
import com.picpay.challenge.application.usecase.SavePinCodeUseCase;
import com.picpay.challenge.domain.entity.TransactionPin;

public class SavePinCodeUseCaseImpl implements SavePinCodeUseCase {

    private final TransactionPinGateway transactionPinGateway;
    private final PasswordEncoderUseCase passwordEncoderUseCase;

    public SavePinCodeUseCaseImpl(TransactionPinGateway transactionPinGateway, PasswordEncoderUseCase passwordEncoderUseCase) {
        this.transactionPinGateway = transactionPinGateway;
        this.passwordEncoderUseCase = passwordEncoderUseCase;
    }

    @Override
    public TransactionPin execute(TransactionPin transactionPin) {
        String encoded = this.passwordEncoderUseCase.execute(transactionPin.getPin());
        TransactionPin pinCode = new TransactionPin(transactionPin.getUser(), encoded);
        return this.transactionPinGateway.save(pinCode);
    }
}
