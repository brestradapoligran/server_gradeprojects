package com.grade.project.infrastructure.util.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    @Value("${spring.auth.secret}")
    private String secret;

    public JwtUtils() {
    }

    public String getJwtToken(String email) {
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
                .setExpiration(new Date(System.currentTimeMillis() + 6000000))
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
        return "Bearer " + token;
    }

    public String getEmailFromToken(String bearerToken) {
        String token = this.removeBearer(bearerToken);
        return Jwts.parser().setSigningKey(secret.getBytes())
                .parseClaimsJws(token).getBody().getSubject();
    }

    public String removeBearer(String bearerToken) {
        return bearerToken.replace("Bearer ", "");
    }
}
