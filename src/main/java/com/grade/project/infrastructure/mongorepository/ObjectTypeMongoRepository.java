package com.grade.project.infrastructure.mongorepository;

import com.grade.project.infrastructure.document.ObjectTypeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectTypeMongoRepository extends MongoRepository<ObjectTypeDocument, String> {
}
