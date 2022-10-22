package com.grade.project.application.handler.user;

import com.grade.project.application.command.UserCommand;
import com.grade.project.application.factory.UserFactory;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.services.user.UpdateUserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserHandler {

    private final UpdateUserService updateUserService;

    public UpdateUserHandler(UpdateUserService updateUserService) {
        this.updateUserService = updateUserService;
    }

    public UserDto updateUser(UserCommand userCommand) {
        return this.updateUserService.updateUser(UserFactory.convertToModel(userCommand));
    }
}
