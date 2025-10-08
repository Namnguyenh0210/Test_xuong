package com.example.projectend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SECURITY CONFIG - ASM WEB BÁN HÀNG TẾT
 * Đơn giản hóa cho môi trường học tập, vừa đủ tính năng
 * <p>
 * ĐĂNG NHẬP BẰNG EMAIL + MẬT KHẨU PLAIN TEXT
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Plain text password cho ASM (không mã hóa)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Public pages - ai cũng vào được
                        .requestMatchers("/", "/home", "/sanpham", "/sanpham/**", "/gioithieu", "/kienthuc", "/lienhe").permitAll()
                        .requestMatchers("/giohang", "/giohang/**").permitAll()  // Cho phép truy cập giỏ hàng không cần đăng nhập
                        .requestMatchers("/login", "/register").permitAll()
                        .requestMatchers("/css/**", "/js/**", "/img/**", "/static/**").permitAll()
                        .requestMatchers("/api/public/**").permitAll()

                        // Admin pages - chỉ ADMIN
                        .requestMatchers("/admin/**", "/api/admin/**").hasRole("ADMIN")

                        // User pages - phải đăng nhập (bỏ giohang ra khỏi đây)
                        .requestMatchers("/profile/**", "/checkout/**", "/orders/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")

                        // Còn lại phải đăng nhập
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error=true")
                        .usernameParameter("email") // ĐĂNG NHẬP BẰNG EMAIL
                        .passwordParameter("password")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/?logout=success")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
                )
                // Tắt CSRF cho đơn giản (chỉ dùng trong ASM)
                .csrf(csrf -> csrf.disable())
                // Exception handling đơn giản
                .exceptionHandling(ex -> ex
                        .accessDeniedPage("/403")
                );

        return http.build();
    }
}
