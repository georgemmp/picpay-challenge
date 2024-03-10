package com.picpay.challenge.application.interactor;

import com.picpay.challenge.application.gateway.UserGateway;
import com.picpay.challenge.application.usecase.PasswordEncoderUseCase;
import com.picpay.challenge.application.usecase.SavePinCodeUseCase;
import com.picpay.challenge.application.usecase.SaveUserUseCase;
import com.picpay.challenge.application.usecase.SaveWalletUseCase;
import com.picpay.challenge.domain.entity.TransactionPin;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.domain.entity.Wallet;
import com.picpay.challenge.domain.exception.BadRequestException;
import com.picpay.challenge.domain.type.ExceptionMessagesType;

public class SaveUserUseCaseImpl implements SaveUserUseCase {

    private final UserGateway userGateway;
    private final SaveWalletUseCase saveWalletUseCase;
    private final SavePinCodeUseCase savePinCodeUseCase;
    private final PasswordEncoderUseCase passwordEncoderUseCase;

    public SaveUserUseCaseImpl(UserGateway userGateway, SaveWalletUseCase saveWalletUseCase,
                               SavePinCodeUseCase savePinCodeUseCase,
                               PasswordEncoderUseCase passwordEncoderUseCase) {
        this.userGateway = userGateway;
        this.saveWalletUseCase = saveWalletUseCase;
        this.savePinCodeUseCase = savePinCodeUseCase;
        this.passwordEncoderUseCase = passwordEncoderUseCase;
    }

    @Override
    public User execute(User user) {
        this.checkIfExistUserByEmail(user.getEmail());
        this.checkIfExistUserByCpf(user.getCpfCnpj());

        String passwordEncoded = this.passwordEncoderUseCase.execute(user.getPassword());

        User userTemp = new User(user.getFullName(), user.getCpfCnpj(), passwordEncoded, user.getEmail(), user.getUserType());

        User saved = this.userGateway.save(userTemp);

        Wallet wallet = new Wallet(saved);
        TransactionPin transactionPin = new TransactionPin(saved, user.getTransactionPin().getPin());

        this.saveWalletUseCase.execute(wallet);
        this.savePinCodeUseCase.execute(transactionPin);

        return saved;
    }

    private void checkIfExistUserByEmail(String email) {
        User user = this.userGateway.findByEmail(email);

        if (user != null) {
            throw new BadRequestException(400, ExceptionMessagesType.USER_ALREADY_EXISTS_EMAIL.getMessage());
        }
    }

    private void checkIfExistUserByCpf(String cpf) {
        User user = this.userGateway.findByCpfCnpj(cpf);

        if (user != null) {
            throw new BadRequestException(400, ExceptionMessagesType.USER_ALREADY_EXISTS_CPF.getMessage());
        }
    }
}
