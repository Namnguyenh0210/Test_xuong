package com.example.projectend.repository;

import com.example.projectend.entity.TrangThaiDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TRANG THAI DON HANG REPOSITORY
 * Người 1 - Database Core (Bổ sung 03/10/2025)
 */
@Repository
public interface TrangThaiDonHangRepository extends JpaRepository<TrangThaiDonHang, Integer> {

    // ========================================
    // TODO: NGƯỜI 4 - Admin: Quản lý trạng thái đơn hàng
    // ========================================
    // TODO: NGƯỜI 4 - Kiểm tra tên trạng thái đã tồn tại (tránh trùng khi thêm)
    // boolean existsByTenTTDH(String tenTTDH);
}

