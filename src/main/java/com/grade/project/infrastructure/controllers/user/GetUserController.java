package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.handler.user.GetUserHandler;
import com.grade.project.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class GetUserController {

    private final GetUserHandler getUserHandler;

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable String id) {
        return this.getUserHandler.getUser(id);
    }
}
