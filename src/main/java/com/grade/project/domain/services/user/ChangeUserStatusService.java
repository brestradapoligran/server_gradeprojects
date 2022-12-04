package com.grade.project.domain.services.user;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.port.UserRepository;

public class ChangeUserStatusService {

    private final UserRepository userRepository;

    public ChangeUserStatusService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto changeStatus(String id) {
        return this.userRepository.changeStatus(id);
    }
}
