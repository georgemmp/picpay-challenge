package com.picpay.challenge.infrastructure.repository;

import com.picpay.challenge.infrastructure.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer> {
}
