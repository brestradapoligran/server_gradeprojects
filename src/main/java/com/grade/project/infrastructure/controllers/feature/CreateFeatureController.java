package com.grade.project.infrastructure.controllers.feature;

import com.grade.project.application.command.FeatureCommand;
import com.grade.project.application.handler.feature.CreateFeatureHandler;
import com.grade.project.domain.dto.FeatureDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/feature")
public class CreateFeatureController {

    private final CreateFeatureHandler createFeatureHandler;

    @PostMapping
    public FeatureDto createFeature(@RequestBody FeatureCommand featureCommand) {
        return this.createFeatureHandler.createFeature(featureCommand);
    }
}
