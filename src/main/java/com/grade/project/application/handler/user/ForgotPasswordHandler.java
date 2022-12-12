package com.grade.project.application.handler.user;

import com.grade.project.domain.services.user.ForgotPasswordService;
import org.springframework.stereotype.Component;

@Component
public class ForgotPasswordHandler {

    private final ForgotPasswordService forgotPasswordService;

    public ForgotPasswordHandler(ForgotPasswordService forgotPasswordService) {
        this.forgotPasswordService = forgotPasswordService;
    }

    public void sendForgotEmail(String email) {
        this.forgotPasswordService.sendForgotEmail(email);
    }
}
