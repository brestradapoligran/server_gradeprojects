package com.grade.project.domain.port;

import com.grade.project.application.command.FiltersObjectCommand;
import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.model.ObjectModel;

import java.util.List;
import java.util.Set;

public interface ObjectRepository {

    ObjectDto createObject(ObjectModel objectModel);

    ObjectDto updateObject(ObjectModel objectModel);
    List<ObjectDto> getObjects();
    ObjectDto getObject(String id);

    void deleteObject(String id);

    Set<ObjectDto> searchObject(FiltersObjectCommand filters);
}
