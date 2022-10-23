package com.grade.project.domain.services.object;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.model.ObjectModel;
import com.grade.project.domain.port.ObjectRepository;

public class UpdateObjectService {

    private final ObjectRepository objectRepository;

    public UpdateObjectService(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public ObjectDto updateObject(ObjectModel objectModel) {
        return this.objectRepository.updateObject(objectModel);
    }
}
