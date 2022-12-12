package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.application.handler.user.LoginHandler;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.infrastructure.config.auth.JwtResponse;
import com.grade.project.infrastructure.util.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class LoginUserController {

    private final LoginHandler loginHandler;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequestCommand loginRequestCommand) {
        UserDto userFound = this.loginHandler.login(loginRequestCommand);
        String token = this.jwtUtils.getJwtToken(userFound.getEmail());
        return new JwtResponse(token);
    }


}
