package com.picpay.challenge.infrastructure.controller.signin;

import com.picpay.challenge.application.usecase.SignInUserCase;
import com.picpay.challenge.domain.entity.Token;
import com.picpay.challenge.domain.entity.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final SignInUserCase signInUserCase;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse authentication(@RequestBody AuthenticationRequest request) {
        UserAuthentication userAuthentication = new UserAuthentication(request.email(), request.password());
        Token token = this.signInUserCase.execute(userAuthentication);
        return new AuthenticationResponse(token.getAccessToken(), token.getRefreshToken());
    }
}
