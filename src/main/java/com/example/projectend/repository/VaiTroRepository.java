package com.example.projectend.repository;

import com.example.projectend.entity.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * REPOSITORY VAI TRO
 * TODO: Người 1 - Database & Entities
 * Mô tả: Repository để truy xuất dữ liệu vai trò
 */
@Repository
public interface VaiTroRepository extends JpaRepository<VaiTro, Integer> {

    // TODO: Người 1 - Thêm method tìm vai trò theo tên
    // VaiTro findByTenVT(String tenVT);
}
