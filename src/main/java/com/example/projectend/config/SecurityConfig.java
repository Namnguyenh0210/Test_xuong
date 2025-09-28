package com.example.projectend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Tạm thời cho phép tất cả request
            )
            .csrf(csrf -> csrf.disable()) // Tắt CSRF cho development
            .headers(headers -> headers.frameOptions().disable()); // Cho phép H2 console
        
        return http.build();
    }
}
