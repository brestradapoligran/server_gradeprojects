package com.grade.project.application.handler.object;

import com.grade.project.application.command.ObjectCommand;
import com.grade.project.application.factory.ObjectFactory;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.services.object.UpdateObjectService;
import org.springframework.stereotype.Component;

@Component
public class UpdateObjectHandler {

    private final UpdateObjectService updateObjectService;

    public UpdateObjectHandler(UpdateObjectService updateObjectService) {
        this.updateObjectService = updateObjectService;
    }

    public ObjectDto updateObject(String id, ObjectCommand objectCommand) {
        return this.updateObjectService.updateObject(ObjectFactory.createObjectFactory(id, objectCommand));
    }
}
