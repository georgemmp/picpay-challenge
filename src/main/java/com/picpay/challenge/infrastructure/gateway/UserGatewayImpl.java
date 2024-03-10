package com.picpay.challenge.infrastructure.gateway;

import com.picpay.challenge.application.gateway.UserGateway;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.infrastructure.mapper.UserMapper;
import com.picpay.challenge.infrastructure.model.UserModel;
import com.picpay.challenge.infrastructure.model.UserTransactionMapper;
import com.picpay.challenge.infrastructure.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserRepository repository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public User save(User user) {
        UserModel userModel = UserMapper.toModel(user);
        UserModel saved = this.repository.save(userModel);
        return UserMapper.toEntity(saved);
    }

    @Override
    public User findByEmail(String email) {
        UserModel userModel = this.repository.findByEmail(email);
        if (userModel != null) {
            return UserMapper.toEntity(userModel);
        }
        return null;
    }

    @Override
    public User findByCpfCnpj(String cpfCnpj) {
        UserModel userModel = this.repository.findByCpfCnpj(cpfCnpj);
        if (userModel != null) {
            return UserMapper.toEntity(userModel);
        }
        return null;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public User findById(Integer id) {
        Optional<UserModel> optionalUserModel = this.repository.findById(id);

        if (optionalUserModel.isPresent()) {
            UserModel model = optionalUserModel.get();
            return UserTransactionMapper.toEntity(model);
        }

        return null;
    }
}
