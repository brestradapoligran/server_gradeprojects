package com.grade.project.infrastructure.config.bean;

import com.grade.project.domain.port.UserRepository;
import com.grade.project.domain.services.user.CreateUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceBean {

    @Bean
    public CreateUserService createUserService(UserRepository userRepository) {
        return new CreateUserService(userRepository);
    }
}
