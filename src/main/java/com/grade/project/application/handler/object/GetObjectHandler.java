package com.grade.project.application.handler.object;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.services.object.GetObjectService;
import org.springframework.stereotype.Component;

@Component
public class GetObjectHandler {

    private final GetObjectService getObjectService;

    public GetObjectHandler(GetObjectService getObjectService) {
        this.getObjectService = getObjectService;
    }

    public ObjectDto getObject(String id) {
        return this.getObjectService.getObject(id);
    }
}
