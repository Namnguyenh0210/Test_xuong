package com.example.projectend.repository;

import com.example.projectend.entity.TaiKhoan;
import com.example.projectend.entity.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * TAI KHOAN REPOSITORY
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH)
 * Repository cho entity TaiKhoan
 */
@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {

    // ========================================
    // TODO: NGƯỜI 2 - Authentication & Authorization
    // ========================================

    // TODO: NGƯỜI 2 - Thêm method tìm tài khoản theo email cho đăng nhập (ĐÃ TẠO SKELETON)
    Optional<TaiKhoan> findByEmail(String email);

    // TODO: NGƯỜI 2 - Thêm method kiểm tra email đã tồn tại chưa (cho đăng ký) (ĐÃ TẠO SKELETON)
    boolean existsByEmail(String email);

    // TODO: NGƯỜI 2 - Thêm method xác thực email + mật khẩu plain text (chỉ dùng khi tự viết auth tay) (ĐÃ TẠO SKELETON)
    Optional<TaiKhoan> findByEmailAndMatKhau(String email, String matKhau);

    // TODO: NGƯỜI 2 - Thêm method tìm theo vai trò (nếu cần lọc user cho admin) (ĐÃ TẠO SKELETON)
    List<TaiKhoan> findByVaiTro(VaiTro vaiTro);

}
