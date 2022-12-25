package com.grade.project.infrastructure.controllers.user;

import com.grade.project.domain.enums.user.UserRoleEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class GetUserRolesController {

    @GetMapping("/roles")
    public UserRoleEnum[] getRoles() {
        return UserRoleEnum.values();
    }

}
