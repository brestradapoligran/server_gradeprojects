package com.grade.project.infrastructure.controllers.object;

import com.grade.project.application.handler.object.SearchObjectHandler;
import com.grade.project.domain.dto.ObjectDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/object")
public class SearchObjectController {

    private SearchObjectHandler searchObjectHandler;

    public SearchObjectController(SearchObjectHandler searchObjectHandler) {
        this.searchObjectHandler = searchObjectHandler;
    }

    @GetMapping("/search")
    public List<ObjectDto> searchObject(@RequestParam String word) {
        return this.searchObjectHandler.searchObject(word);
    }
}
