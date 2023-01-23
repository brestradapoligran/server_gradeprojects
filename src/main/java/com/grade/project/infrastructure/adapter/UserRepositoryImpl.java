package com.grade.project.infrastructure.adapter;

import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.enums.user.UserStatusEnum;
import com.grade.project.domain.exceptions.BadDataException;
import com.grade.project.domain.model.LoginRequestModel;
import com.grade.project.domain.model.ResetPasswordModel;
import com.grade.project.domain.model.UserModel;
import com.grade.project.domain.port.UserRepository;
import com.grade.project.infrastructure.config.email.EmailDetails;
import com.grade.project.infrastructure.config.email.EmailService;
import com.grade.project.infrastructure.document.UserDocument;
import com.grade.project.infrastructure.mongorepository.UserMongoRepository;
import com.grade.project.infrastructure.util.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserMongoRepository userMongoRepository;

    private final ModelMapper mapper = new ModelMapper();

    private final EmailService emailService;

    private final JwtUtils jwtUtils;

    @Override
    public UserDto createUser(UserModel userModel) {
        userModel.setId(null);
        return this.saveUser(userModel);
    }

    @Override
    public UserDto updateUser(UserModel userModel) {
        Optional<UserDocument> userDocument = this.getOptionalUserById(userModel.getId());
        this.validate(userDocument);
        userModel.setPass(userDocument.get().getPass());
        return this.saveUser(userModel);
    }

    @Override
    public UserDto getUser(String id) {
        return this.getUserById(id);
    }

    @Override
    public UserDto getMyUser(String email) {
        Optional<UserDocument> userDocumentOptional = this.getUserByEmail(email);
        if(!userDocumentOptional.isPresent()) {
            throw new BadDataException("Error: User does not exist");
        }
        UserDocument userDocument = this.mapper.map(userDocumentOptional.get(), UserDocument.class);
        return this.mapper.map(userDocument, UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDocument> userDocuments = this.userMongoRepository.findAll();
        return userDocuments.stream().map(user -> this.mapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto login(LoginRequestModel loginRequestModel) {
        Optional<UserDocument> userDocumentFound = this.userMongoRepository.findByEmailAndPass(loginRequestModel.getEmail(), loginRequestModel.getPass());
        this.validateUserDocument(userDocumentFound);
        this.validateIfUserIsInactive(userDocumentFound.get());
        return this.validate(userDocumentFound);
    }

    @Override
    public UserDto changeStatus(String id) {
        Optional<UserDocument> userDocument = this.userMongoRepository.findById(id);
        this.validateUserDocument(userDocument);
        userDocument.get().setStatus(userDocument.get().getStatus().equals(UserStatusEnum.Activo) ? UserStatusEnum.Inactivo: UserStatusEnum.Activo);
        return this.mapper.map(this.userMongoRepository.save(userDocument.get()), UserDto.class);

    }

    @Override
    public void sendEmailForgotPassword(String email) {
        Optional<UserDocument> user = this.getUserByEmail(email);
        this.validateUserDocument(user);
        String token = jwtUtils.removeBearer(jwtUtils.getJwtToken(email, user.get().getRole()));
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(email);
        emailDetails.setSubject("Recuperación Contraseña");
        emailDetails.setMsgBody("Si desea actualizar su contraseña, ingrese aquí http://localhost:4200/session/resetpassword/" + token);
        this.emailService.sendSimpleMail(emailDetails);
    }

    @Override
    public void resetPassword(String email, String pass) {
        Optional<UserDocument> userDocumentFound = this.userMongoRepository.findByEmail(email);
        UserDocument userDocument = validateUserDocument(userDocumentFound);
        userDocument.setPass(pass);
        this.userMongoRepository.save(userDocument);
    }

    @Override
    public void updatePassword(ResetPasswordModel resetPasswordModel) {
        Optional<UserDocument> userDocumentFound = this.userMongoRepository.findByEmail(resetPasswordModel.getEmail());
        UserDocument userDocument = validateUserDocument(userDocumentFound);
        if(userDocument.getPass().equals(resetPasswordModel.getOldPass())) {
            userDocument.setPass(resetPasswordModel.getPass());
        }else {
            throw new BadDataException("Error: Contraseña antigua es incorrecta");
        }
        this.userMongoRepository.save(userDocument);
    }

    @Override
    public UserDto updateMyUser(String email, UserModel userModel) {
        Optional<UserDocument> userDocument = this.getOptionalUserByEmail(email);
        UserDocument userFound = this.validateUserDocument(userDocument);
        userModel.setId(userFound.getId());
        userModel.setPass(userFound.getPass());
        return this.saveUser(userModel);
    }

    @Override
    public void deleteUser(String id) {
        this.userMongoRepository.deleteById(id);
    }

    private UserDto saveUser(UserModel userModel) {
        Optional<UserDocument> userDocumentFound = this.getUserByEmail(userModel.getEmail());
        if(userDocumentFound.isPresent() && userModel.getId() == null) {
            throw new BadDataException("Error: User with email "+ userModel.getEmail() + " already exists");
        }
        UserDocument userDocument = this.mapper.map(userModel, UserDocument.class);
        UserDocument userSaved = this.userMongoRepository.save(userDocument);
        this.sendEmailWhenCreateUser(userSaved.getEmail());
        return this.mapper.map(userSaved, UserDto.class);
    }

    private UserDto getUserById(String id) {
        Optional<UserDocument> userFound = this.userMongoRepository.findById(id);
        return this.validate(userFound);
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

    private void sendEmailWhenCreateUser(String email) {
        Optional<UserDocument> userDocument = this.getOptionalUserByEmail(email);
        this.validateUserDocument(userDocument);
        String token = jwtUtils.removeBearer(jwtUtils.getJwtToken(email, userDocument.get().getRole()));
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(email);
        emailDetails.setSubject("Usuario Creado");
        emailDetails.setMsgBody("Se creó un usuario, con el nombre de usuario: " + email +
                ", tiene 1 hora para acceder al siguiente link y actualizar su contraseña: http://localhost:4200/session/resetpassword/" + token);
        this.emailService.sendSimpleMail(emailDetails);
    }

    private void validateIfUserIsInactive(UserDocument user) {
        if(user.getStatus() == UserStatusEnum.Inactivo ) {
            throw new BadDataException("Error: usuario y/o contraseña invalidos");
        }
    }

    private Optional<UserDocument> getUserByEmail(String email) {
        return this.userMongoRepository.findByEmail(email);
    }

    private Optional<UserDocument> getOptionalUserById(String id) {
        return this.userMongoRepository.findById(id);
    }
    private Optional<UserDocument> getOptionalUserByEmail(String email) {
        return this.userMongoRepository.findByEmail(email);
    }
}
