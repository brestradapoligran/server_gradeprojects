package com.grade.project.infrastructure.adapter;

import com.grade.project.application.command.FiltersObjectCommand;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.model.ObjectModel;
import com.grade.project.domain.port.ObjectRepository;
import com.grade.project.infrastructure.document.ClaimerDocument;
import com.grade.project.infrastructure.document.ObjectDocument;
import com.grade.project.infrastructure.mongorepository.ObjectMongoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.*;
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
    public Set<ObjectDto> searchObject(FiltersObjectCommand filters) {
        List<ObjectDocument> objectDocuments;
        if(filters.getObjectTypes().isEmpty() && filters.getSearchWord().isEmpty() && filters.getObjectStatuses().isEmpty()) {
            objectDocuments = this.objectMongoRepository.findAll();
        } else {
            objectDocuments = new ArrayList<>(this.objectMongoRepository.findByNameIgnoreCaseOrTypeIgnoreCaseInOrStatusIgnoreCaseIn(filters.getSearchWord(), filters.getObjectTypes(), filters.getObjectStatuses()));
        }
        return objectDocuments.stream().map(object -> this.mapper.map(object, ObjectDto.class)).collect(Collectors.toSet());
    }


    private ObjectDto saveObject(ObjectModel objectModel) {
        ObjectDocument objectDocument = this.mapper.map(objectModel, ObjectDocument.class);
        this.validateStatus(objectDocument);
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

    private void validateStatus(ObjectDocument objectDocument) {
        if(objectDocument.getStatus().equals(ObjectStatusEnum.PERDIDO)) {
            objectDocument.setClaimer(new ClaimerDocument());
        }
    }
}
