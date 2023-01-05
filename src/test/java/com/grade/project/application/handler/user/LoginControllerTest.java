package com.grade.project.application.handler.user;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.enums.user.UserStatusEnum;
import com.grade.project.domain.model.LoginRequestModel;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.LoginService;
import com.grade.project.infrastructure.config.auth.JwtResponse;
import com.grade.project.infrastructure.controllers.user.LoginUserController;
import com.grade.project.infrastructure.util.jwt.JwtUtils;
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
public class LoginControllerTest {

    private LoginUserController loginUserController;
    private LoginHandler loginHandler;
    private LoginService loginService;

    @Mock
    private JwtUtils jwtUtils;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        loginService = new LoginService(userRepository);
        loginHandler = new LoginHandler(loginService);
        loginUserController = new LoginUserController(loginHandler, jwtUtils);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserStatusTest() {
        when(loginService.login(any(LoginRequestModel.class))).thenReturn(this.getUserDto());

        JwtResponse jwtResponse = this.loginUserController.login(this.getLoginRequestCommand());

        Assert.assertNotEquals("", jwtResponse.getToken());

    }

    private UserDto getUserDto() {
        return new UserDto("1", "Name", "LastName", "Email", UserRoleEnum.Administrador, UserStatusEnum.Activo);
    }

    private LoginRequestCommand getLoginRequestCommand() {
        return new LoginRequestCommand("Name","pass");
    }
}
