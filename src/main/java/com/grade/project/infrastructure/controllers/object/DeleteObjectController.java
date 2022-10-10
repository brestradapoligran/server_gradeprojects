package com.grade.project.infrastructure.controllers.object;

import com.grade.project.application.handler.object.DeleteObjectHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/object/")
public class DeleteObjectController {

    private final DeleteObjectHandler deleteObjectHandler;

    public DeleteObjectController(DeleteObjectHandler deleteObjectHandler) {
        this.deleteObjectHandler = deleteObjectHandler;
    }

    @DeleteMapping("delete/{id}")
    public void deleteObject(@PathVariable String id) {
        this.deleteObjectHandler.run(id);
    }
}
