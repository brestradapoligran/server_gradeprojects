package com.grade.project.application.handler.object;

import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;
import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.domain.services.object.GetAllObjectsService;
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
public class GetAllObjectHandlerTest {

    private GetAllObjectsHandler getAllObjectsHandler;
    private GetAllObjectsService getAllObjectService;

    @Mock
    private ObjectRepository objectRepository;


    @Before
    public void setUp() {
        getAllObjectService = new GetAllObjectsService(objectRepository);
        getAllObjectsHandler = new GetAllObjectsHandler(getAllObjectService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void creationSuccess() {
        when(getAllObjectService.getObjects()).thenReturn(this.getObjectDtoList());
        List<ObjectDto> objectDtos = this.getAllObjectsHandler.getObjects();
        Assert.assertEquals(objectDtos.get(0).getId(), "1");
        Assert.assertEquals(objectDtos.get(1).getId(), "2");
    }

    private List<ObjectDto> getObjectDtoList() {
        List<ObjectDto> objectDtos = new ArrayList<>();
        List<FeatureDto> featureDtos = new ArrayList<>();
        FeatureDto featureDocument = new FeatureDto(ObjectFeatureTypeEnum.Color, "Gris");
        featureDtos.add(featureDocument);
        objectDtos.add(new ObjectDto("1", "Civica", "Civica Description", ObjectStatusEnum.PERDIDO, ObjectTypeEnum.Civica, featureDtos));
        objectDtos.add(new ObjectDto("2", "Celular", "Celular Description", ObjectStatusEnum.RECLAMADO, ObjectTypeEnum.Celular, featureDtos));
        return objectDtos;
    }

}
