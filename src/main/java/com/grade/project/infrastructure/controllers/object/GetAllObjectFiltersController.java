package com.grade.project.infrastructure.controllers.object;

import com.grade.project.domain.dto.FiltersDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/object")
public class GetAllObjectFiltersController {

    @GetMapping("/filters")
    private FiltersDto getFilters() {
        return new FiltersDto();
    }
}
