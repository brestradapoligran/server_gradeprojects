package com.grade.project.infrastructure.controllers.user;

import com.grade.project.application.handler.user.GetUserHandler;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.infrastructure.util.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class GetUserController {

    private final GetUserHandler getUserHandler;
    private final JwtUtils jwtUtils;

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable String id) {
        return this.getUserHandler.getUser(id);
    }

    @GetMapping
    public UserDto getMyUser(@RequestHeader(value="Authorization") String token) {
        String email = this.jwtUtils.getEmailFromToken(token);
        return this.getUserHandler.getMyUser(email);
    }
}
