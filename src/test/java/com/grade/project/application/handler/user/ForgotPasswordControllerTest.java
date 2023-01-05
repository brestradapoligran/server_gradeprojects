package com.grade.project.application.handler.user;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.ForgotPasswordService;
import com.grade.project.infrastructure.config.email.EmailService;
import com.grade.project.infrastructure.controllers.user.ForgotPasswordController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ForgotPasswordControllerTest {

    private ForgotPasswordController forgotPasswordController;
    private ForgotPasswordHandler forgotPasswordHandler;
    private ForgotPasswordService forgotPasswordService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailService emailService;

    @Before
    public void setUp() {
        forgotPasswordService = new ForgotPasswordService(userRepository);
        forgotPasswordHandler = new ForgotPasswordHandler(forgotPasswordService);
        forgotPasswordController = new ForgotPasswordController(emailService, forgotPasswordHandler);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserStatusTest() {
        this.forgotPasswordController.sendForgotPasswordEmail(new LoginRequestCommand("brayan@gmail.com", "123456"));
    }
}
