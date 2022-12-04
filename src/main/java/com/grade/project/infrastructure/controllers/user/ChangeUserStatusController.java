package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.handler.user.ChangeUserStatusHandler;
import com.grade.project.domain.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class ChangeUserStatusController {

    private final ChangeUserStatusHandler changeUserStatusHandler;

    public ChangeUserStatusController(ChangeUserStatusHandler changeUserStatusHandler) {
        this.changeUserStatusHandler = changeUserStatusHandler;
    }

    @PutMapping("/status/{id}")
    public UserDto changeStatus(@PathVariable String id) {
        return this.changeUserStatusHandler.changeStatus(id);
    }
}
