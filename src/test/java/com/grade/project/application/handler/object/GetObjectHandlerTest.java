package com.grade.project.application.handler.object;

import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;
import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.domain.services.object.GetObjectService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class GetObjectHandlerTest {

    private GetObjectHandler getObjectHandler;
    private GetObjectService getObjectService;

    @Mock
    private ObjectRepository objectRepository;


    @Before
    public void setUp() {
        getObjectService = new GetObjectService(objectRepository);
        getObjectHandler = new GetObjectHandler(getObjectService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void creationSuccess() {
        when(getObjectService.getObject(anyString())).thenReturn(this.getObjectDto());
        ObjectDto objectDtos = this.getObjectHandler.getObject("1");
        Assert.assertEquals(objectDtos.getId(), "1");
    }

    private ObjectDto getObjectDto() {
        List<FeatureDto> featureDtos = new ArrayList<>();
        FeatureDto featureDocument = new FeatureDto(ObjectFeatureTypeEnum.Color, "Gris");
        featureDtos.add(featureDocument);
        return new ObjectDto("1", "Civica", "Civica Description", ObjectStatusEnum.PERDIDO, ObjectTypeEnum.Civica, featureDtos);
    }

}
