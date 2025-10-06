package com.example.projectend.repository;

import com.example.projectend.entity.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * VAI TRO REPOSITORY
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH)
 * Repository cho entity VaiTro
 */
@Repository
public interface VaiTroRepository extends JpaRepository<VaiTro, Integer> {

    // ========================================
    // TODO: NGƯỜI 2 - Authentication & Authorization
    // ========================================

    // Tìm vai trò theo tên (cho authentication và phân quyền)
    VaiTro findByTenVT(String tenVT);
}
