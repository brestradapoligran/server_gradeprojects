package com.grade.project.application.handler.object;

import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.domain.services.object.DeleteObjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class DeleteObjectHandlerTest {

    private DeleteObjectHandler deleteObjectHandler;
    @Mock
    private DeleteObjectService deleteObjectService;

    @Mock
    private ObjectRepository objectRepository;


    @Before
    public void setUp() {
        deleteObjectHandler = new DeleteObjectHandler(deleteObjectService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deleteSuccess() {
        this.deleteObjectHandler.run("1");
    }

}
