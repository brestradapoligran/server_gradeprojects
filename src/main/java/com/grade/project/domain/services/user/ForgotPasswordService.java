package com.grade.project.domain.services.user;

import com.grade.project.domain.port.UserRepository;

public class ForgotPasswordService {

    private final UserRepository userRepository;

    public ForgotPasswordService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void sendForgotEmail(String email) {
        this.userRepository.sendEmailForgotPassword(email);
    }
}
