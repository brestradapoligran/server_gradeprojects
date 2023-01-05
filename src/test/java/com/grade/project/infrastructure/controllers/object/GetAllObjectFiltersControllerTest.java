package com.grade.project.infrastructure.controllers.object;

import com.grade.project.application.handler.object.GetAllObjectsHandler;
import com.grade.project.domain.services.object.GetAllObjectsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GetAllObjectFiltersControllerTest {

    private GetAllObjectFiltersController getAllObjectFiltersController;

    @Before
    public void setUp() {
        getAllObjectFiltersController = new GetAllObjectFiltersController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void GetAllFilters() {
        this.getAllObjectFiltersController.getFilters();
    }
}
