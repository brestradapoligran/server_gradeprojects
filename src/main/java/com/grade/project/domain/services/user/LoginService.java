package com.grade.project.domain.services.user;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.LoginRequestModel;
import com.grade.project.domain.port.UserRepository;

public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto login(LoginRequestModel loginRequestModel) {
        return this.userRepository.login(loginRequestModel);
    }
}
