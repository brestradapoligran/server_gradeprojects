package com.grade.project.infrastructure.controllers.object;

import com.grade.project.application.command.ObjectCommand;
import com.grade.project.application.handler.object.CreateObjectHandler;
import com.grade.project.domain.dto.ObjectDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/object/")
public class CreateObjectController {

    private final CreateObjectHandler createObjectHandler;

    public CreateObjectController(CreateObjectHandler createObjectHandler) {
        this.createObjectHandler = createObjectHandler;
    }

    @PostMapping("create")
    public ObjectDto createObject(@RequestBody ObjectCommand objectCommand) {
        return this.createObjectHandler.createObjectHandler(objectCommand);
    }

}
