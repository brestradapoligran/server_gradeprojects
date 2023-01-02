package com.grade.project.infrastructure.document;

import com.grade.project.application.command.FeatureCommand;
import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "objects")
public class ObjectDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private ObjectStatusEnum status;
    private ObjectTypeEnum type;
    private List<FeatureDocument> features;

    public ObjectDocument() {
    }

    public ObjectDocument(String id, String name, String description, ObjectStatusEnum status, ObjectTypeEnum type, List<FeatureDocument> features) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.type = type;
        this.features = features;
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

    public List<FeatureDocument> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureDocument> features) {
        this.features = features;
    }
}
