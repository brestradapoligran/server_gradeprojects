package com.grade.project.domain.services.feature;

import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.port.FeatureRepository;

public class GetFeatureService {

    private final FeatureRepository featureRepository;

    public GetFeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public FeatureDto getFeature(String id) {
        return this.featureRepository.getFeature(id);
    }
}
