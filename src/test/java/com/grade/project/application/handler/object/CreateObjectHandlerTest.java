package com.grade.project.application.handler.object;

import com.grade.project.application.command.FeatureCommand;
import com.grade.project.application.command.ObjectCommand;
import com.grade.project.application.command.ObjectCommandTest;
import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;
import com.grade.project.domain.model.ObjectModel;
import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.domain.services.object.CreateObjectService;
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
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CreateObjectHandlerTest {

    private CreateObjectHandler createObjectHandler;
    private CreateObjectService createObjectService;

    @Mock
    private ObjectRepository objectRepository;


    @Before
    public void setUp() {
        createObjectService = new CreateObjectService(objectRepository);
        createObjectHandler = new CreateObjectHandler(createObjectService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void creationSuccess() {
        when(createObjectService.run(any(ObjectModel.class))).thenReturn(this.getObjectDto());
        ObjectDto objectDto = this.createObjectHandler.createObjectHandler(this.getObjectCommand());
        Assert.assertEquals(objectDto.getId(), "1");
    }

    private ObjectDto getObjectDto() {
        List<FeatureDto> featureDtos = new ArrayList<>();
        FeatureDto featureDocument = new FeatureDto(ObjectFeatureTypeEnum.Color, "Gris");
        featureDtos.add(featureDocument);
        return new ObjectDto("1", "Civica", "Civica Description", ObjectStatusEnum.PERDIDO, ObjectTypeEnum.Civica, featureDtos);
    }

    private ObjectCommand getObjectCommand() {
        List<FeatureCommand> featureCommands = new ArrayList<>();
        FeatureCommand featureCommand = new FeatureCommand(ObjectFeatureTypeEnum.Color, "Gris");
        featureCommands.add(featureCommand);
        return new ObjectCommand("Civica", "Civica Description", ObjectStatusEnum.PERDIDO, ObjectTypeEnum.Civica, featureCommands);
    }

}
