package com.grade.project.application.command;

import com.grade.project.domain.enums.ObjectTypeEnum;

public class ObjectCommand {
    private String name;
    private String description;
    private ObjectTypeEnum status;

    public ObjectCommand() {
    }

    public ObjectCommand(String name, String description, ObjectTypeEnum status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ObjectTypeEnum getStatus() {
        return status;
    }
}
