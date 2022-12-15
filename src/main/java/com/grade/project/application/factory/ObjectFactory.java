package com.grade.project.application.factory;

import com.grade.project.application.command.ObjectCommand;
import com.grade.project.domain.enums.ObjectTypeEnum;
import com.grade.project.domain.model.ObjectModel;

public class ObjectFactory {

    public static ObjectModel createObjectFactory(ObjectCommand objectCommand) {
        return new ObjectModel(null, objectCommand.getName(), objectCommand.getDescription(), ObjectTypeEnum.RECLAMADO);
    }

    public static ObjectModel createObjectFactory(String id, ObjectCommand objectCommand) {
        return new ObjectModel(id, objectCommand.getName(), objectCommand.getDescription(), objectCommand.getStatus());
    }
}
