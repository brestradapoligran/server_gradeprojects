package com.grade.project.infrastructure.adapter;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.model.ObjectModel;
import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.infrastructure.document.ObjectDocument;
import com.grade.project.infrastructure.mongorepository.ObjectMongoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ObjectRepositoryImpl implements ObjectRepository {

    private final ObjectMongoRepository objectMongoRepository;
    private final ModelMapper mapper = new ModelMapper();

    public ObjectRepositoryImpl(ObjectMongoRepository objectMongoRepository) {
        this.objectMongoRepository = objectMongoRepository;
    }

    @Override
    public ObjectDto createObject(ObjectModel objectModel) {
        ObjectDocument objectDocument = this.mapper.map(objectModel, ObjectDocument.class);
        ObjectDocument objectDocumentSaved = this.objectMongoRepository.save(objectDocument);
        return this.mapper.map(objectDocumentSaved, ObjectDto.class);
    }

    @Override
    public void deleteObject(String id) {
        this.objectMongoRepository.deleteById(id);
    }
}
