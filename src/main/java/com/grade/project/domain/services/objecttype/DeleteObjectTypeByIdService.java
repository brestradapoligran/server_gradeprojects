package com.grade.project.domain.services.objecttype;

import com.grade.project.domain.port.ObjectTypeRepository;

public class DeleteObjectTypeByIdService {

    private final ObjectTypeRepository objectTypeRepository;

    public DeleteObjectTypeByIdService(ObjectTypeRepository objectTypeRepository) {
        this.objectTypeRepository = objectTypeRepository;
    }

    public void deleteObjectTypeById(String id) {
        this.objectTypeRepository.deleteObjectTypeById(id);
    }
}
