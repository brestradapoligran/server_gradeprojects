package com.grade.project.infrastructure.adapter;

import com.grade.project.domain.dto.ObjectTypeDto;
import com.grade.project.domain.model.ObjectTypeModel;
import com.grade.project.domain.port.ObjectTypeRepository;
import com.grade.project.infrastructure.document.ObjectTypeDocument;
import com.grade.project.infrastructure.mongorepository.ObjectTypeMongoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ObjectTypeRepositoryImpl implements ObjectTypeRepository {

    private final ObjectTypeMongoRepository objectTypeMongoRepository;
    private final ModelMapper mapper = new ModelMapper();

    public ObjectTypeRepositoryImpl(ObjectTypeMongoRepository objectTypeMongoRepository) {
        this.objectTypeMongoRepository = objectTypeMongoRepository;
    }

    @Override
    public ObjectTypeDto createObjectType(ObjectTypeModel objectTypeModel) {
        ObjectTypeDocument objectTypeDocument = this.mapper.map(objectTypeModel, ObjectTypeDocument.class);
        ObjectTypeDocument objectTypeDocumentSaved = this.objectTypeMongoRepository.save(objectTypeDocument);
        return this.mapper.map(objectTypeDocumentSaved, ObjectTypeDto.class);
    }

    @Override
    public List<ObjectTypeDto> getAllObjectTypes() {
        List<ObjectTypeDocument> objectTypeDtos = this.objectTypeMongoRepository.findAll();
        return objectTypeDtos.stream().map(objectType -> this.mapper.map(objectType, ObjectTypeDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteObjectTypeById(String id) {
        this.objectTypeMongoRepository.deleteById(id);
    }
}
