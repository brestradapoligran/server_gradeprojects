package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.handler.user.DeleteUserHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class DeleteUserController {

    private final DeleteUserHandler deleteUserHandler;

    public DeleteUserController(DeleteUserHandler deleteUserHandler) {
        this.deleteUserHandler = deleteUserHandler;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id) {
        this.deleteUserHandler.deleteUser(id);
    }
}
