package com.picpay.challenge.main.config;

import com.picpay.challenge.application.gateway.*;
import com.picpay.challenge.application.interactor.*;
import com.picpay.challenge.application.usecase.*;
import com.picpay.challenge.infrastructure.api.ApiConsumer;
import com.picpay.challenge.infrastructure.api.AuthorizationService;
import com.picpay.challenge.infrastructure.api.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public SaveWalletUseCase saveWalletUseCase(WalletGateway walletGateway) {
        return new SaveWalletUseCaseImpl(walletGateway);
    }

    @Bean
    public FindUserByEmailUseCase findUserByEmailUseCase(UserGateway userGateway) {
        return new FindUserByEmailUseCaseImpl(userGateway);
    }

    @Bean
    public SignInUserCase signInUserCase(FindUserByEmailUseCase findUserByEmailUseCase,
                                         AuthenticationGateway authenticationGateway) {
        return new SignInUserCaseImpl(findUserByEmailUseCase, authenticationGateway);
    }

    @Bean
    public PasswordEncoderUseCase passwordEncoderUseCase(PasswordEncoderGateway passwordEncoderGateway) {
        return new PasswordEncoderUseCaseImpl(passwordEncoderGateway);
    }

    @Bean
    public FindUserByCpfCnpjUseCase findUserByCpfCnpjUseCase(UserGateway userGateway) {
        return new FindUserByCpfCnpjUseCaseImpl(userGateway);
    }

    @Bean
    public ConsultAuthorizingServiceUseCase consultAuthorizingServiceUseCase(ConsumeApiGateway consumeApiGateway) {
        return new ConsultAuthorizingServiceUseCaseImpl(consumeApiGateway);
    }

    @Bean
    public ApiConsumer transferAuthorizationClient() {
        return new AuthorizationService();
    }

    @Bean
    public ApiConsumer notificationClient() {
        return new NotificationService();
    }

    @Bean
    public SendNotificationUseCase sendNotificationUseCase(ConsumeApiGateway consumeApiGateway) {
        return new SendNotificationUseCaseImpl(consumeApiGateway);
    }

    @Bean
    public SaveUserUseCase saveUserUseCase(UserGateway userGateway, SaveWalletUseCase saveWalletUseCase,
                                           SavePinCodeUseCase savePinCodeUseCase,
                                           PasswordEncoderUseCase passwordEncoderUseCase) {
        return new SaveUserUseCaseImpl(userGateway, saveWalletUseCase, savePinCodeUseCase, passwordEncoderUseCase);
    }

    @Bean
    public SavePinCodeUseCase savePinCodeUseCase(TransactionPinGateway transactionPinGateway,
                                          PasswordEncoderUseCase passwordEncoderUseCase) {
        return new SavePinCodeUseCaseImpl(transactionPinGateway, passwordEncoderUseCase);
    }

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(UserGateway userGateway) {
        return new FindUserByIdUseCaseImpl(userGateway);
    }

    @Bean
    public TransactionUseCase transactionUseCase(TransactionGateway transactionGateway, FindUserByIdUseCase findUserByIdUseCase,
                                                 SaveWalletUseCase saveWalletUseCase, ConsultAuthorizingServiceUseCase consultAuthorizingServiceUseCase,
                                                 SendNotificationUseCase sendNotificationUseCase) {
        return new TransactionUseCaseImpl(transactionGateway, findUserByIdUseCase, saveWalletUseCase, consultAuthorizingServiceUseCase, sendNotificationUseCase);
    }
}
