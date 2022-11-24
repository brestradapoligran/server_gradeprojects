package com.grade.project.domain.services.feature;

import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.model.FeatureModel;
import com.grade.project.domain.port.FeatureRepository;

public class UpdateFeatureService {

    private final FeatureRepository featureRepository;

    public UpdateFeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public FeatureDto updateFeature(FeatureModel featureModel) {
        return this.featureRepository.updateFeature(featureModel);
    }
}
