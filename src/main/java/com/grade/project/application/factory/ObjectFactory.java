package com.grade.project.application.factory;

import com.grade.project.application.command.FiltersObjectCommand;
import com.grade.project.application.command.ObjectCommand;
import com.grade.project.domain.model.FeatureModel;
import com.grade.project.domain.model.FiltersObjectModel;
import com.grade.project.domain.model.ObjectModel;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectFactory {

    public static ObjectModel createObjectFactory(ObjectCommand objectCommand) {
        List<FeatureModel> featureModels = objectCommand.getFeatures().stream().map(featureCommand -> new FeatureModel(featureCommand.getName(), featureCommand.getDescription())).collect(Collectors.toList());
        return new ObjectModel(null, objectCommand.getName(), objectCommand.getDescription(), objectCommand.getStatus(), objectCommand.getType(), featureModels);
    }

    public static ObjectModel createObjectFactory(String id, ObjectCommand objectCommand) {
        List<FeatureModel> featureModels = objectCommand.getFeatures().stream().map(featureCommand -> new FeatureModel(featureCommand.getName(), featureCommand.getDescription())).collect(Collectors.toList());
        return new ObjectModel(id, objectCommand.getName(), objectCommand.getDescription(), objectCommand.getStatus(), objectCommand.getType(), featureModels);
    }

}
