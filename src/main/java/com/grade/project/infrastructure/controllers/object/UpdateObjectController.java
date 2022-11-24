package com.grade.project.infrastructure.controllers.object;

import com.grade.project.application.command.ObjectCommand;
import com.grade.project.application.handler.object.UpdateObjectHandler;
import com.grade.project.domain.dto.ObjectDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/object")
public class UpdateObjectController {

    private final UpdateObjectHandler updateObjectHandler;

    @PutMapping("/{id}")
    public ObjectDto updateObject(@PathVariable String id, @RequestBody ObjectCommand objectCommand) {
        return this.updateObjectHandler.updateObject(id, objectCommand);
    }
}
