package com.grade.project.application.handler.user;

import com.grade.project.application.command.UserCommand;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.services.user.ChangeUserStatusService;
import org.springframework.stereotype.Component;

@Component
public class ChangeUserStatusHandler {

    private final ChangeUserStatusService changeUserStatusService;

    public ChangeUserStatusHandler(ChangeUserStatusService changeUserStatusService) {
        this.changeUserStatusService = changeUserStatusService;
    }

    public UserDto changeStatus(String id) {
        return this.changeUserStatusService.changeStatus(id);
    }
}
