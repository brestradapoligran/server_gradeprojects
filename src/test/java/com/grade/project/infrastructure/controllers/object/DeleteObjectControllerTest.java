package com.grade.project.infrastructure.controllers.object;

import com.grade.project.application.handler.object.DeleteObjectHandler;
import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.domain.services.object.DeleteObjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DeleteObjectControllerTest {

    private DeleteObjectController deleteObjectController;
    private DeleteObjectHandler deleteObjectHandler;

    private DeleteObjectService deleteObjectService;

    @Mock
    private ObjectRepository objectRepository;


    @Before
    public void setUp() {
        deleteObjectService = new DeleteObjectService(objectRepository);
        deleteObjectHandler = new DeleteObjectHandler(deleteObjectService);
        deleteObjectController = new DeleteObjectController(deleteObjectHandler);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deleteSuccess() {
        this.deleteObjectController.deleteObject("1");
    }

}
