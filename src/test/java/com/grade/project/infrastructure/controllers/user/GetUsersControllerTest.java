package com.grade.project.infrastructure.controllers.user;

import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.enums.user.UserStatusEnum;
import com.grade.project.infrastructure.document.UserDocument;
import com.grade.project.infrastructure.mongorepository.UserMongoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class GetUsersControllerTest {

    @InjectMocks
    private GetUsersController getUsersController;

    @Mock
    private UserMongoRepository userMongoRepository;

    @Test
    public void getUsersControllerSuccess() {
        List<UserDocument> usersList = new ArrayList<>();
        UserDocument userDocument= new UserDocument();
        userDocument.setId("1");
        userDocument.setName("John");
        userDocument.setLastName("Doe");
        userDocument.setEmail("prueba@gmail.com");
        userDocument.setRole(UserRoleEnum.Administrador);
        userDocument.setStatus(UserStatusEnum.Inactivo);
        usersList.add(userDocument);
        Mockito.when(this.userMongoRepository.findAll()).thenReturn(usersList);
        this.getUsersController.getUsers();
    }
}
