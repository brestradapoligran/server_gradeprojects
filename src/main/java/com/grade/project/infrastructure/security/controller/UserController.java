package com.grade.project.infrastructure.security.controller;

import com.grade.project.application.command.LoginRequestCommand;
import com.grade.project.application.handler.user.LoginHandler;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.LoginRequestModel;
import com.grade.project.infrastructure.security.payload.response.JwtResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final LoginHandler loginHandler;

    public UserController(LoginHandler loginHandler) {
        this.loginHandler = loginHandler;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequestCommand loginRequestCommand) {
        UserDto userFound = this.loginHandler.login(loginRequestCommand);
        String token = getJwtToken(userFound.getEmail());
        return new JwtResponse(token);
    }

    private String getJwtToken(String email) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");

        String token = Jwts.builder()
                .setId("gradeproject")
                .setSubject(email)
                .claim("authorities", grantedAuthorities
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
        return "Bearer " + token;
    }
}
