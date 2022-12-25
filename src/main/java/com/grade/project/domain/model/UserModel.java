package com.grade.project.domain.model;

import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.utils.validations.DataValidation;

public class UserModel {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private String pass;
    private UserRoleEnum role;
    private Boolean status;

    public UserModel() {
    }

    public UserModel(String id, String name, String lastName, String email, String pass, UserRoleEnum role, Boolean status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.role = role;
        this.status = status;
        this.validateData();
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    private void validateData() {
        DataValidation.validationRequired(this.name, "Error: El nombre es obligatorio");
        DataValidation.validationRequired(this.lastName, "Error: El apellido es obligatorio");
        DataValidation.validationRequired(this.email, "Error: El correo es obligatorio");
        DataValidation.validationRequired(this.role, "Error: El rol es obligatorio");
    }
}
