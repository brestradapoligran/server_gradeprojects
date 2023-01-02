package com.grade.project.infrastructure.document;

import com.grade.project.domain.enums.object.ObjectFeatureTypeEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class FeatureDocument {

    private ObjectFeatureTypeEnum name;
    private String description;

    public FeatureDocument() {
    }

    public FeatureDocument(ObjectFeatureTypeEnum name, String description) {
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
