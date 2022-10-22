package com.grade.project.domain.services.user;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.UserModel;
import com.grade.project.domain.port.UserRepository;

public class UpdateUserService {

    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto updateUser(UserModel userModel) {
        return this.userRepository.updateUser(userModel);
    }
}
