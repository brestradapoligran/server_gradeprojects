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

    List<ObjectDocument> findByNameIgnoreCaseAndTypeIgnoreCaseInAndStatusIgnoreCaseInOrderByIdDesc(String name, List<ObjectTypeEnum> type, List<ObjectStatusEnum> status);
    List<ObjectDocument> findByTypeIgnoreCaseInAndStatusIgnoreCaseInOrderByIdDesc(List<ObjectTypeEnum> type, List<ObjectStatusEnum> status);
    List<ObjectDocument> findByNameIgnoreCaseAndStatusIgnoreCaseInOrderByIdDesc(String name, List<ObjectStatusEnum> status);
    List<ObjectDocument> findByNameIgnoreCaseAndTypeIgnoreCaseInOrderByIdDesc(String name, List<ObjectTypeEnum> type);

    List<ObjectDocument> findByNameIgnoreCaseOrTypeIgnoreCaseInOrStatusIgnoreCaseInOrderByIdDesc(String name, List<ObjectTypeEnum> type, List<ObjectStatusEnum> status);

    List<ObjectDocument> findAllByOrderByIdDesc();
}
