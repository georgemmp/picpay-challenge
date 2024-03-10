package com.picpay.challenge.infrastructure.repository;

import com.picpay.challenge.infrastructure.model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletModel, Integer> {
}
