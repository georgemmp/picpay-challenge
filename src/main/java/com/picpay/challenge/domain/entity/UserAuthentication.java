package com.picpay.challenge.domain.entity;

public class UserAuthentication {

    private String email;
    private String password;

    public UserAuthentication(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserAuthentication() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
