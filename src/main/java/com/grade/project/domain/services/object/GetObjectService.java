package com.grade.project.domain.services.object;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.port.ObjectRepository;

public class GetObjectService {

    private final ObjectRepository objectRepository;

    public GetObjectService(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public ObjectDto getObject(String id) {
        return this.objectRepository.getObject(id);
    }
}
