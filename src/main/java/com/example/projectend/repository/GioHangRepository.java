package com.example.projectend.repository;

import com.example.projectend.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * GIO HANG REPOSITORY
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH)
 * Repository cho entity GioHang
 */
@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Integer> {

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website
    // ========================================

    // TODO: NGƯỜI 3 - Thêm method lấy toàn bộ giỏ hàng của một khách hàng
    // List<GioHang> findByTaiKhoan(TaiKhoan taiKhoan);

    // TODO: NGƯỜI 3 - Thêm method kiểm tra sản phẩm đã có trong giỏ hàng chưa
    // Optional<GioHang> findByTaiKhoanAndSanPham(TaiKhoan taiKhoan, SanPham sanPham);

    // TODO: NGƯỜI 3 - Thêm method đếm số lượng sản phẩm trong giỏ hàng
    // Long countByTaiKhoan(TaiKhoan taiKhoan);

    // TODO: NGƯỜI 3 - Thêm method xóa toàn bộ giỏ hàng của khách (sau khi đặt hàng)
    // void deleteByTaiKhoan(TaiKhoan taiKhoan);

    // TODO: NGƯỜI 3 - Thêm method tính tổng tiền giỏ hàng (custom query)
    // @Query("SELECT SUM(gh.soLuong * sp.gia) FROM GioHang gh JOIN gh.sanPham sp WHERE gh.taiKhoan = :taiKhoan")
    // BigDecimal calculateTotalByTaiKhoan(@Param("taiKhoan") TaiKhoan taiKhoan);

}
