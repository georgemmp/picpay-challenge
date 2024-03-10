package com.picpay.challenge.infrastructure.gateway;

import com.picpay.challenge.application.gateway.TransactionPinGateway;
import com.picpay.challenge.domain.entity.TransactionPin;
import com.picpay.challenge.infrastructure.mapper.TransactionPinMapper;
import com.picpay.challenge.infrastructure.model.TransactionPinModel;
import com.picpay.challenge.infrastructure.repository.TransactionPinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionPinGatewayImpl implements TransactionPinGateway {

    private final TransactionPinRepository repository;

    @Override
    public TransactionPin save(TransactionPin transactionPin) {
        TransactionPinModel model = TransactionPinMapper.toModel(transactionPin);
        TransactionPinModel saved = this.repository.save(model);
        return TransactionPinMapper.toEntity(saved);
    }
}
