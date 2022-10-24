package com.grade.project.application.factory;

import com.grade.project.application.command.UserCommand;
import com.grade.project.domain.model.UserModel;

public class UserFactory {

    public static UserModel convertToModel(String id, UserCommand u) {
        return new UserModel(id, u.getName(), u.getLastName(), u.getEmail(), u.getPass(), u.getRole());
    }

    public static UserModel convertToModel(UserCommand u) {
        return new UserModel(null, u.getName(), u.getLastName(), u.getEmail(), u.getPass(), u.getRole());
    }
}
