package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.handler.user.GetUsersHandler;
import com.grade.project.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class GetUsersController {

    private final GetUsersHandler getUsersHandler;

    @GetMapping
    public List<UserDto> getUsers() {
        return this.getUsersHandler.getUsers();
    }
}
