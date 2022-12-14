package com.grade.project.infrastructure.adapter;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.ObjectModel;
import com.grade.project.domain.model.UserModel;
import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.infrastructure.document.ObjectDocument;
import com.grade.project.infrastructure.document.UserDocument;
import com.grade.project.infrastructure.mongorepository.ObjectMongoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        this.getObjectById(objectModel.getId());
        return this.saveObject(objectModel);
    }

    @Override
    public List<ObjectDto> getObjects() {
        List<ObjectDocument> objectDocuments = this.objectMongoRepository.findAll();
        return objectDocuments.stream().map(object -> this.mapper.map(object, ObjectDto.class)).collect(Collectors.toList());
    }

    @Override
    public ObjectDto getObject(String id) {
        return this.mapper.map(this.getObjectById(id), ObjectDto.class);
    }

    @Override
    public void deleteObject(String id) {
        this.objectMongoRepository.deleteById(id);
    }

    @Override
    public List<ObjectDto> searchObject(String word) {
        List<ObjectDocument> objectDocuments = this.objectMongoRepository.findByNameIgnoreCase(word);
        return objectDocuments.stream().map(object -> this.mapper.map(object, ObjectDto.class)).collect(Collectors.toList());
    }

    private ObjectDto saveObject(ObjectModel objectModel) {
        ObjectDocument objectDocument = this.mapper.map(objectModel, ObjectDocument.class);
        ObjectDocument objectDocumentSaved = this.objectMongoRepository.save(objectDocument);
        return this.mapper.map(objectDocumentSaved, ObjectDto.class);
    }

    private ObjectDocument getObjectById(String id) {
        Optional<ObjectDocument> objectFound = this.objectMongoRepository.findById(id);
        if(objectFound.isPresent()) {
            return objectFound.get();
        } else {
            throw new RuntimeException("");
        }
    }
}
