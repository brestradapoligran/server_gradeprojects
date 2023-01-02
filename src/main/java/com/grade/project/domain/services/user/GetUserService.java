package com.grade.project.domain.services.user;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.port.UserRepository;

public class GetUserService {

    private final UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUser(String id) {
        return this.userRepository.getUser(id);
    }

    public UserDto getMyUser(String email) {
        return this.userRepository.getMyUser(email);
    }
}
