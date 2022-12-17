package com.grade.project.application.handler.object;

import com.grade.project.application.command.FiltersObjectCommand;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.services.object.SearchObjectService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class SearchObjectHandler {

    private SearchObjectService searchObjectService;

    public SearchObjectHandler(SearchObjectService searchObjectService) {
        this.searchObjectService = searchObjectService;
    }

    public Set<ObjectDto> searchObject(FiltersObjectCommand filters) {
        return this.searchObjectService.searchObject(filters);
    }
}
