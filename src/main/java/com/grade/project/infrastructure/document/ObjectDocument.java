package com.grade.project.infrastructure.document;

import com.grade.project.domain.enums.ObjectStatusEnum;
import com.grade.project.domain.enums.ObjectTypeEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "objects")
public class ObjectDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private ObjectStatusEnum status;
    private ObjectTypeEnum type;

    public ObjectDocument() {
    }

    public ObjectDocument(String id, String name, String description, ObjectStatusEnum status, ObjectTypeEnum type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.type = type;
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
}
