package com.grade.project.infrastructure.controllers.feature;

import com.grade.project.application.handler.feature.GetFeatureHandler;
import com.grade.project.domain.dto.FeatureDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/feature")
public class GetFeatureController {

    private final GetFeatureHandler getFeatureHandler;

    @GetMapping("/{id}")
    public FeatureDto getFeature(@PathVariable String id) {
        return this.getFeatureHandler.getFeatures(id);
    }
}
