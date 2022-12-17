package com.grade.project.application.command;

import com.grade.project.domain.enums.ObjectStatusEnum;
import com.grade.project.domain.enums.ObjectTypeEnum;

public class ObjectCommand {
    private String name;
    private String description;
    private ObjectStatusEnum status;
    private ObjectTypeEnum type;

    public ObjectCommand() {
    }

    public ObjectCommand(String name, String description, ObjectStatusEnum status, ObjectTypeEnum type) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.type = type;
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
}
