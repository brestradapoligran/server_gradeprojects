package com.grade.project.infrastructure.mongorepository;

import com.grade.project.infrastructure.document.ObjectDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ObjectMongoRepository extends MongoRepository<ObjectDocument, String> {

    List<ObjectDocument> findByNameIgnoreCase(String name);
}
