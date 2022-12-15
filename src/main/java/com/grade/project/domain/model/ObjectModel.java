package com.grade.project.domain.model;

import com.grade.project.domain.enums.ObjectStatusEnum;
import com.grade.project.domain.enums.ObjectTypeEnum;
import com.grade.project.domain.utils.validations.DataValidation;

public class ObjectModel {
    private String id;
    private String name;
    private String description;
    private ObjectStatusEnum status;
    private ObjectTypeEnum type;

    public ObjectModel() {
    }

    public ObjectModel(String id, String name, String description, ObjectStatusEnum status, ObjectTypeEnum type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.type = type;
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

    public ObjectStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ObjectStatusEnum status) {
        this.status = status;
    }

    public ObjectTypeEnum getType() {
        return type;
    }

    public void setType(ObjectTypeEnum type) {
        this.type = type;
    }

    private void dataValidation() {
        DataValidation.validationRequired(this.name, "Error: El nombre es obligatorio");
        DataValidation.validationRequired(this.description, "Error: La descripción es obligatoria");
        DataValidation.validationRequired(this.status, "Error: El status es obligatorio");
        DataValidation.validationRequired(this.type, "Error: El tipo es obligatorio");
    }
}
