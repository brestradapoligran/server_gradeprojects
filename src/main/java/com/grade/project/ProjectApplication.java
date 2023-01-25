package com.grade.project;

import com.grade.project.infrastructure.config.auth.JwtAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/api/v1/login").permitAll()
					.antMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
					.antMatchers(HttpMethod.GET, "/api/v1/objects").permitAll()
					.antMatchers(HttpMethod.GET, "/api/v1/object/filters").permitAll()
					.antMatchers(HttpMethod.POST, "/api/v1/user/forgot").permitAll()
					.antMatchers(HttpMethod.POST, "/api/v1/object/search").permitAll()
					.anyRequest().authenticated();
		}
	}
}
