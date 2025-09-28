package com.example.projectend.repository;

import com.example.projectend.entity.SanPham;
import com.example.projectend.entity.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * REPOSITORY SAN PHAM
 * TODO: Người 1 - Database & Entities
 * TODO: Người 3 - Frontend (lấy sản phẩm hiển thị)
 * TODO: Người 4 - Admin Panel (CRUD products)
 */
@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    // TODO: Người 3 - Methods cho trang chủ
    // @Query("SELECT s FROM SanPham s ORDER BY s.soLuongDaBan DESC")
    // List<SanPham> findFeaturedProducts(@Param("limit") int limit);

    // @Query("SELECT s FROM SanPham s ORDER BY s.ngayTao DESC")
    // List<SanPham> findNewestProducts(@Param("limit") int limit);

    // TODO: Người 3 - Lấy sản phẩm theo danh mục
    List<SanPham> findByLoaiSanPham(LoaiSanPham loaiSanPham);

    // TODO: Người 3 - Tìm kiếm sản phẩm
    List<SanPham> findByTenSPContainingIgnoreCase(String tenSP);

    // TODO: Người 4 - Admin panel - quản lý sản phẩm
    // List<SanPham> findByTenSPContainingIgnoreCaseOrderByNgayTaoDesc(String tenSP);

    // TODO: Người 5 - Báo cáo doanh thu
    // @Query("SELECT s.loaiSanPham, SUM(od.soLuong * od.donGia) as tongDoanhThu FROM SanPham s JOIN OrderDetail od ON s.maSP = od.sanPham.maSP GROUP BY s.loaiSanPham")
    // List<Object[]> getRevenueByCategory();
}
