package com.grade.project.domain.services.user;

import com.grade.project.domain.port.UserRepository;

public class DeleteUserService {

    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(String id) {
        this.userRepository.deleteUser(id);
    }
}
