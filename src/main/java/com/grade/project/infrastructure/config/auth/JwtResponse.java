package com.grade.project.infrastructure.config.auth;

import com.grade.project.domain.enums.user.UserRoleEnum;

public class JwtResponse {
    private String token;
    private String email;
    private UserRoleEnum role;

    public JwtResponse() {
    }

    public JwtResponse(String token, String email, UserRoleEnum role) {
        this.token = token;
        this.email = email;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}
