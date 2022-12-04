package com.grade.project.infrastructure.adapter;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.exceptions.BadDataException;
import com.grade.project.domain.model.LoginRequestModel;
import com.grade.project.domain.model.UserModel;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.infrastructure.document.UserDocument;
import com.grade.project.infrastructure.mongorepository.UserMongoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserMongoRepository userMongoRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public UserDto createUser(UserModel userModel) {
        userModel.setId(null);
        return this.saveUser(userModel);
    }

    @Override
    public UserDto updateUser(UserModel userModel) {
        this.getUserById(userModel.getId());
        return this.saveUser(userModel);
    }

    @Override
    public UserDto getUser(String id) {
        return this.getUserById(id);
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDocument> userDocuments = this.userMongoRepository.findAll();
        return userDocuments.stream().map(user -> this.mapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto login(LoginRequestModel loginRequestModel) {
        Optional<UserDocument> userDocumentFound = this.userMongoRepository.findByEmailAndPass(loginRequestModel.getEmail(), loginRequestModel.getPass());
        return this.validate(userDocumentFound);
    }

    @Override
    public UserDto changeStatus(String id) {
        Optional<UserDocument> userDocument = this.userMongoRepository.findById(id);
        this.validateUserDocument(userDocument);
        userDocument.get().setStatus(!userDocument.get().getStatus());
        return this.mapper.map(this.userMongoRepository.save(userDocument.get()), UserDto.class);

    }

    private UserDto saveUser(UserModel userModel) {
        UserDocument userDocument = this.mapper.map(userModel, UserDocument.class);
        UserDocument userSaved = this.userMongoRepository.save(userDocument);
        return this.mapper.map(userSaved, UserDto.class);
    }

    private UserDto getUserById(String id) {
        Optional<UserDocument> userFound = this.userMongoRepository.findById(id);
        return this.validate(userFound);
    }

    private Optional<UserDocument> getUserDocumentById(String id) {
        return this.userMongoRepository.findById(id);
    }

    private UserDto validate(Optional<UserDocument> userFound) {
        return this.mapper.map(this.validateUserDocument(userFound), UserDto.class);
    }

    private UserDocument validateUserDocument(Optional<UserDocument> userFound) {
        if(userFound.isPresent()) {
            return userFound.get();
        } else {
            throw new BadDataException("Error: User not found");
        }
    }
}
