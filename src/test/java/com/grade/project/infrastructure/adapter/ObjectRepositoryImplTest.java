package com.grade.project.infrastructure.adapter;

import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;
import com.grade.project.domain.enums.user.UserRoleEnum;
import com.grade.project.domain.enums.user.UserStatusEnum;
import com.grade.project.domain.model.FeatureModel;
import com.grade.project.domain.model.ObjectModel;
import com.grade.project.infrastructure.document.ObjectDocument;
import com.grade.project.infrastructure.document.UserDocument;
import com.grade.project.infrastructure.mongorepository.ObjectMongoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@DataMongoTest
public class ObjectRepositoryImplTest {

    @Autowired
    private ObjectMongoRepository objectMongoRepository;

    @InjectMocks
    private ObjectRepositoryImpl objectRepository;


    @Before
    public void setUp() {
        objectRepository = new ObjectRepositoryImpl(objectMongoRepository);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void changeUserStatusTest() {
        Mockito.when(objectMongoRepository.save(ArgumentMatchers.any(ObjectDocument.class))).thenReturn(this.getObjectDocument());

        ObjectDto userDto = this.objectRepository.createObject(getObjectModel());

        Assert.assertEquals("1", userDto.getId());
        Assert.assertEquals("Name", userDto.getName());
        Assert.assertEquals("Description", userDto.getDescription());
        Assert.assertEquals(ObjectStatusEnum.PERDIDO, userDto.getStatus());
        Assert.assertEquals(ObjectTypeEnum.Civica, userDto.getType());
    }

    private UserDto getUserDto() {
        return new UserDto("1", "Name", "LastName", "Email", UserRoleEnum.Administrador, UserStatusEnum.Activo);
    }

    private ObjectDocument getObjectDocument() {
        ObjectDocument objectDocument = new ObjectDocument();
        objectDocument.setId("1");
        objectDocument.setName("Name");
        objectDocument.setDescription("Description");
        objectDocument.setStatus(ObjectStatusEnum.PERDIDO);
        objectDocument.setType(ObjectTypeEnum.Civica);
        objectDocument.setFeatures(new ArrayList<>());
        return objectDocument;
    }

    private ObjectModel getObjectModel() {
        List<FeatureModel> featureModels = new ArrayList<>();
        FeatureModel featureDocument = new FeatureModel(ObjectFeatureTypeEnum.Color, "Gris");
        featureModels.add(featureDocument);
        return new ObjectModel("1", "Civica", "Civica Description", ObjectStatusEnum.PERDIDO, ObjectTypeEnum.Civica, featureModels);
    }
}
