package com.grade.project.infrastructure.mongorepository;

import com.grade.project.infrastructure.document.ObjectDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ObjectMongoRepository extends MongoRepository<ObjectDocument, String> {
}
