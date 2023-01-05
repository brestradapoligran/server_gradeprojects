package com.grade.project.application.command;

import org.junit.Assert;
import org.junit.Test;

public class LoginRequestCommandTest {

    @Test
    public void createLoginRequestCommandWithEmptyConstructor() {
        LoginRequestCommand loginRequestCommand = new LoginRequestCommand();
        loginRequestCommand.setEmail("brayan@gmail.com");
        Assert.assertEquals("brayan@gmail.com", loginRequestCommand.getEmail());
    }

    @Test
    public void createLoginRequestCommandWithConstructor() {
        LoginRequestCommand loginRequestCommand = new LoginRequestCommand("brayan@gmail.com", "123456");
        Assert.assertEquals("brayan@gmail.com", loginRequestCommand.getEmail());
        Assert.assertEquals("123456", loginRequestCommand.getPass());
    }
}
