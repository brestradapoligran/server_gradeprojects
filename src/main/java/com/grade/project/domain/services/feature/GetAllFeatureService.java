package com.grade.project.domain.services.feature;

import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.port.FeatureRepository;

import java.util.List;

public class GetAllFeatureService {

    private final FeatureRepository featureRepository;

    public GetAllFeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public List<FeatureDto> getAllFeatures() {
        return this.featureRepository.getAllFeatures();
    }
}
