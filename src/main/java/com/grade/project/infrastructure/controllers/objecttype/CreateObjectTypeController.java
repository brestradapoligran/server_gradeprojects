package com.grade.project.infrastructure.controllers.objecttype;

import com.grade.project.application.command.ObjectTypeCommand;
import com.grade.project.application.handler.objecttype.CreateObjectTypeHandler;
import com.grade.project.domain.dto.ObjectTypeDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/object/type")
public class CreateObjectTypeController {

    private final CreateObjectTypeHandler createObjectTypeHandler;

    public CreateObjectTypeController(CreateObjectTypeHandler createObjectTypeHandler) {
        this.createObjectTypeHandler = createObjectTypeHandler;
    }

    @PostMapping
    public ObjectTypeDto objectTypeDto(@RequestBody ObjectTypeCommand objectTypeCommand) {
        return this.createObjectTypeHandler.createObjectType(objectTypeCommand);
    }
}
