package com.grade.project.infrastructure.controllers.object;

import com.grade.project.application.handler.object.GetObjectHandler;
import com.grade.project.domain.dto.ObjectDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/object")
public class GetObjectController {

    private final GetObjectHandler getObjectHandler;

    @GetMapping("/{id}")
    public ObjectDto getObject(@PathVariable String id) {
        return this.getObjectHandler.getObject(id);
    }
}
