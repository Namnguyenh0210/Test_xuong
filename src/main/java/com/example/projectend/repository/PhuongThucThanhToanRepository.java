package com.example.projectend.repository;

import com.example.projectend.entity.PhuongThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PHUONG THUC THANH TOAN REPOSITORY
 * Người 1 - Database Core (Bổ sung 03/10/2025)
 */
@Repository
public interface PhuongThucThanhToanRepository extends JpaRepository<PhuongThucThanhToan, Integer> {

    // ========================================
    // TODO: NGƯỜI 4 - Admin Panel
    // ========================================
    // TODO: NGƯỜI 4 - Kiểm tra tên phương thức đã tồn tại (tránh trùng khi thêm mới)
    // boolean existsByTenPTTT(String tenPTTT);

    // ========================================
    // TODO: NGƯỜI 5 - Reports (nếu phân tích tần suất sử dụng)
    // ========================================
    // TODO: NGƯỜI 5 - Đếm số đơn hàng sử dụng phương thức này (thêm query ở DonHangRepository)
    // long countBy... (sử dụng join ở repo khác)
}

