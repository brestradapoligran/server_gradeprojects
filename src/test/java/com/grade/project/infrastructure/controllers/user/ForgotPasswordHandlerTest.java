package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.handler.user.ForgotPasswordHandler;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.ForgotPasswordService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ForgotPasswordHandlerTest {

    private ForgotPasswordHandler forgotPasswordHandler;
    private ForgotPasswordService forgotPasswordService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        forgotPasswordService = new ForgotPasswordService(userRepository);
        forgotPasswordHandler = new ForgotPasswordHandler(forgotPasswordService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserStatusTest() {
        this.forgotPasswordHandler.sendForgotEmail("brayan@gmail.com");
    }
}
