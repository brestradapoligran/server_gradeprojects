package com.grade.project.application.handler.user;

import com.grade.project.application.command.UserCommand;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.enums.user.UserStatusEnum;
import com.grade.project.domain.model.UserModel;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.CreateUserService;
import com.grade.project.infrastructure.controllers.user.CreateUserController;
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
public class CreateUserControllerTest {

    private CreateUserController createUserController;
    private CreateUserHandler createUserHandler;
    private CreateUserService createUserService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        createUserService = new CreateUserService(userRepository);
        createUserHandler = new CreateUserHandler(createUserService);
        createUserController = new CreateUserController(createUserHandler);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserStatusTest() {
        when(createUserService.createUser(any(UserModel.class))).thenReturn(this.getUserDto());

        UserDto userDto = this.createUserController.createUser(this.getUserCommand());

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
