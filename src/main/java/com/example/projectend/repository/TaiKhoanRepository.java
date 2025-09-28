package com.example.projectend.repository;

import com.example.projectend.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

/**
 * REPOSITORY TAI KHOAN
 * TODO: Người 1 - Database & Entities
 * TODO: Người 2 - Authentication & Security (sử dụng cho login/register)
 */
@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {

    // TODO: Người 2 - Method cho authentication
    Optional<TaiKhoan> findByEmail(String email);

    // TODO: Người 2 - Check email tồn tại khi đăng ký
    boolean existsByEmail(String email);

    // TODO: Người 5 - Query cho báo cáo khách hàng VIP
    // @Query("SELECT t FROM TaiKhoan t WHERE t.vaiTro.maVT = 3 ORDER BY t.tongTienDaMua DESC")
    // List<TaiKhoan> findTop10CustomersByTotalSpent();

    // TODO: Người 4 - Admin panel - tìm kiếm tài khoản
    // List<TaiKhoan> findByHoTenContainingIgnoreCase(String hoTen);
}
