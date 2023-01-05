package com.grade.project.application.handler.user;

import com.grade.project.application.command.UserCommand;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.enums.user.UserStatusEnum;
import com.grade.project.domain.model.UserModel;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.UpdateUserService;
import com.grade.project.infrastructure.controllers.user.UpdateUserController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UpdateUserControllerTest {

    private UpdateUserController updateUserController;
    private UpdateUserHandler updateUserHandler;
    private UpdateUserService updateUserService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        updateUserService = new UpdateUserService(userRepository);
        updateUserHandler = new UpdateUserHandler(updateUserService);
        updateUserController = new UpdateUserController(updateUserHandler);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserStatusTest() {
        when(updateUserService.updateUser(any(UserModel.class))).thenReturn(this.getUserDto());

        UserDto userDto = this.updateUserController.updateUser(this.getUserCommand(), "1");

        Assert.assertEquals("1", userDto.getId());
        Assert.assertEquals("Name", userDto.getName());
        Assert.assertEquals("LastName", userDto.getLastName());
        Assert.assertEquals("Email", userDto.getEmail());
        Assert.assertEquals(UserRoleEnum.Administrador, userDto.getRole());
        Assert.assertEquals(UserStatusEnum.Activo, userDto.getStatus());
    }

    private UserDto getUserDto() {
        return new UserDto("1", "Name", "LastName", "Email", UserRoleEnum.Administrador, UserStatusEnum.Activo);
    }

    private UserCommand getUserCommand() {
        return new UserCommand("1", "Name", "LastName", "Email", UserRoleEnum.Administrador, UserStatusEnum.Activo);
    }
}
