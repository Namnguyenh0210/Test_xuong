package com.example.projectend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SECURITY CONFIGURATION
 * Người 1 - Database Design & Backend Core (Cấu hình cơ bản)
 * TODO: Người 2 - Authentication & Authorization (Hoàn thiện bảo mật)
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/", "/home", "/sanpham", "/gioithieu", "/kienthuc", "/lienhe").permitAll()
                .requestMatchers("/css/**", "/js/**", "/img/**", "/static/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            )
            .logout(logout -> logout.permitAll())
            .csrf(csrf -> csrf.disable()) // Tạm thời disable cho development
            .headers(headers -> headers.frameOptions().sameOrigin());

        return http.build();
    }

    // TODO: Người 2 - Thêm UserDetailsService
    // TODO: Người 2 - Cấu hình phân quyền theo vai trò (Admin/Staff/Customer)
    // TODO: Người 2 - Cấu hình session management
}
