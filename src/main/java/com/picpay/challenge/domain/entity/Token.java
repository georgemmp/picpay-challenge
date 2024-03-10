package com.picpay.challenge.domain.entity;

import java.util.Date;

public class Token {

    private String userName;
    private Boolean authenticated;
    private Date created;
    private Date expiration;
    private String accessToken;
    private String refreshToken;

    public Token() {
    }

    public Token(String userName, Boolean authenticated, Date created, Date expiration, String accessToken, String refreshToken) {
        this.userName = userName;
        this.authenticated = authenticated;
        this.created = created;
        this.expiration = expiration;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getUserName() {
        return userName;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public Date getCreated() {
        return created;
    }

    public Date getExpiration() {
        return expiration;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
