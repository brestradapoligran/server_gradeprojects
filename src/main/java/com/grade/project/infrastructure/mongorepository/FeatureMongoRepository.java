package com.grade.project.infrastructure.mongorepository;

import com.grade.project.infrastructure.document.FeatureDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeatureMongoRepository extends MongoRepository<FeatureDocument, String> {
}
