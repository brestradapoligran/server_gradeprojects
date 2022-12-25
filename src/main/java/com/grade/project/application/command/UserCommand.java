package com.grade.project.application.command;

import com.grade.project.domain.enums.user.UserRoleEnum;

public class UserCommand {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private String pass;
    private UserRoleEnum role;
    private Boolean status;

    public UserCommand() {
    }

    public UserCommand(String name, String lastName, String email, String pass, UserRoleEnum role, Boolean status) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.role = role;
        this.status = status;
    }

    public UserCommand(String id, String name, String lastName, String email, String pass, UserRoleEnum role, Boolean status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.role = role;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public Boolean getStatus() {
        return status;
    }
}
