package com.grade.project.application.handler.user;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.domain.services.user.ResetPasswordService;
import org.springframework.stereotype.Component;

@Component
public class ResetPasswordHandler {

    private final ResetPasswordService resetPasswordService;

    public ResetPasswordHandler(ResetPasswordService resetPasswordService) {
        this.resetPasswordService = resetPasswordService;
    }

    public void resetPassword(LoginRequestCommand command) {
        this.resetPasswordService.resetPassword(command.getEmail(), command.getPass());
    }
}
