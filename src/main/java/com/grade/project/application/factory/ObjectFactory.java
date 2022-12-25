package com.grade.project.application.factory;

import com.grade.project.application.command.FiltersObjectCommand;
import com.grade.project.application.command.ObjectCommand;
import com.grade.project.domain.model.FiltersObjectModel;
import com.grade.project.domain.model.ObjectModel;

public class ObjectFactory {

    public static ObjectModel createObjectFactory(ObjectCommand objectCommand) {
        return new ObjectModel(null, objectCommand.getName(), objectCommand.getDescription(), objectCommand.getStatus(), objectCommand.getType());
    }

    public static ObjectModel createObjectFactory(String id, ObjectCommand objectCommand) {
        return new ObjectModel(id, objectCommand.getName(), objectCommand.getDescription(), objectCommand.getStatus(), objectCommand.getType());
    }

    public static FiltersObjectModel filtersObjectFactory(FiltersObjectCommand filtersCommand) {
        return new FiltersObjectModel(filtersCommand.getSearchWord(), filtersCommand.getObjectTypes());
    }
}
