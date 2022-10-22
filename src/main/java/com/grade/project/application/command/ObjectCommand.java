package com.grade.project.application.command;

public class ObjectCommand {
    private String name;
    private String description;

    private String status;

    private ObjectTypeCommand objectTypeCommand;

    public ObjectCommand(String name, String description, String status) {
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

    public String getStatus() {
        return status;
    }
}
