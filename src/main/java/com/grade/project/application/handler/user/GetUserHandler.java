package com.grade.project.application.handler.user;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.services.user.GetUserService;
import org.springframework.stereotype.Component;

@Component
public class GetUserHandler {

    private final GetUserService getUserService;

    public GetUserHandler(GetUserService getUserService) {
        this.getUserService = getUserService;
    }

    public UserDto getUser(String id) {
        return this.getUserService.getUser(id);
    }
}
