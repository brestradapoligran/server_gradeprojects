package com.grade.project.application.handler.object;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.services.object.GetAllObjectsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllObjectsHandler {

    private final GetAllObjectsService getAllObjectsService;

    public GetAllObjectsHandler(GetAllObjectsService getAllObjectsService) {
        this.getAllObjectsService = getAllObjectsService;
    }

    public List<ObjectDto> getObjects() {
        return this.getAllObjectsService.getObjects();
    }
}
