package com.grade.project.domain.model;

import com.grade.project.domain.enums.ObjectTypeEnum;
import com.grade.project.domain.utils.validations.DataValidation;

public class ObjectModel {
    private String id;
    private String name;
    private String description;
    private ObjectTypeEnum status;

    public ObjectModel() {
    }

    public ObjectModel(String id, String name, String description, ObjectTypeEnum status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.dataValidation();
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

    public ObjectTypeEnum getStatus() {
        return status;
    }

    public void setStatus(ObjectTypeEnum status) {
        this.status = status;
    }

    private void dataValidation() {
        DataValidation.validationRequired(this.name, "Error: El nombre es obligatorio");
        DataValidation.validationRequired(this.description, "Error: La descripción es obligatoria");
        DataValidation.validationRequired(this.status, "Error: El status es obligatorio");
    }
}
