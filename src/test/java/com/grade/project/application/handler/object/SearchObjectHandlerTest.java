package com.grade.project.application.handler.object;

import com.grade.project.application.command.FiltersObjectCommand;
import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;
import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.domain.services.object.GetObjectService;
import com.grade.project.domain.services.object.SearchObjectService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SearchObjectHandlerTest {

    private SearchObjectHandler searchObjectHandler;
    private SearchObjectService searchObjectService;

    @Mock
    private ObjectRepository objectRepository;


    @Before
    public void setUp() {
        searchObjectService = new SearchObjectService(objectRepository);
        searchObjectHandler = new SearchObjectHandler(searchObjectService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void creationSuccess() {
        Set<ObjectDto> dtoSet = new HashSet<>();
        dtoSet.add(this.getObjectDto());
        when(searchObjectService.searchObject(any(FiltersObjectCommand.class))).thenReturn(dtoSet);
        Set<ObjectDto> objectDtos = this.searchObjectHandler.searchObject(new FiltersObjectCommand());
        Assert.assertEquals(objectDtos.stream().findFirst().get().getId(), "1");
    }

    private ObjectDto getObjectDto() {
        List<FeatureDto> featureDtos = new ArrayList<>();
        FeatureDto featureDocument = new FeatureDto(ObjectFeatureTypeEnum.Color, "Gris");
        featureDtos.add(featureDocument);
        return new ObjectDto("1", "Civica", "Civica Description", ObjectStatusEnum.PERDIDO, ObjectTypeEnum.Civica, featureDtos);
    }

}
