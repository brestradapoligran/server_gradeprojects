package com.grade.project.application.factory;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.application.command.ResetPasswordCommand;
import com.grade.project.application.command.UserCommand;
import com.grade.project.domain.enums.user.UserStatusEnum;
import com.grade.project.domain.model.LoginRequestModel;
import com.grade.project.domain.model.ResetPasswordModel;
import com.grade.project.domain.model.UserModel;

public class UserFactory {

    public static UserModel convertToModel(String id, UserCommand u) {
        return new UserModel(id, u.getName(), u.getLastName(), u.getEmail(), u.getPass(), u.getRole(), u.getStatus());
    }

    public static UserModel convertToModel(UserCommand u) {
        return new UserModel(null, u.getName(), u.getLastName(), u.getEmail(), u.getPass(), u.getRole(), UserStatusEnum.Activo);
    }

    public static LoginRequestModel convertLoginRequestToCommand(LoginRequestCommand loginRequestCommand) {
        return new LoginRequestModel(loginRequestCommand.getEmail(), loginRequestCommand.getPass());
    }

    public static ResetPasswordModel convertResetPasswordCommandToModel(ResetPasswordCommand c) {
        return new ResetPasswordModel(c.getEmail(), c.getOldPass(), c.getPass());
    }
}
