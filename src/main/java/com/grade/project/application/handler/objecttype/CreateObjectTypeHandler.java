package com.grade.project.application.handler.objecttype;

import com.grade.project.application.command.ObjectTypeCommand;
import com.grade.project.application.factory.ObjectTypeFactory;
import com.grade.project.domain.dto.ObjectTypeDto;
import com.grade.project.domain.services.objecttype.CreateObjectTypeService;
import org.springframework.stereotype.Component;

@Component
public class CreateObjectTypeHandler {

    private final CreateObjectTypeService createObjectTypeService;

    public CreateObjectTypeHandler(CreateObjectTypeService createObjectTypeService) {
        this.createObjectTypeService = createObjectTypeService;
    }

    public ObjectTypeDto createObjectType(ObjectTypeCommand objectTypeCommand) {
        return this.createObjectTypeService.createObjectType(ObjectTypeFactory.createObject(objectTypeCommand));
    }
}
