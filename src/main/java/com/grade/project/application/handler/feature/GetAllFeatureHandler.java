package com.grade.project.application.handler.feature;

import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.services.feature.GetAllFeatureService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllFeatureHandler {

    private final GetAllFeatureService getAllFeatureService;

    public GetAllFeatureHandler(GetAllFeatureService getAllFeatureService) {
        this.getAllFeatureService = getAllFeatureService;
    }

    public List<FeatureDto> getAllFeatures() {
        return this.getAllFeatureService.getAllFeatures();
    }
}
