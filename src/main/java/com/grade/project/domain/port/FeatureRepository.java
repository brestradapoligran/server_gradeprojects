package com.grade.project.domain.port;

import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.model.FeatureModel;

import java.util.List;

public interface FeatureRepository {

    FeatureDto createFeature(FeatureModel featureModel);

    FeatureDto updateFeature(FeatureModel featureModel);

    void deleteFeature(String id);

    FeatureDto getFeature(String id);

    List<FeatureDto> getAllFeatures();
}
