package com.grade.project.application.factory;

import com.grade.project.application.command.FeatureCommand;
import com.grade.project.domain.model.FeatureModel;

public class FeatureFactory {

    public static FeatureModel convertToModel(FeatureCommand c) {
        return new FeatureModel(c.getName(), c.getDescription());
    }

    public static FeatureModel convertToModel(String id, FeatureCommand c) {
        return new FeatureModel(c.getName(), c.getDescription());
    }
}
