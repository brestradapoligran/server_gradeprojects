package com.grade.project.application.handler.user;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.enums.user.UserStatusEnum;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.GetUsersService;
import com.grade.project.infrastructure.controllers.user.GetUsersController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetUsersControllerTest {

    private GetUsersController getUsersController;
    private GetUsersHandler getUsersHandler;
    private GetUsersService getUsersService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        getUsersService = new GetUsersService(userRepository);
        getUsersHandler = new GetUsersHandler(getUsersService);
        getUsersController = new GetUsersController(getUsersHandler);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserStatusTest() {
        when(getUsersService.getUsers()).thenReturn(this.getUserListDto());

        List<UserDto> users = this.getUsersController.getUsers();

        Assert.assertEquals("1", users.get(0).getId());
        Assert.assertEquals("Name", users.get(0).getName());
        Assert.assertEquals("LastName", users.get(0).getLastName());
        Assert.assertEquals("Email", users.get(0).getEmail());
        Assert.assertEquals(UserRoleEnum.Administrador, users.get(0).getRole());
        Assert.assertEquals(UserStatusEnum.Activo, users.get(0).getStatus());
    }

    private List<UserDto> getUserListDto() {
        UserDto userDto = new UserDto("1", "Name", "LastName", "Email", UserRoleEnum.Administrador, UserStatusEnum.Activo);
        List<UserDto> list = new ArrayList<>();
        list.add(userDto);
        return list;
    }
}
