package com.grade.project.infrastructure.mongorepository;

import com.grade.project.domain.enums.object.ObjectStatusEnum;
import com.grade.project.domain.enums.object.ObjectTypeEnum;
import com.grade.project.infrastructure.document.ObjectDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ObjectMongoRepository extends MongoRepository<ObjectDocument, String> {

    List<ObjectDocument> findByNameIgnoreCase();

    List<ObjectDocument> findByTypeIgnoreCaseIn(List<ObjectTypeEnum> type);

    ObjectDocument save(ObjectDocument objectDocument);

    List<ObjectDocument> findByNameIgnoreCaseOrTypeIgnoreCaseInOrStatusIgnoreCaseIn(String name, List<ObjectTypeEnum> type, List<ObjectStatusEnum> status);
}
