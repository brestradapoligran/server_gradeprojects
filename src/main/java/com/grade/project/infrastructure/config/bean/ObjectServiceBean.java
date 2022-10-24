package com.grade.project.infrastructure.config.bean;

import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.domain.services.object.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectServiceBean {

    @Bean
    public CreateObjectService objectCreateService(ObjectRepository objectRepository) {
        return new CreateObjectService(objectRepository);
    }

    @Bean
    public DeleteObjectService deleteObjectService(ObjectRepository objectRepository) {
        return new DeleteObjectService(objectRepository);
    }

    @Bean
    public GetAllObjectsService getObjectsService(ObjectRepository objectRepository) {
        return new GetAllObjectsService(objectRepository);
    }

    @Bean
    public GetObjectService getObjectService(ObjectRepository objectRepository) {
        return new GetObjectService(objectRepository);
    }

    @Bean
    public UpdateObjectService updateObjectService(ObjectRepository objectRepository) {
        return new UpdateObjectService(objectRepository);
    }
}
