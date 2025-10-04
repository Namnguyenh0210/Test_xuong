package com.example.projectend.repository;

import com.example.projectend.entity.NhapKho;
import com.example.projectend.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * NHAP KHO REPOSITORY
 * Người 1 - Database Core (Bổ sung 03/10/2025)
 */
@Repository
public interface NhapKhoRepository extends JpaRepository<NhapKho, Integer> {

    // ========================================
    // TODO: NGƯỜI 4 - Admin: Lịch sử nhập kho
    // ========================================
    // TODO: NGƯỜI 4 - Lấy lịch sử nhập kho theo sản phẩm
    // List<NhapKho> findBySanPhamOrderByNgayNhapDesc(SanPham sanPham);

    // TODO: NGƯỜI 4 - Lọc theo khoảng thời gian
    // List<NhapKho> findByNgayNhapBetween(LocalDateTime start, LocalDateTime end);
}

