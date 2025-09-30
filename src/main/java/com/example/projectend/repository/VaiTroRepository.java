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

    // TODO: NGƯỜI 2 - Thêm method tìm vai trò theo tên (cho phân quyền)
    // Optional<VaiTro> findByTenVT(String tenVT);

    // TODO: NGƯỜI 2 - Thêm method lấy vai trò mặc định cho user mới đăng ký
    // default VaiTro getDefaultRole() { return findByTenVT("Khách hàng").orElse(null); }

}
