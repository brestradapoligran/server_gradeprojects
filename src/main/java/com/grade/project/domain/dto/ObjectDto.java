package com.grade.project.domain.dto;

import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;
import com.grade.project.domain.model.ClaimerModel;
import com.grade.project.infrastructure.document.FeatureDocument;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ObjectDto {
    private String id;
    private String name;
    private String description;
    private ObjectStatusEnum status;
    private ObjectTypeEnum type;
    private List<FeatureDto> features;
    private ClaimerModel claimer;
    private String lostDate;

    public ObjectDto() {
    }

    public ObjectDto(String id, String name, String description, ObjectStatusEnum status, ObjectTypeEnum type, List<FeatureDto> features, ClaimerModel claimer, String lostDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.type = type;
        this.features = features;
        this.claimer = claimer;
        this.lostDate = lostDate;
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

    public List<FeatureDto> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureDto> features) {
        this.features = features;
    }

    public ClaimerModel getClaimer() {
        return claimer;
    }

    public void setClaimer(ClaimerModel claimer) {
        this.claimer = claimer;
    }

    public String getLostDate() {
        return lostDate;
    }

    public void setLostDate(String lostDate) {
        this.lostDate = lostDate;
    }
}
