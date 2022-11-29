package com.grade.project.application.handler.user;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.application.factory.UserFactory;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.services.user.LoginService;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler {

    private final LoginService loginService;

    public LoginHandler(LoginService loginService) {
        this.loginService = loginService;
    }

    public UserDto login(LoginRequestCommand loginRequestCommand) {
        return this.loginService.login(UserFactory.convertLoginRequestToCommand(loginRequestCommand));
    }
}
