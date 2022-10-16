package com.grade.project.domain.services.object;

import com.grade.project.domain.port.ObjectRepository;

public class DeleteObjectService {

    private final ObjectRepository objectRepository;

    public DeleteObjectService(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public void run(String id) {
        this.objectRepository.deleteObject(id);
    }
}
