package com.example.projectend.service;

import com.example.projectend.entity.TaiKhoan;
import java.util.Optional;

/**
 * AUTH SERVICE
 * Đóng gói logic đăng nhập / đăng ký ngoài Spring Security mặc định.
 *
 * TODO (Người 2): Implement toàn bộ.
 * TODO (Người 3): Sau khi login thành công, có thể gọi đồng bộ giỏ hàng tạm (CartService) nếu làm nâng cao.
 */
public interface AuthService {
    Optional<TaiKhoan> loginPlain(String email, String password); // Plain text theo yêu cầu bài
    TaiKhoan register(TaiKhoan tk); // Validate email trùng trước khi lưu
    void changePassword(Integer userId, String oldPass, String newPass);
    void resetPasswordRequest(String email); // Gửi mail reset (nếu làm)
    boolean verifyEmailToken(String token); // Optional: kích hoạt tài khoản
}

