package com.example.projectend.service;

import com.example.projectend.entity.PhuongThucThanhToan;
import java.util.List;
import java.util.Optional;

/**
 * PAYMENT METHOD SERVICE (PhuongThucThanhToan)
 * Quản lý các phương thức thanh toán khả dụng.
 * TODO (Người 4): CRUD trong Admin (thêm/sửa/xoá hoặc disable).
 * TODO (Người 3): Lấy danh sách active cho trang checkout.
 */
public interface PaymentMethodService {
    List<PhuongThucThanhToan> findAll();
    Optional<PhuongThucThanhToan> findById(Integer id);
    PhuongThucThanhToan create(PhuongThucThanhToan p);
    PhuongThucThanhToan update(PhuongThucThanhToan p);
    void delete(Integer id); // Có thể đổi thành disable nếu cần log lịch sử
}

