package com.example.projectend.service;

/**
 * MAIL SERVICE (Tiện ích OPTIONAL)
 * Gửi email kích hoạt tài khoản, reset mật khẩu, xác nhận đơn hàng.
 *
 * TODO (Người 2): Implement sendActivationEmail, sendResetPasswordEmail.
 * TODO (Người 5): Có thể dùng để gửi báo cáo định kỳ (optional).
 * NOTE: Có thể mock (log ra console) nếu chưa tích hợp SMTP thật.
 */
public interface MailService {
    void sendActivationEmail(String to, String token);
    void sendResetPasswordEmail(String to, String tempPassword);
    void sendOrderConfirmation(String to, Integer orderId);
}

