package com.example.projectend.repository;

import com.example.projectend.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SAN PHAM REPOSITORY
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH)
 * NOTE 04/10/2025: ĐÃ GỬ các TODO liên quan TrangThaiSanPham vì schema hiện tại không có cột MaTTSP và tính năng trạng thái đã bị xoá.
 * Repository cho entity SanPham
 */
@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website
    // ========================================

    // TODO: NGƯỜI 3 - Thêm method tìm sản phẩm theo loại (cho menu danh mục)
    // List<SanPham> findByLoaiSanPham(LoaiSanPham loai);

    // TODO: NGƯỜI 3 - Thêm method tìm kiếm sản phẩm theo tên
    // List<SanPham> findByTenSPContaining(String keyword);

    // TODO: NGƯỜI 3 - Thêm method lấy sản phẩm mới nhất (trang chủ)
    // List<SanPham> findTop6ByOrderByNgayTaoDesc();

    // TODO: NGƯỜI 3 - Thêm method lấy sản phẩm theo giá (lọc)
    // List<SanPham> findByGiaBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // ========================================
    // TODO: NGƯỜI 4 - Admin Panel & Product Management
    // ========================================

    // TODO: NGƯỜI 4 - Thêm method tìm sản phẩm sắp hết hàng
    // List<SanPham> findBySoLuongLessThan(Integer threshold);

    // TODO: NGƯỜI 4 - Thêm method tìm sản phẩm theo khoảng thời gian tạo
    // List<SanPham> findByNgayTaoBetween(LocalDateTime start, LocalDateTime end);
}
