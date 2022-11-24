package com.grade.project.application.handler.user;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.services.user.GetUsersService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUsersHandler {

    private final GetUsersService getUsersService;

    public GetUsersHandler(GetUsersService getUsersService) {
        this.getUsersService = getUsersService;
    }

    public List<UserDto> getUsers() {
        return this.getUsersService.getUsers();
    }
}
