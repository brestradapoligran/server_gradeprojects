package com.grade.project.application.command;

import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.enums.user.UserStatusEnum;
import org.junit.Assert;
import org.junit.Test;

public class UserCommandTest {

    @Test
    public void createUserCommandWithEmptyConstructor() {
        UserCommand userCommand = new UserCommand();
    }

    @Test
    public void createUserCommandWithConstructor() {
        UserCommand userCommand = new UserCommand("Name", "LastName", "Email", "Pass", UserRoleEnum.Administrador, UserStatusEnum.Inactivo);
        Assert.assertEquals("Name", userCommand.getName());
        Assert.assertEquals("LastName", userCommand.getLastName());
        Assert.assertEquals("Email", userCommand.getEmail());
        Assert.assertEquals("Pass", userCommand.getPass());
        Assert.assertEquals(UserRoleEnum.Administrador, userCommand.getRole());
        Assert.assertEquals(UserStatusEnum.Inactivo, userCommand.getStatus());
    }
}
