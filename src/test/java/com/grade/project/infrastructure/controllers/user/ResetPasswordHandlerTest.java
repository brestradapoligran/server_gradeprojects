package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.application.handler.user.ResetPasswordHandler;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.ResetPasswordService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResetPasswordHandlerTest {

    private ResetPasswordHandler resetPasswordHandler;
    private ResetPasswordService resetPasswordService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        resetPasswordService = new ResetPasswordService(userRepository);
        resetPasswordHandler = new ResetPasswordHandler(resetPasswordService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserStatusTest() {
        this.resetPasswordHandler.resetPassword(this.getLoginRequestCommand());
    }

    private LoginRequestCommand getLoginRequestCommand() {
        return new LoginRequestCommand("Name","pass");
    }
}
