package com.grade.project.application.command;

import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ObjectCommandTest {

    @Test
    public void createObjectCommandWithEmptyConstructor() {
        ObjectCommand objectCommand = new ObjectCommand();
    }

    @Test
    public void createObjectCommandWithConstructor() {
        ObjectCommand objectCommand = new ObjectCommand("Name", "Description", ObjectStatusEnum.PERDIDO, ObjectTypeEnum.Celular, new ArrayList<>());
        Assert.assertEquals("Name", objectCommand.getName());
        Assert.assertEquals("Description", objectCommand.getDescription());
        Assert.assertEquals(ObjectStatusEnum.PERDIDO, objectCommand.getStatus());
        Assert.assertEquals(ObjectTypeEnum.Celular, objectCommand.getType());
        Assert.assertTrue(objectCommand.getFeatures().isEmpty());
    }
}
