package com.grade.project.infrastructure.controllers.feature;

import com.grade.project.application.handler.feature.DeleteFeatureHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/feature")
public class DeleteFeatureController {

    private final DeleteFeatureHandler deleteFeatureHandler;

    @DeleteMapping("/{id}")
    public void deleteFeature(@PathVariable String id) {
        this.deleteFeatureHandler.deleteFeatureHandler(id);
    }
}
