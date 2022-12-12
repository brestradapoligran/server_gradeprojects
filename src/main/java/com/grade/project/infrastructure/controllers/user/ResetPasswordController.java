package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.application.handler.user.ResetPasswordHandler;
import com.grade.project.infrastructure.util.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class ResetPasswordController {

    private final ResetPasswordHandler resetPasswordHandler;
    private final JwtUtils jwtUtils;

    @PostMapping("/resetpassword")
    public void resetPassword(@RequestBody LoginRequestCommand loginRequestCommand,
                              @RequestHeader(value="Authorization") String token) {
        String email = this.jwtUtils.getEmailFromToken(token);
        loginRequestCommand.setEmail(email);
        this.resetPasswordHandler.resetPassword(loginRequestCommand);
    }
}
