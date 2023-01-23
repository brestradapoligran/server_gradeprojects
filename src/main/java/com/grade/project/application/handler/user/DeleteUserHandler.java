package com.grade.project.application.handler.user;

import com.grade.project.domain.services.user.DeleteUserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserHandler {

    private final DeleteUserService deleteUserService;

    public DeleteUserHandler(DeleteUserService deleteUserService) {
        this.deleteUserService = deleteUserService;
    }

    public void deleteUser(String id) {
        this.deleteUserService.deleteUser(id);
    }
}
