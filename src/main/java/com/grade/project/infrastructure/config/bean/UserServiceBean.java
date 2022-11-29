package com.grade.project.infrastructure.config.bean;

import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceBean {

    @Bean
    public CreateUserService createUserService(UserRepository userRepository) {
        return new CreateUserService(userRepository);
    }

    @Bean
    public UpdateUserService updateUserService(UserRepository userRepository) {
        return new UpdateUserService(userRepository);
    }

    @Bean
    public GetUserService getUserService(UserRepository userRepository) {
        return new GetUserService(userRepository);
    }

    @Bean
    public GetUsersService getUsersService(UserRepository userRepository) {
        return new GetUsersService(userRepository);
    }

    @Bean
    public LoginService loginService(UserRepository userRepository) {
        return new LoginService(userRepository);
    }
}
