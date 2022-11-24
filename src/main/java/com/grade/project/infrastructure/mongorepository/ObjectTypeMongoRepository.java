package com.grade.project.infrastructure.mongorepository;

import com.grade.project.infrastructure.document.ObjectTypeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ObjectTypeMongoRepository extends MongoRepository<ObjectTypeDocument, String> {
}
