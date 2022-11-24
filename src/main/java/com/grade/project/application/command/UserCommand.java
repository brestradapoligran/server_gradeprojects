package com.grade.project.application.command;

public class UserCommand {

    private final String name;
    private final String lastName;
    private final String email;
    private final String pass;
    private final String role;

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
