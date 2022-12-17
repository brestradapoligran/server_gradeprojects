package com.grade.project.infrastructure.controllers.object;

import com.grade.project.application.command.FiltersObjectCommand;
import com.grade.project.application.handler.object.SearchObjectHandler;
import com.grade.project.domain.dto.ObjectDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/object")
public class SearchObjectController {

    private final SearchObjectHandler searchObjectHandler;

    public SearchObjectController(SearchObjectHandler searchObjectHandler) {
        this.searchObjectHandler = searchObjectHandler;
    }

    @PostMapping("/search")
    public Set<ObjectDto> searchObject(@RequestBody FiltersObjectCommand filters) {
        return this.searchObjectHandler.searchObject(filters);
    }
}
