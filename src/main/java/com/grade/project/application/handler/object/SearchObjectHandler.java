package com.grade.project.application.handler.object;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.services.object.SearchObjectService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchObjectHandler {

    private SearchObjectService searchObjectService;

    public SearchObjectHandler(SearchObjectService searchObjectService) {
        this.searchObjectService = searchObjectService;
    }

    public List<ObjectDto> searchObject(String word) {
        return this.searchObjectService.searchObject(word);
    }
}
