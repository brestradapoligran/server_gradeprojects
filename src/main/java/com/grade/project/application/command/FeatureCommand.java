package com.grade.project.application.command;

import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;

public class FeatureCommand {

    private ObjectFeatureTypeEnum name;
    private String description;

    public FeatureCommand() {
    }

    public FeatureCommand(ObjectFeatureTypeEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    public ObjectFeatureTypeEnum getName() {
        return name;
    }

    public void setName(ObjectFeatureTypeEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
