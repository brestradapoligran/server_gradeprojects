package com.grade.project.application.handler.objecttype;

import com.grade.project.domain.services.objecttype.DeleteObjectTypeByIdService;
import org.springframework.stereotype.Component;

@Component
public class DeleteObjectTypeByIdHandler {

    private final DeleteObjectTypeByIdService deleteObjectTypeByIdService;

    public DeleteObjectTypeByIdHandler(DeleteObjectTypeByIdService deleteObjectTypeByIdService) {
        this.deleteObjectTypeByIdService = deleteObjectTypeByIdService;
    }

    public void deleteObjectTypeById(String id) {
        this.deleteObjectTypeByIdService.deleteObjectTypeById(id);
    }
}
