package com.grade.project.infrastructure.adapter;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.UserModel;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.infrastructure.document.UserDocument;
import com.grade.project.infrastructure.mongorepository.UserMongoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserMongoRepository userMongoRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public UserDto createUser(UserModel userModel) {
        UserDocument userDocument = this.mapper.map(userModel, UserDocument.class);
        userDocument.setId(null);
        UserDocument userSaved = this.userMongoRepository.save(userDocument);
        return this.mapper.map(userSaved, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserModel userModel) {
        return null;
    }

    @Override
    public UserDto getUser(String id) {
        return null;
    }

    @Override
    public UserDto getUsers() {
        return null;
    }

    @Override
    public String disableUser(String id) {
        return null;
    }
}
