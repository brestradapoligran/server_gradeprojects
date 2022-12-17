package com.grade.project.infrastructure.controllers.object;

import com.grade.project.domain.enums.ObjectTypeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/object")
public class GetAllObjectFiltersController {

    @GetMapping("/filters")
    private ObjectTypeEnum[] getFilters() {
        return ObjectTypeEnum.values();
    }
}
