package com.grade.project.infrastructure.config.bean;

import com.grade.project.domain.port.ObjectTypeRepository;
import com.grade.project.domain.services.objecttype.CreateObjectTypeService;
import com.grade.project.domain.services.objecttype.DeleteObjectTypeByIdService;
import com.grade.project.domain.services.objecttype.GetAllObjectTypesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectTypeBean {

    @Bean
    public CreateObjectTypeService createObjectService(ObjectTypeRepository objectTypeRepository) {
        return new CreateObjectTypeService(objectTypeRepository);
    }

    @Bean
    public GetAllObjectTypesService getAllObjectTypesService(ObjectTypeRepository objectTypeRepository) {
        return new GetAllObjectTypesService(objectTypeRepository);
    }

    @Bean
    public DeleteObjectTypeByIdService deleteObjectTypeByIdService(ObjectTypeRepository objectTypeRepository) {
        return new DeleteObjectTypeByIdService(objectTypeRepository);
    }
}
