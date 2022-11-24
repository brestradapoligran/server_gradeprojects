package com.grade.project.infrastructure.config.bean;

import com.grade.project.domain.port.FeatureRepository;
import com.grade.project.domain.services.feature.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeatureBean {

    @Bean
    public CreateFeatureService createFeatureService(FeatureRepository featureRepository) {
        return new CreateFeatureService(featureRepository);
    }

    @Bean
    public DeleteFeatureService deleteFeatureService(FeatureRepository featureRepository) {
        return new DeleteFeatureService(featureRepository);
    }

    @Bean
    public GetAllFeatureService getAllFeatureService(FeatureRepository featureRepository) {
        return new GetAllFeatureService(featureRepository);
    }

    @Bean
    public GetFeatureService getFeatureService(FeatureRepository featureRepository) {
        return new GetFeatureService(featureRepository);
    }

    @Bean
    public UpdateFeatureService updateFeatureService(FeatureRepository featureRepository) {
        return new UpdateFeatureService(featureRepository);
    }
}
