package com.grade.project.application.handler.object;

import com.grade.project.domain.services.object.DeleteObjectService;
import org.springframework.stereotype.Component;

@Component
public class DeleteObjectHandler {

    private final DeleteObjectService deleteObjectService;

    public DeleteObjectHandler(DeleteObjectService deleteObjectService) {
        this.deleteObjectService = deleteObjectService;
    }

    public void run(String id) {
        this.deleteObjectService.run(id);
    }
}
