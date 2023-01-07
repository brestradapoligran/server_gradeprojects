package com.grade.project.domain.services.user;

import com.grade.project.domain.model.ResetPasswordModel;
import com.grade.project.domain.port.UserRepository;

public class ResetPasswordService {

    private final UserRepository userRepository;

    public ResetPasswordService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void resetPassword(String email, String pass) {
        this.userRepository.resetPassword(email, pass);
    }

    public void updatePassword(ResetPasswordModel resetPasswordModel) {
        this.userRepository.updatePassword(resetPasswordModel);
    }
}
