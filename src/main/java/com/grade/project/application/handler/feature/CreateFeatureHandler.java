package com.grade.project.application.handler.feature;

import com.grade.project.application.command.FeatureCommand;
import com.grade.project.application.factory.FeatureFactory;
import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.services.feature.CreateFeatureService;
import org.springframework.stereotype.Component;

@Component
public class CreateFeatureHandler {

    private final CreateFeatureService createFeatureService;

    public CreateFeatureHandler(CreateFeatureService createFeatureService) {
        this.createFeatureService = createFeatureService;
    }

    public FeatureDto createFeature(FeatureCommand featureCommand) {
        return this.createFeatureService.createFeature(FeatureFactory.convertToModel(featureCommand));
    }
}
