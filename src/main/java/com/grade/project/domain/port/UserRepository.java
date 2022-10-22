package com.grade.project.domain.port;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.UserModel;

import java.util.List;

public interface UserRepository {

    UserDto createUser(UserModel userModel);

    UserDto updateUser(UserModel userModel);

    UserDto getUser(String id);

    List<UserDto> getUsers();

    String disableUser(String id);
}
