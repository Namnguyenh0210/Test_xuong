package com.example.projectend.repository;

import com.example.projectend.entity.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * REPOSITORY LOAI SAN PHAM
 * TODO: Người 1 - Database & Entities
 * TODO: Người 4 - Admin Panel (CRUD categories)
 */
@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, Integer> {

    // TODO: Người 3 - Method cho frontend hiển thị menu danh mục
    List<LoaiSanPham> findAllByOrderByTenLoaiAsc();

    // TODO: Người 4 - Admin panel - tìm kiếm danh mục
    // List<LoaiSanPham> findByTenLoaiContainingIgnoreCase(String tenLoai);
}
