package com.grade.project.domain.services.feature;

import com.grade.project.domain.port.FeatureRepository;

public class DeleteFeatureService {

    private final FeatureRepository featureRepository;

    public DeleteFeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public void deleteFeature(String id) {
        this.featureRepository.deleteFeature(id);
    }
}
