package com.picpay.challenge.application.interactor;

import com.picpay.challenge.application.gateway.TransactionGateway;
import com.picpay.challenge.application.usecase.*;
import com.picpay.challenge.domain.entity.Transaction;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.domain.entity.Wallet;
import com.picpay.challenge.domain.type.TransactionType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TransactionUseCaseImpl implements TransactionUseCase {

    private final TransactionGateway transactionGateway;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final SaveWalletUseCase saveWalletUseCase;
    private final ConsultAuthorizingServiceUseCase consultAuthorizingServiceUseCase;
    private final SendNotificationUseCase sendNotificationUseCase;

    public TransactionUseCaseImpl(TransactionGateway transactionGateway,
                                  FindUserByIdUseCase findUserByIdUseCase,
                                  SaveWalletUseCase saveWalletUseCase,
                                  ConsultAuthorizingServiceUseCase consultAuthorizingServiceUseCase,
                                  SendNotificationUseCase sendNotificationUseCase) {
        this.transactionGateway = transactionGateway;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.saveWalletUseCase = saveWalletUseCase;
        this.consultAuthorizingServiceUseCase = consultAuthorizingServiceUseCase;
        this.sendNotificationUseCase = sendNotificationUseCase;
    }

    @Override
    public void execute(BigDecimal value, Integer payer, Integer payee) {
        this.consultAuthorizingServiceUseCase.execute();

        User userPayer = this.findUserByIdUseCase.execute(payer);
        User userPayee = this.findUserByIdUseCase.execute(payee);

        userPayer.checkUserType();
        userPayer.getWallet().checkBalance();

        Wallet payerWallet = userPayer.getWallet();
        Wallet payeeWallet = userPayee.getWallet();

        payeeWallet.receivePayment(value);
        payerWallet.pay(value);

        this.saveWalletUseCase.execute(payerWallet);
        this.saveWalletUseCase.execute(payeeWallet);

        List<User> users = Arrays.asList(userPayee, userPayer);

        Transaction payment = new Transaction(value, TransactionType.PAYMENT);
        payment.setUsers(users);

        this.transactionGateway.save(payment);

        this.sendNotificationUseCase.execute();
    }
}
