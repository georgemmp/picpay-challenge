package com.picpay.challenge.infrastructure.controller.user;

import com.picpay.challenge.application.usecase.SaveUserUseCase;
import com.picpay.challenge.domain.entity.TransactionPin;
import com.picpay.challenge.domain.entity.User;
import com.picpay.challenge.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final SaveUserUseCase saveUserUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserReponse save(@RequestBody UserRequest request) {
        User user = UserMapper.requestToEntity(request);
        User saved = this.saveUserUseCase.execute(user);
        return UserMapper.toResponse(saved);
    }
}
