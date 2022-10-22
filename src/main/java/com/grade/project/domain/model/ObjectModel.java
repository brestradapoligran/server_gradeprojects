package com.grade.project.domain.model;

public class ObjectModel {
    private String id;
    private String name;
    private String description;

    private String status;

    private ObjectTypeModel objectTypeModel;

    public ObjectModel() {
    }

    public ObjectModel(String id, String name, String description, String status, ObjectTypeModel objectTypeModel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.objectTypeModel = objectTypeModel;
    }

    public ObjectModel(String name, String description, String status, ObjectTypeModel objectTypeModel) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.objectTypeModel = objectTypeModel;
    }

    public ObjectModel(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
