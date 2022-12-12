package com.grade.project.application.command;

public class LoginRequestCommand {

    private String email;
    private String pass;

    public LoginRequestCommand() {
    }

    public LoginRequestCommand(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
