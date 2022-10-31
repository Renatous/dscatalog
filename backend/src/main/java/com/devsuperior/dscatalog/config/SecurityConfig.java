package com.devsuperior.dscatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain resources(HttpSecurity http) throws Exception {
	    http
	        .requestMatchers((matchers) -> matchers.antMatchers("/static/**"))
	        .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll())
	        .requestCache().disable()
	        .securityContext().disable()
	        .sessionManagement().disable();

	    return http.build();
	}

}