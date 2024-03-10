package com.picpay.challenge.infrastructure.repository;

import com.picpay.challenge.infrastructure.model.TransactionPinModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinRepository extends JpaRepository<TransactionPinModel, Integer> {
}
