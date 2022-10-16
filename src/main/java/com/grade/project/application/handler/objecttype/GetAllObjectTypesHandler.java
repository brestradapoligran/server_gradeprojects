package com.grade.project.application.handler.objecttype;

import com.grade.project.domain.dto.ObjectTypeDto;
import com.grade.project.domain.services.objecttype.GetAllObjectTypesService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllObjectTypesHandler {

    private final GetAllObjectTypesService getAllObjectTypesService;

    public GetAllObjectTypesHandler(GetAllObjectTypesService getAllObjectTypesService) {
        this.getAllObjectTypesService = getAllObjectTypesService;
    }

    public List<ObjectTypeDto> getAllObjectTypeDto() {
        return this.getAllObjectTypesService.getAllObjectTypes();
    }
}
