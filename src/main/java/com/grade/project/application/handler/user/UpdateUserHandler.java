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

    public UserDto updateUser(String id, UserCommand userCommand) {
        return this.updateUserService.updateUser(UserFactory.convertToModel(id, userCommand));
    }

    public UserDto updateMyUser(String email, UserCommand userCommand) {
        return this.updateUserService.updateMyUser(email, UserFactory.convertToModel(userCommand));
    }
}
