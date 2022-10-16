package com.grade.project.domain.services.objecttype;

import com.grade.project.domain.dto.ObjectTypeDto;
import com.grade.project.domain.model.ObjectTypeModel;
import com.grade.project.domain.port.ObjectTypeRepository;

public class CreateObjectTypeService {

    private final ObjectTypeRepository objectTypeRepository;

    public CreateObjectTypeService(ObjectTypeRepository objectTypeRepository) {
        this.objectTypeRepository = objectTypeRepository;
    }

    public ObjectTypeDto createObjectType(ObjectTypeModel objectTypeModel) {
        return this.objectTypeRepository.createObjectType(objectTypeModel);
    }
}
