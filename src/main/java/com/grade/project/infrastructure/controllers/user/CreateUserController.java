package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.command.UserCommand;
import com.grade.project.application.handler.user.CreateUserHandler;
import com.grade.project.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class CreateUserController {

    private CreateUserHandler createUserHandler;

    @PostMapping
    public UserDto createUser(@RequestBody UserCommand userCommand) {
        return this.createUserHandler.createUser(userCommand);
    }
}
