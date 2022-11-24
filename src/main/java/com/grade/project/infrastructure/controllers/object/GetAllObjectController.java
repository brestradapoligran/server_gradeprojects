package com.grade.project.infrastructure.controllers.object;

import com.grade.project.application.handler.object.GetAllObjectsHandler;
import com.grade.project.domain.dto.ObjectDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/objects")
public class GetAllObjectController {

    private final GetAllObjectsHandler getAllObjectsHandler;

    @GetMapping
    public List<ObjectDto> getObjects() {
        return this.getAllObjectsHandler.getObjects();
    }

}
