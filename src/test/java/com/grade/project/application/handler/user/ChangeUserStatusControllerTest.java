package com.grade.project.application.handler.user;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.enums.user.UserStatusEnum;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.ChangeUserStatusService;
import com.grade.project.infrastructure.controllers.user.ChangeUserStatusController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChangeUserStatusControllerTest {

    private ChangeUserStatusController changeUserStatusController;
    private ChangeUserStatusHandler changeUserStatusHandler;
    private ChangeUserStatusService changeUserStatusService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        changeUserStatusService = new ChangeUserStatusService(userRepository);
        changeUserStatusHandler = new ChangeUserStatusHandler(changeUserStatusService);
        changeUserStatusController = new ChangeUserStatusController(changeUserStatusHandler);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserStatusTest() {
        when(changeUserStatusService.changeStatus(ArgumentMatchers.anyString())).thenReturn(this.getUserDto());

        UserDto userDto = this.changeUserStatusController.changeStatus("1");

        Assert.assertEquals("1", userDto.getId());
        Assert.assertEquals("Name", userDto.getName());
        Assert.assertEquals("LastName", userDto.getLastName());
        Assert.assertEquals("Email", userDto.getEmail());
        Assert.assertEquals(UserRoleEnum.Administrador, userDto.getRole());
        Assert.assertEquals(UserStatusEnum.Activo, userDto.getStatus());
    }

    private UserDto getUserDto() {
        return new UserDto("1", "Name", "LastName", "Email", UserRoleEnum.Administrador, UserStatusEnum.Activo);
    }
}
