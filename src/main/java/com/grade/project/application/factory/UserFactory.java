package com.grade.project.application.factory;

import com.grade.project.application.command.UserCommand;
import com.grade.project.domain.model.UserModel;

public class UserFactory {

    public static UserModel convertToModel(UserCommand u) {
        return new UserModel(u.getId(), u.getName(), u.getLastName(), u.getEmail(), u.getPass(), u.getRole());
    }
}
