package com.grade.project.application.handler.feature;


import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.services.feature.GetFeatureService;
import org.springframework.stereotype.Component;

@Component
public class GetFeatureHandler {

    private final GetFeatureService getFeatureService;

    public GetFeatureHandler(GetFeatureService getFeatureService) {
        this.getFeatureService = getFeatureService;
    }

    public FeatureDto getFeatures(String id) {
        return this.getFeatureService.getFeature(id);
    }
}
