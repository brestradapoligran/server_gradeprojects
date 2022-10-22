package com.grade.project.application.handler.user;

import com.grade.project.application.command.UserCommand;
import com.grade.project.application.factory.UserFactory;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.services.user.CreateUserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUserHandler {

    private final CreateUserService createUserService;

    public CreateUserHandler(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    public UserDto createUser(UserCommand userCommand) {
        return this.createUserService.createUser(UserFactory.convertToModel(userCommand));
    }
}
