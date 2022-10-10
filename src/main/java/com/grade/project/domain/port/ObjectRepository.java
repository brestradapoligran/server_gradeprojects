package com.grade.project.domain.port;

import com.grade.project.domain.dto.ObjectDto;
import com.grade.project.domain.model.ObjectModel;

public interface ObjectRepository {

    ObjectDto createObject(ObjectModel objectModel);

    void deleteObject(String id);
}
