package com.example.projectend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SECURITY CONFIG (ĐƠN GIẢN CHO ASM)
 * Giữ mức tối thiểu: phân quyền URL cơ bản + form login + logout.
 *
 * ĐÃ LƯỢC BỚT cho dễ học:
 *  - Bỏ DaoAuthenticationProvider bean (Spring Boot tự tạo khi có UserDetailsService + PasswordEncoder)
 *  - Bỏ AuthenticationManager bean (không cần nếu dùng formLogin mặc định)
 *  - Giữ PasswordEncoder NoOp để dùng mật khẩu plain text đúng yêu cầu bài.
 *
 * TODO (Người 2):
 *  1. Khi muốn phân quyền thật: thay .requestMatchers("/admin/**").authenticated() => hasRole("ADMIN")
 *  2. Bật remember-me nếu cần (đã đặt TODO bên dưới)
 *  3. Khi chuyển sang mã hoá: đổi passwordEncoder() sang BCryptPasswordEncoder()
 *  4. Thêm access denied page: .exceptionHandling(e -> e.accessDeniedPage("/403"))
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Plain text password encoder (tối giản cho ASM) - KHÔNG dùng production
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/home", "/sanpham", "/sanpham/**", "/gioithieu", "/kienthuc", "/lienhe", "/login", "/register").permitAll()
                .requestMatchers("/css/**", "/js/**", "/img/**", "/static/**", "/webjars/**").permitAll()
                // TODO (Người 2): Đổi authenticated() thành hasRole("ADMIN") khi role mapping hoạt động
                .requestMatchers("/admin/**").authenticated()
                .requestMatchers("/profile", "/profile/**", "/giohang", "/checkout").authenticated()
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
            )
            // TODO (Người 2): Bật CSRF khi submit form thật (để yên disable cho dev nhanh)
            .csrf(csrf -> csrf.disable())
            // TODO (Người 2): remember-me (khi làm xong login cơ bản)
            // .rememberMe(rm -> rm.tokenValiditySeconds(7 * 24 * 3600))
            .headers(h -> h.frameOptions().sameOrigin());

        return http.build();
    }
}
