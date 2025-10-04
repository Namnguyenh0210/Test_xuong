package com.example.projectend.service;

import com.example.projectend.entity.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * ORDER SERVICE (DonHang)
 * Quản lý quy trình đặt hàng dựa trên bảng DonHang + DonHangChiTiet.
 *
 * TODO (Người 3): Tạo đơn hàng từ giỏ hàng khách (checkout cơ bản).
 * TODO (Người 3): Lấy danh sách đơn hàng của khách (lịch sử) theo thời gian.
 * TODO (Người 4): Admin cập nhật trạng thái đơn hàng, gán nhân viên xử lý.
 * TODO (Người 5): Cung cấp dữ liệu cho thống kê doanh thu.
 */
public interface OrderService {
    // ========== CUSTOMER (Người 3) ==========
    // placeOrder: tạo đơn từ giỏ hàng (MaNV = null, trạng thái = Chờ xác nhận)
    DonHang placeOrder(TaiKhoan customer, DiaChi address, PhuongThucThanhToan pttt, List<DonHangChiTiet> chiTiets);
    Optional<DonHang> findById(Integer id);
    List<DonHang> findByCustomer(TaiKhoan customer); // lịch sử toàn bộ (mới nhất trước - implement sort)
    List<DonHang> findByCustomerAndDateRange(TaiKhoan customer, LocalDateTime from, LocalDateTime to);

    // ========== STAFF / ADMIN (Người 4) ==========
    // Đơn hàng chưa ai nhận xử lý (nhanVien = null) theo trạng thái (thường = CHỜ XÁC NHẬN)
    List<DonHang> findUnassignedByStatus(TrangThaiDonHang status);
    // Danh sách đơn theo nhân viên (để dashboard cá nhân)
    List<DonHang> findByStaff(TaiKhoan staff);
    // Danh sách đơn theo nhân viên + trạng thái (lọc cụ thể: ĐANG XỬ LÝ, ĐANG GIAO ...)
    List<DonHang> findByStaffAndStatus(TaiKhoan staff, TrangThaiDonHang status);
    // Cập nhật trạng thái; lần đầu claim bổ sung MaNV nếu hiện null
    DonHang updateStatus(Integer orderId, TrangThaiDonHang newStatus, TaiKhoan staff);

    // ========== STATUS / FILTER ==========
    List<DonHang> findByStatus(TrangThaiDonHang status);

    // ========== REPORT (Người 5) ==========
    // Lấy các đơn đã HOÀN TẤT trong khoảng để tính thống kê doanh thu / sản phẩm bán ra
    List<DonHang> findCompletedBetween(LocalDateTime from, LocalDateTime to);

    // ========== UTILS ==========
    BigDecimal calculateTotal(DonHang order); // tổng từ chi tiết, đảm bảo khớp TongTien
}
