package com.grade.project.domain.port;

import com.grade.project.domain.dto.ObjectTypeDto;
import com.grade.project.domain.model.ObjectTypeModel;

import java.util.List;

public interface ObjectTypeRepository {

    ObjectTypeDto createObjectType(ObjectTypeModel objectTypeModel);

    List<ObjectTypeDto> getAllObjectTypes();

    void deleteObjectTypeById(String id);
}
