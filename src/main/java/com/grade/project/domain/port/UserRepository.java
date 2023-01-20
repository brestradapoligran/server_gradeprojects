package com.grade.project.domain.port;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.LoginRequestModel;
import com.grade.project.domain.model.ResetPasswordModel;
import com.grade.project.domain.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    UserDto createUser(UserModel userModel);

    UserDto updateUser(UserModel userModel);

    UserDto getUser(String id);

    UserDto getMyUser(String email);

    List<UserDto> getUsers();

    UserDto login(LoginRequestModel loginRequestModel);

    UserDto changeStatus(String id);

    void sendEmailForgotPassword(String email);

    void resetPassword(String email, String pass);

    void updatePassword(ResetPasswordModel resetPasswordModel);

    UserDto updateMyUser(String email, UserModel userModel);
}
