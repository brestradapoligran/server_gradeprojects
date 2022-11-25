package com.grade.project.application.command;

public class UserCommand {

    private String name;
    private String lastName;
    private String email;
    private String pass;
    private String role;

    public UserCommand() {
    }

    public UserCommand(String name, String lastName, String email, String pass, String role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.role = role;
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

    public String getRole() {
        return role;
    }
}
