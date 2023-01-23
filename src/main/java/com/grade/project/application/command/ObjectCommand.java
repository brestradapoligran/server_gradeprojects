package com.grade.project.application.command;

import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ObjectCommand {
    private String name;
    private String description;
    private ObjectStatusEnum status;
    private ObjectTypeEnum type;
    private List<FeatureCommand> features;
    private ClaimerCommand claimer;
    private String lostDate;

    public ObjectCommand() {
    }

    public ObjectCommand(String name, String description, ObjectStatusEnum status, ObjectTypeEnum type, List<FeatureCommand> features, ClaimerCommand claimer, String lostDate) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.type = type;
        this.features = features;
        this.claimer = claimer;
        this.lostDate = lostDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ObjectStatusEnum getStatus() {
        return status;
    }

    public ObjectTypeEnum getType() {
        return type;
    }

    public List<FeatureCommand> getFeatures() {
        return features;
    }

    public ClaimerCommand getClaimer() {
        return claimer;
    }

    public String getLostDate() {
        return lostDate;
    }
}
