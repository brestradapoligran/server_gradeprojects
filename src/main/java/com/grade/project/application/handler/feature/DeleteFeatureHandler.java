package com.grade.project.application.handler.feature;

import com.grade.project.domain.services.feature.DeleteFeatureService;
import org.springframework.stereotype.Component;

@Component
public class DeleteFeatureHandler {

    private final DeleteFeatureService deleteFeatureService;

    public DeleteFeatureHandler(DeleteFeatureService deleteFeatureService) {
        this.deleteFeatureService = deleteFeatureService;
    }

    public void deleteFeatureHandler(String id) {
        this.deleteFeatureService.deleteFeature(id);
    }
}
