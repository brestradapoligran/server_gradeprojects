package com.grade.project.infrastructure.controllers.user;

import com.grade.project.domain.enums.user.UserRoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GetUserRolesControllerTest {

    @Autowired
    private GetUserRolesController controller;

    @Test
    public void getRolesSuccess() {
        UserRoleEnum[] userRoleEnums = this.controller.getRoles();
        System.out.println(userRoleEnums);
    }
}
