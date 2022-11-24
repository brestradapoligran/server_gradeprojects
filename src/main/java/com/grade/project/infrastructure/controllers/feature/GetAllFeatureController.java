package com.grade.project.infrastructure.controllers.feature;

import com.grade.project.application.handler.feature.GetAllFeatureHandler;
import com.grade.project.domain.dto.FeatureDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/features")
public class GetAllFeatureController {

    private final GetAllFeatureHandler getAllFeatureHandler;

    @GetMapping
    public List<FeatureDto> getAllFeatures() {
        return this.getAllFeatureHandler.getAllFeatures();
    }
}
