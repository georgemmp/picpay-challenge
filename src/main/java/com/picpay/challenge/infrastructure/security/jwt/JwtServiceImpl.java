package com.picpay.challenge.infrastructure.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.picpay.challenge.domain.entity.Token;
import com.picpay.challenge.domain.exception.ForbiddenException;
import com.picpay.challenge.domain.type.ExceptionMessagesType;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Base64;
import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    @Value("${security.jwt.token.secret-key:secretKey}")
    private String secretKey;

    private Algorithm algorithm;
    private static final String BEARER = "Bearer ";

    @PostConstruct
    protected void init() {
        this.secretKey = Base64.getEncoder().encodeToString(this.secretKey.getBytes());
        this.algorithm = Algorithm.HMAC256(this.secretKey.getBytes());
    }

    @Override
    public String getAccessToken(String email, Date validity) {
        String issueUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toString();

        return JWT.create()
                .withIssuedAt(new Date())
                .withExpiresAt(validity)
                .withSubject(email)
                .withIssuer(issueUrl)
                .sign(algorithm)
                .strip();
    }

    @Override
    public String getRefreshToken(String email, Date validity) {
        Date now = new Date();

        return JWT.create()
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withSubject(email)
                .sign(algorithm)
                .strip();
    }

    @Override
    public Token createAccessToken(String email, Date validity, String accessToken, String refreshToken) {
        return new Token(email, true, new Date(), validity, accessToken, refreshToken);
    }

    @Override
    public DecodedJWT decodedJWT(String token) {
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        return jwtVerifier.verify(token);
    }

    @Override
    public String resolveToken(HttpServletRequest http) {
        String token = http.getHeader(HttpHeaders.AUTHORIZATION);

        if (Objects.nonNull(token) && token.startsWith(BEARER)) {
            return token.substring(BEARER.length());
        }

        return null;
    }

    @Override
    public boolean validateToken(String token) {
        DecodedJWT decodedJWT = this.decodedJWT(token);

        try {
            return !decodedJWT.getExpiresAt().before(new Date());
        } catch (Exception e) {
            throw new ForbiddenException(HttpStatus.FORBIDDEN.value(), ExceptionMessagesType.INVALID_TOKEN.getMessage());
        }
    }
}
