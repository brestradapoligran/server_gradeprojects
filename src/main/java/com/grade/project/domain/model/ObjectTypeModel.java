package com.grade.project.domain.model;

import com.grade.project.domain.utils.validations.DataValidation;

public class ObjectTypeModel {
    private String id;
    private String name;
    private String description;

    public ObjectTypeModel() {
    }

    public ObjectTypeModel(String name, String description) {
        this.name = name;
        this.description = description;
        this.validateData();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
