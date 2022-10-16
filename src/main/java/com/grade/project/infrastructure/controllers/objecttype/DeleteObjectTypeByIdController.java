package com.grade.project.infrastructure.controllers.objecttype;

import com.grade.project.application.handler.objecttype.DeleteObjectTypeByIdHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/object/type")
public class DeleteObjectTypeByIdController {

    private final DeleteObjectTypeByIdHandler deleteObjectTypeByIdHandler;

    public DeleteObjectTypeByIdController(DeleteObjectTypeByIdHandler deleteObjectTypeByIdHandler) {
        this.deleteObjectTypeByIdHandler = deleteObjectTypeByIdHandler;
    }

    @DeleteMapping("/{id}")
    public void deleteObjectTypeById(@PathVariable String id) {
        this.deleteObjectTypeByIdHandler.deleteObjectTypeById(id);
    }
}
