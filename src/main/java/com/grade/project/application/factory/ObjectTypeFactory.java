package com.grade.project.application.factory;

import com.grade.project.application.command.ObjectTypeCommand;
import com.grade.project.domain.model.ObjectTypeModel;

public class ObjectTypeFactory {

    public static ObjectTypeModel createObject(ObjectTypeCommand objectTypeCommand) {
        return new ObjectTypeModel(objectTypeCommand.getName(), objectTypeCommand.getDescription());
    }
}
