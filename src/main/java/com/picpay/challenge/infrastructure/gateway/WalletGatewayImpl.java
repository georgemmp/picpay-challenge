package com.picpay.challenge.infrastructure.gateway;

import com.picpay.challenge.application.gateway.WalletGateway;
import com.picpay.challenge.domain.entity.Wallet;
import com.picpay.challenge.infrastructure.mapper.WalletMapper;
import com.picpay.challenge.infrastructure.model.WalletModel;
import com.picpay.challenge.infrastructure.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletGatewayImpl implements WalletGateway {

    private final WalletRepository repository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Wallet save(Wallet wallet) {
        WalletModel model = this.repository.save(WalletMapper.toModel(wallet));
        return WalletMapper.toEntity(model);
    }
}
