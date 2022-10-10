package com.grade.project.domain.services.objects;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.model.ObjectModel;
import com.grade.project.domain.port.ObjectRepository;

public class CreateObjectService {

    private ObjectRepository objectRepository;

    public CreateObjectService(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public ObjectDto run(ObjectModel objectModel) {
        return this.objectRepository.createObject(objectModel);
    }
}
