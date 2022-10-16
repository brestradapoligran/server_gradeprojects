package com.grade.project.application.handler.object;

import com.grade.project.application.command.ObjectCommand;
import com.grade.project.application.factory.ObjectFactory;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.services.object.CreateObjectService;
import org.springframework.stereotype.Component;

@Component
public class CreateObjectHandler {

    private final CreateObjectService createObjectService;

    public CreateObjectHandler(CreateObjectService createObjectService) {
        this.createObjectService = createObjectService;
    }

    public ObjectDto createObjectHandler(ObjectCommand objectCommand) {
        return this.createObjectService.run(ObjectFactory.createObjectFactory(objectCommand));
    }
}
