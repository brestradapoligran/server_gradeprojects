package com.grade.project.domain.services.object;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.port.ObjectRepository;

import java.util.List;

public class GetAllObjectsService {

    private final ObjectRepository objectRepository;

    public GetAllObjectsService(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public List<ObjectDto> getObjects() {
        return this.objectRepository.getObjects();
    }
}
