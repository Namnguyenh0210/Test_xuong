package com.example.projectend.repository;

import com.example.projectend.entity.GioHang;
import com.example.projectend.entity.GioHangId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * GIO HANG REPOSITORY
 * Người 1 - Database Core (Bổ sung 03/10/2025)
 */
@Repository
public interface GioHangRepository extends JpaRepository<GioHang, GioHangId> {

    // ========================================
    // TODO: NGƯỜI 3 - CART OPERATIONS (BUSINESS RULE)
    // ========================================
    // Lấy toàn bộ item giỏ hàng của user (sort theo MaSP hoặc thời gian nếu có cột thời gian sau này)
    // List<GioHang> findByTaiKhoanOrderBySanPham_MaSPAsc(TaiKhoan taiKhoan);

    // Tìm 1 item trong giỏ để quyết định: nếu tồn tại -> cập nhật +quantity (UP-SERT logic)
    // Optional<GioHang> findByTaiKhoanAndSanPham(TaiKhoan taiKhoan, SanPham sanPham);

    // Xoá tất cả giỏ hàng user sau khi checkout thành công (dùng trong OrderService.placeOrder)
    // void deleteByTaiKhoan(TaiKhoan taiKhoan);

    // ========================================
    // TODO: NGƯỜI 2/3 - MERGE CART (Remember cart khi login) (Optional)
    // ========================================
    // Lấy số lượng items để quyết định merge strategy (ví dụ > 100 thì giới hạn)
    // long countByTaiKhoan(TaiKhoan taiKhoan);

    // ========================================
    // TODO: NGƯỜI 4 - DASHBOARD ADMIN / STAFF
    // ========================================
    // Tổng số record cart trong hệ thống (theo dõi tương tác khách)
    // long count();
}
