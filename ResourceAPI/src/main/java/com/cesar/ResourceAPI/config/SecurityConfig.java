package com.cesar.ResourceAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests( request -> request
                        .requestMatchers("/resource").authenticated())
                .oauth2ResourceServer( r -> r
                        .jwt(Customizer.withDefaults()) )
                .sessionManagement( s -> s
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
