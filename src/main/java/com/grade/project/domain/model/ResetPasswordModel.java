package com.grade.project.domain.model;

public class ResetPasswordModel {
    private String email;
    private String oldPass;
    private String pass;

    public ResetPasswordModel() {
    }

    public ResetPasswordModel(String email, String oldPass, String pass) {
        this.email = email;
        this.oldPass = oldPass;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
