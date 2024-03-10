package com.picpay.challenge.infrastructure.gateway;

import com.picpay.challenge.application.gateway.TransactionGateway;
import com.picpay.challenge.domain.entity.Transaction;
import com.picpay.challenge.infrastructure.mapper.TransactionMapper;
import com.picpay.challenge.infrastructure.model.TransactionModel;
import com.picpay.challenge.infrastructure.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionGatewayImpl implements TransactionGateway {

    private final TransactionRepository repository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Transaction save(Transaction transaction) {
        TransactionModel model = TransactionMapper.toModel(transaction);
        TransactionModel saved = this.repository.save(model);
        return TransactionMapper.toEntity(saved);
    }
}
