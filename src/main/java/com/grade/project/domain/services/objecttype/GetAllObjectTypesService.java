package com.grade.project.domain.services.objecttype;

import com.grade.project.domain.dto.ObjectTypeDto;
import com.grade.project.domain.port.ObjectTypeRepository;

import java.util.List;

public class GetAllObjectTypesService {

    private final ObjectTypeRepository objectTypeRepository;

    public GetAllObjectTypesService(ObjectTypeRepository objectTypeRepository) {
        this.objectTypeRepository = objectTypeRepository;
    }

    public List<ObjectTypeDto> getAllObjectTypes() {
        return this.objectTypeRepository.getAllObjectTypes();
    }
}
