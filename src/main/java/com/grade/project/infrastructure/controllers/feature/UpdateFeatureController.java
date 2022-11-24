package com.grade.project.infrastructure.controllers.feature;

import com.grade.project.application.command.FeatureCommand;
import com.grade.project.application.handler.feature.UpdateFeatureHandler;
import com.grade.project.domain.dto.FeatureDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/feature")
public class UpdateFeatureController {

    private final UpdateFeatureHandler updateFeatureHandler;

    @PutMapping("/{id}")
    public FeatureDto updateFeature(@PathVariable String id, @RequestBody FeatureCommand featureCommand) {
        return this.updateFeatureHandler.updateFeature(id, featureCommand);
    }
}
