package com.example.projectend.service;

import com.example.projectend.entity.DonHang;
import com.example.projectend.entity.DonHangChiTiet;
import com.example.projectend.entity.SanPham;

import java.util.List;

/**
 * ORDER DETAIL SERVICE (DonHangChiTiet)
 * Quản lý chi tiết đơn hàng.
 * TODO (Người 3): Lấy chi tiết đơn hàng khi khách xem lịch sử.
 * TODO (Người 4): Admin xem / chỉnh sửa (nếu cho phép) chi tiết đơn hàng.
 * TODO (Người 5): Dữ liệu thống kê top sản phẩm.
 */
public interface OrderDetailService {
    List<DonHangChiTiet> findByOrder(DonHang order);
    List<DonHangChiTiet> findByProduct(SanPham sp);
    DonHangChiTiet addDetail(DonHangChiTiet ct);
    void removeDetail(Integer id); // cẩn trọng: hiếm khi xóa thực tế
}

