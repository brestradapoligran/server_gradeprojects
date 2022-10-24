package com.grade.project.application.handler.feature;

import com.grade.project.application.command.FeatureCommand;
import com.grade.project.application.factory.FeatureFactory;
import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.services.feature.UpdateFeatureService;
import org.springframework.stereotype.Component;

@Component
public class UpdateFeatureHandler {

    private final UpdateFeatureService updateFeatureService;

    public UpdateFeatureHandler(UpdateFeatureService updateFeatureService) {
        this.updateFeatureService = updateFeatureService;
    }

    public FeatureDto updateFeature(String id, FeatureCommand featureCommand) {
        return this.updateFeatureService.updateFeature(FeatureFactory.convertToModel(id, featureCommand));
    }
}
