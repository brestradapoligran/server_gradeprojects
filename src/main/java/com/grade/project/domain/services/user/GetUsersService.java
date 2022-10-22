package com.grade.project.domain.services.user;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.port.UserRepository;

import java.util.List;

public class GetUsersService {

    private final UserRepository userRepository;

    public GetUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers() {
        return this.userRepository.getUsers();
    }
}
