package com.grade.project.infrastructure.controllers.objecttype;

import com.grade.project.application.handler.objecttype.GetAllObjectTypesHandler;
import com.grade.project.domain.dto.ObjectTypeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/object/types")
public class GetAllObjectTypesController {

    private final GetAllObjectTypesHandler getAllObjectTypesHandler;

    public GetAllObjectTypesController(GetAllObjectTypesHandler getAllObjectTypesHandler) {
        this.getAllObjectTypesHandler = getAllObjectTypesHandler;
    }

    @GetMapping
    public List<ObjectTypeDto> getAllObjectType() {
        return this.getAllObjectTypesHandler.getAllObjectTypeDto();
    }
}
