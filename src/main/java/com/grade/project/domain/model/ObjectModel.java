package com.grade.project.domain.model;

import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;
import com.grade.project.domain.utils.validations.DataValidation;

import java.util.List;
import java.util.Map;

public class ObjectModel {
    private String id;
    private String name;
    private String description;
    private ObjectStatusEnum status;
    private ObjectTypeEnum type;
    private List<FeatureModel> features;
    private ClaimerModel claimer;

    public ObjectModel() {
    }

    public ObjectModel(String id, String name, String description, ObjectStatusEnum status, ObjectTypeEnum type, List<FeatureModel> features, ClaimerModel claimer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.type = type;
        this.features = features;
        this.claimer = claimer;
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

    public List<FeatureModel> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureModel> features) {
        this.features = features;
    }

    public ClaimerModel getClaimer() {
        return claimer;
    }

    public void setClaimer(ClaimerModel claimer) {
        this.claimer = claimer;
    }

    private void dataValidation() {
        DataValidation.validationRequired(this.name, "Error: El nombre es obligatorio");
        DataValidation.validationRequired(this.description, "Error: La descripción es obligatoria");
        DataValidation.validationRequired(this.status, "Error: El status es obligatorio");
        DataValidation.validationRequired(this.type, "Error: El tipo es obligatorio");
    }
}
