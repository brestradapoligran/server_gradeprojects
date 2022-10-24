package com.grade.project.infrastructure.adapter;

import com.grade.project.domain.dto.UserDto;
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
    public String disableUser(String id) {
        return null;
    }

    private UserDto saveUser(UserModel userModel) {
        UserDocument userDocument = this.mapper.map(userModel, UserDocument.class);
        UserDocument userSaved = this.userMongoRepository.save(userDocument);
        return this.mapper.map(userSaved, UserDto.class);
    }

    private UserDto getUserById(String id) {
        Optional<UserDocument> userFound = this.userMongoRepository.findById(id);
        if(userFound.isPresent()) {
            return this.mapper.map(userFound.get(), UserDto.class);
        } else {
            throw new RuntimeException("");
        }
    }
}
