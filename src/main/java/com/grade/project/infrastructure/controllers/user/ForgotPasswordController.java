package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.application.handler.user.ForgotPasswordHandler;
import com.grade.project.infrastructure.config.email.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class ForgotPasswordController {

    private final EmailService emailService;
    private final ForgotPasswordHandler forgotPasswordHandler;

    public ForgotPasswordController(EmailService emailService, ForgotPasswordHandler forgotPasswordHandler) {
        this.emailService = emailService;
        this.forgotPasswordHandler = forgotPasswordHandler;
    }

    @PostMapping("/forgot/{email}")
    public void sendForgotPasswordEmail(@PathVariable String email) {
        this.forgotPasswordHandler.sendForgotEmail(email);
    }
}
