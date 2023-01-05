package com.grade.project.application.handler.user;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.ResetPasswordService;
import com.grade.project.infrastructure.controllers.user.ResetPasswordController;
import com.grade.project.infrastructure.util.jwt.JwtUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static reactor.core.publisher.Mono.when;

@RunWith(MockitoJUnitRunner.class)
public class ResetPasswordControllerTest {

    private ResetPasswordController resetPasswordController;
    private ResetPasswordHandler resetPasswordHandler;
    private ResetPasswordService resetPasswordService;

    @Mock
    private JwtUtils jwtUtils;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        resetPasswordService = new ResetPasswordService(userRepository);
        resetPasswordHandler = new ResetPasswordHandler(resetPasswordService);
        resetPasswordController = new ResetPasswordController(resetPasswordHandler, jwtUtils);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserStatusTest() {
        this.resetPasswordController.resetPassword(this.getLoginRequestCommand(), "token");
    }

    private LoginRequestCommand getLoginRequestCommand() {
        return new LoginRequestCommand("Name","pass");
    }
}
