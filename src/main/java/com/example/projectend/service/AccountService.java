package com.example.projectend.service;

import com.example.projectend.entity.TaiKhoan;
import com.example.projectend.entity.VaiTro;

import java.util.List;
import java.util.Optional;

/**
 * ACCOUNT SERVICE
 * Quản lý tài khoản người dùng (Customer / Staff / Admin).
 * TODO (Người 2): Implement đăng ký, đổi mật khẩu, cập nhật profile.
 * TODO (Người 4): Quản trị user (phân quyền, khóa/mở khóa).
 */
public interface AccountService {
    Optional<TaiKhoan> findById(Integer id);
    Optional<TaiKhoan> findByEmail(String email);
    boolean emailExists(String email);
    TaiKhoan register(TaiKhoan tk); // TODO (Người 2): Validate email trùng & format
    TaiKhoan updateProfile(TaiKhoan tk);
    void changePassword(Integer userId, String oldPass, String newPass); // TODO (Người 2): Plain text logic
    List<TaiKhoan> findByRole(VaiTro vaiTro);
    List<TaiKhoan> findAll();
    void lockAccount(Integer id); // TODO (Người 4)
    void unlockAccount(Integer id); // TODO (Người 4)
}

