package com.picpay.challenge.infrastructure.repository;

import com.picpay.challenge.infrastructure.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByEmail(String email);
    UserModel findByCpfCnpj(String email);
}
