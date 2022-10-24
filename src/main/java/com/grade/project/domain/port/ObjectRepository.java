package com.grade.project.domain.port;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.model.ObjectModel;

import java.util.List;

public interface ObjectRepository {

    ObjectDto createObject(ObjectModel objectModel);

    ObjectDto updateObject(ObjectModel objectModel);
    List<ObjectDto> getObjects();
    ObjectDto getObject(String id);

    void deleteObject(String id);
}
