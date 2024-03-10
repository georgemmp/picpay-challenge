package com.picpay.challenge.infrastructure.security.authentication;

import com.picpay.challenge.application.usecase.FindUserByEmailUseCase;
import com.picpay.challenge.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final FindUserByEmailUseCase findUserByEmail;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.findUserByEmail.execute(email);
        return new UserAuthenticated(user);
    }
}
