package com.example.projectend.repository;

import com.example.projectend.entity.DiaChi;
import com.example.projectend.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * DIA CHI REPOSITORY
 * Người 1 - Database Core (Bổ sung 03/10/2025)
 */
@Repository
public interface DiaChiRepository extends JpaRepository<DiaChi, Integer> {

    // ========================================
    // TODO: NGƯỜI 2 - Authentication & Profile
    // ========================================
    // TODO: NGƯỜI 2 - Lấy danh sách địa chỉ của user (sắp xếp mặc định trước)
    // List<DiaChi> findByTaiKhoanOrderByMacDinhDesc(TaiKhoan taiKhoan);

    // TODO: NGƯỜI 2 - Lấy địa chỉ mặc định của user
    // Optional<DiaChi> findByTaiKhoanAndMacDinhTrue(TaiKhoan taiKhoan);

    // ========================================
    // TODO: NGƯỜI 3 - Checkout (nếu cần cho giỏ hàng)
    // ========================================
    // TODO: NGƯỜI 3 - Đếm số địa chỉ của user (giới hạn nếu cần)
    // long countByTaiKhoan(TaiKhoan taiKhoan);
}

