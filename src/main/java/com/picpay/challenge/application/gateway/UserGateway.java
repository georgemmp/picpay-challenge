package com.picpay.challenge.application.gateway;

import com.picpay.challenge.domain.entity.User;

public interface UserGateway {

    User save(User user);
    User findByEmail(String email);
    User findByCpfCnpj(String cpfCnpj);
    User findById(Integer id);
}
