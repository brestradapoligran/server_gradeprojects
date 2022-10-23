package com.grade.project.infrastructure.adapter;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.ObjectModel;
import com.grade.project.domain.model.UserModel;
import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.infrastructure.document.ObjectDocument;
import com.grade.project.infrastructure.mongorepository.ObjectMongoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObjectRepositoryImpl implements ObjectRepository {

    private final ObjectMongoRepository objectMongoRepository;
    private final ModelMapper mapper = new ModelMapper();

    public ObjectRepositoryImpl(ObjectMongoRepository objectMongoRepository) {
        this.objectMongoRepository = objectMongoRepository;
    }

    @Override
    public ObjectDto createObject(ObjectModel objectModel) {
        objectModel.setId(null);
        return this.saveObject(objectModel);
    }

    @Override
    public ObjectDto updateObject(ObjectModel objectModel) {
        
        return this.saveObject(objectModel);
    }

    @Override
    public List<ObjectDto> getObjects() {
        return null;
    }

    @Override
    public ObjectDto getObject(String id) {
        return null;
    }

    @Override
    public void deleteObject(String id) {
        this.objectMongoRepository.deleteById(id);
    }

    private ObjectDto saveObject(ObjectModel objectModel) {
        ObjectDocument objectDocument = this.mapper.map(objectModel, ObjectDocument.class);
        ObjectDocument objectDocumentSaved = this.objectMongoRepository.save(objectDocument);
        return this.mapper.map(objectDocumentSaved, ObjectDto.class);
    }
}
