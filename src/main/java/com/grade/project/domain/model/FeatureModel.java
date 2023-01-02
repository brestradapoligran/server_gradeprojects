package com.grade.project.domain.model;

import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import com.grade.project.domain.utils.validations.DataValidation;

public class FeatureModel {

    private ObjectFeatureTypeEnum name;
    private String description;

    public FeatureModel() {
    }

    public FeatureModel(ObjectFeatureTypeEnum name, String description) {
        this.name = name;
        this.description = description;
        this.validateData();
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

    private void validateData() {
        DataValidation.validationRequired(this.name, "Error: El nombre es obligatorio");
    }
}
