package com.grade.project.domain.dto;

import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.enums.user.UserStatusEnum;

public class UserDto {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private UserRoleEnum role;
    private UserStatusEnum status;

    public UserDto() {
    }

    public UserDto(String id, String name, String lastName, String email, UserRoleEnum role, UserStatusEnum status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void setRole(UserRoleEnum     role) {
        this.role = role;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }
}
