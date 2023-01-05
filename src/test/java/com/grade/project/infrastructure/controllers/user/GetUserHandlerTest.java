package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.handler.user.GetUserHandler;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.enums.user.UserStatusEnum;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.GetUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetUserHandlerTest {

    private GetUserHandler getUserHandler;
    private GetUserService getUserService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        getUserService = new GetUserService(userRepository);
        getUserHandler = new GetUserHandler(getUserService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserTest() {
        when(getUserService.getUser(anyString())).thenReturn(this.getUserDto());

        UserDto userDto = this.getUserHandler.getUser("email");

        Assert.assertEquals("1", userDto.getId());
        Assert.assertEquals("Name", userDto.getName());
        Assert.assertEquals("LastName", userDto.getLastName());
        Assert.assertEquals("Email", userDto.getEmail());
        Assert.assertEquals(UserRoleEnum.Administrador, userDto.getRole());
        Assert.assertEquals(UserStatusEnum.Activo, userDto.getStatus());
    }

    @Test
    public void getMyUserTest() {
        when(getUserService.getMyUser(anyString())).thenReturn(this.getUserDto());

        UserDto userDto = this.getUserHandler.getMyUser("email");

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
}
