package com.example.projectend.repository;

import com.example.projectend.entity.DonHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DON HANG CHI TIET REPOSITORY
 * Người 1 - Database Core (Bổ sung 03/10/2025)
 */
@Repository
public interface DonHangChiTietRepository extends JpaRepository<DonHangChiTiet, Integer> {

    // ========================================
    // TODO: NGƯỜI 3 - Lịch sử đơn hàng
    // ========================================
    // TODO: NGƯỜI 3 - Lấy chi tiết theo đơn hàng
    // List<DonHangChiTiet> findByDonHang(DonHang donHang);

    // ========================================
    // TODO: NGƯỜI 5 - Analytics sản phẩm bán chạy
    // ========================================
    // TODO: NGƯỜI 5 - Top sản phẩm bán chạy (sử dụng group by)
    // @Query("SELECT c.sanPham AS sp, SUM(c.soLuong) AS total FROM DonHangChiTiet c GROUP BY c.sanPham ORDER BY total DESC")
    // List<Object[]> getTopSellingProducts();

    // TODO: NGƯỜI 5 - Tổng số lượng bán của 1 sản phẩm
    // long countBySanPham(SanPham sanPham);
}

