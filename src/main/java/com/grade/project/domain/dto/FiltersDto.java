package com.grade.project.domain.dto;

import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;

public class FiltersDto {

    private final ObjectTypeEnum[] objectTypes;
    private final ObjectStatusEnum[] objectStatuses;

    public FiltersDto() {
        this.objectTypes = ObjectTypeEnum.values();
        this.objectStatuses = ObjectStatusEnum.values();
    }

    public ObjectTypeEnum[] getObjectTypes() {
        return objectTypes;
    }

    public ObjectStatusEnum[] getObjectStatuses() {
        return objectStatuses;
    }
}
