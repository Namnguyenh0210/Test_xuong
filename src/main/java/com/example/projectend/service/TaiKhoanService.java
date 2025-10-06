package com.example.projectend.service;

import com.example.projectend.entity.TaiKhoan;
import com.example.projectend.entity.VaiTro;
import com.example.projectend.repository.TaiKhoanRepository;
import com.example.projectend.repository.VaiTroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * TAI KHOAN SERVICE - Xử lý logic nghiệp vụ tài khoản
 * Người 1 - Database Design & Backend Core
 * Người 2 - Authentication & Security (sử dụng)
 */
@Service
public class TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private VaiTroRepository vaiTroRepository;

    // Tìm tài khoản theo email (cho login)
    public TaiKhoan findByEmail(String email) {
        return taiKhoanRepository.findByEmail(email).orElse(null);
    }

    // Lưu tài khoản (đăng ký hoặc cập nhật)
    public TaiKhoan save(TaiKhoan taiKhoan) {
        return taiKhoanRepository.save(taiKhoan);
    }

    // Tìm theo ID
    public Optional<TaiKhoan> findById(Integer id) {
        return taiKhoanRepository.findById(id);
    }

    // Xóa tài khoản
    public void deleteById(Integer id) {
        taiKhoanRepository.deleteById(id);
    }

    // Lấy tất cả tài khoản có phân trang
    public Page<TaiKhoan> getAllTaiKhoan(Pageable pageable) {
        return taiKhoanRepository.findAll(pageable);
    }

    // Đếm tài khoản theo vai trò
    public Long countByVaiTro(String tenVaiTro) {
        VaiTro vaiTro = vaiTroRepository.findByTenVT(tenVaiTro);
        if (vaiTro != null) {
            return taiKhoanRepository.countByVaiTro(vaiTro);
        }
        return 0L;
    }

    // Kiểm tra email đã tồn tại chưa
    public boolean existsByEmail(String email) {
        return taiKhoanRepository.findByEmail(email) != null;
    }
}
