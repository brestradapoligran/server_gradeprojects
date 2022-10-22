package com.grade.project.domain.port;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.UserModel;

public interface UserRepository {

    UserDto createUser(UserModel userModel);

    UserDto updateUser(UserModel userModel);

    UserDto getUser(String id);

    UserDto getUsers();

    String disableUser(String id);
}
