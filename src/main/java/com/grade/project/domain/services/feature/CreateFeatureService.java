package com.grade.project.domain.services.feature;

import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.model.FeatureModel;
import com.grade.project.domain.port.FeatureRepository;

public class CreateFeatureService {

    private final FeatureRepository featureRepository;

    public CreateFeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public FeatureDto createFeature(FeatureModel featureModel) {
        return this.featureRepository.createFeature(featureModel);
    }
}
