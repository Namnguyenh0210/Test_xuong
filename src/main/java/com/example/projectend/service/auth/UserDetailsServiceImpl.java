package com.example.projectend.service.auth;

import com.example.projectend.entity.TaiKhoan;
import com.example.projectend.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * USER DETAILS SERVICE IMPLEMENTATION
 * Người 2 - Authentication System
 * Load user từ SQL Server database và map roles
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Tìm user theo email trong database
        TaiKhoan taiKhoan = taiKhoanRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản với email: " + email));

        // Kiểm tra tài khoản có bị vô hiệu hóa không
        if (!taiKhoan.getTrangThai()) {
            throw new UsernameNotFoundException("Tài khoản đã bị vô hiệu hóa: " + email);
        }

        // Map roles từ database
        List<GrantedAuthority> authorities = new ArrayList<>();
        String roleName = "ROLE_" + taiKhoan.getVaiTro().getTenVT().toUpperCase();
        authorities.add(new SimpleGrantedAuthority(roleName));

        // Return Spring Security User object
        return User.builder()
            .username(taiKhoan.getEmail())
            .password(taiKhoan.getMatKhau())
            .authorities(authorities)
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(!taiKhoan.getTrangThai())
            .build();
    }

    /**
     * Helper method để lấy TaiKhoan entity từ email
     * Dùng cho các service khác cần thông tin user đầy đủ
     */
    public TaiKhoan getTaiKhoanByEmail(String email) {
        return taiKhoanRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản: " + email));
    }
}
