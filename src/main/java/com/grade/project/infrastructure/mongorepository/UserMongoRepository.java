package com.grade.project.infrastructure.mongorepository;

import com.grade.project.infrastructure.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserDocument, String> {
}
