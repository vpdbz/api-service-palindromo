package com.walmart.service.palindromo.security;

import org.springframework.stereotype.Component;

@Component
public class ApiCustomCredentials {
    private String userName;
    private String password;
    private String role;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ApiCustomCredentials() {
        this.userName = "user";
        this.password = "pass";
        this.role = "API_USER";
    }
}