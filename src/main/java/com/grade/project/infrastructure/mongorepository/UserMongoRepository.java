package com.grade.project.infrastructure.mongorepository;

import com.grade.project.infrastructure.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<UserDocument, String> {

    Optional<UserDocument> findByEmailAndPass(String email, String pass);
}
