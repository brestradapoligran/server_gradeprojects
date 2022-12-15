package com.grade.project.domain.services.object;

import com.grade.project.application.command.FiltersObjectCommand;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.port.ObjectRepository;

import java.util.List;
import java.util.Set;

public class SearchObjectService {

    private ObjectRepository objectRepository;

    public SearchObjectService(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public Set<ObjectDto> searchObject(FiltersObjectCommand filters) {
        return this.objectRepository.searchObject(filters);
    }
}
