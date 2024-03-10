package com.picpay.challenge.infrastructure.security.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.picpay.challenge.domain.entity.Token;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;

public interface JwtService {

    String getAccessToken(String email, Date validity);
    String getRefreshToken(String email, Date validity);
    Token createAccessToken(String email, Date validity, String accessToken, String refreshToken);
    DecodedJWT decodedJWT(String token);
    String resolveToken(HttpServletRequest http);
    public boolean validateToken(String token);
}
