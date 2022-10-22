package com.grade.project.domain.services.user;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.UserModel;
import com.grade.project.domain.port.UserRepository;

public class CreateUserService {

    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserModel userModel) {
        return this.userRepository.createUser(userModel);
    }
}
