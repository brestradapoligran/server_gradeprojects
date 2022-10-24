package com.grade.project.application.factory;

import com.grade.project.application.command.ObjectCommand;
import com.grade.project.domain.model.ObjectModel;

public class ObjectFactory {

    public static ObjectModel createObjectFactory(ObjectCommand objectCommand) {
        return new ObjectModel(objectCommand.getName(), objectCommand.getDescription(), objectCommand.getStatus());
    }
}
