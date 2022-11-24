package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.command.UserCommand;
import com.grade.project.application.handler.user.UpdateUserHandler;
import com.grade.project.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UpdateUserController {

    private final UpdateUserHandler updateUserHandler;

    @PutMapping("/{id}")
    public UserDto updateUser(@RequestBody UserCommand userCommand, @PathVariable String id) {
        return this.updateUserHandler.updateUser(id, userCommand);
    }
}
