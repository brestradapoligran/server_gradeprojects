package com.grade.project.domain.services.object;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.port.ObjectRepository;

import java.util.List;

public class SearchObjectService {

    private ObjectRepository objectRepository;

    public SearchObjectService(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public List<ObjectDto> searchObject(String word) {
        return this.objectRepository.searchObject(word);
    }
}
