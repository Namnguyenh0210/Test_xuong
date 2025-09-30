package com.example.projectend.repository;

import com.example.projectend.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DON HANG REPOSITORY
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH)
 * Repository cho entity DonHang
 */
@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website
    // ========================================

    // TODO: NGƯỜI 3 - Thêm method lấy lịch sử đơn hàng của khách hàng
    // List<DonHang> findByTaiKhoanOrderByNgayDatDesc(TaiKhoan taiKhoan);

    // TODO: NGƯỜI 3 - Thêm method tìm đơn hàng theo trạng thái (cho khách hàng)
    // List<DonHang> findByTaiKhoanAndTrangThaiDonHang(TaiKhoan taiKhoan, TrangThaiDonHang trangThai);

    // TODO: NGƯỜI 3 - Thêm method đếm số đơn hàng của khách hàng
    // Long countByTaiKhoan(TaiKhoan taiKhoan);

    // ========================================
    // TODO: NGƯỜI 4 - Admin Panel & Product Management
    // ========================================

    // TODO: NGƯỜI 4 - Thêm method lấy tất cả đơn hàng (cho admin)
    // List<DonHang> findAllByOrderByNgayDatDesc();

    // TODO: NGƯỜI 4 - Thêm method tìm đơn hàng theo trạng thái (cho admin)
    // List<DonHang> findByTrangThaiDonHangOrderByNgayDatDesc(TrangThaiDonHang trangThai);

    // TODO: NGƯỜI 4 - Thêm method tìm đơn hàng theo ngày
    // List<DonHang> findByNgayDatBetween(LocalDateTime start, LocalDateTime end);

    // TODO: NGƯỜI 4 - Thêm method thống kê đơn hàng theo trạng thái
    // Long countByTrangThaiDonHang(TrangThaiDonHang trangThai);

    // ========================================
    // TODO: NGƯỜI 5 - Reports & Analytics
    // ========================================

    // TODO: NGƯỜI 5 - Thêm method tính tổng doanh thu theo khoảng thời gian
    // @Query("SELECT SUM(dh.tongTien) FROM DonHang dh WHERE dh.ngayDat BETWEEN :start AND :end")
    // BigDecimal calculateRevenueByDateRange(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    // TODO: NGƯỜI 5 - Thêm method thống kê đơn hàng theo tháng
    // @Query("SELECT MONTH(dh.ngayDat), COUNT(dh), SUM(dh.tongTien) FROM DonHang dh WHERE YEAR(dh.ngayDat) = :year GROUP BY MONTH(dh.ngayDat)")
    // List<Object[]> getMonthlyStatistics(@Param("year") int year);

    // TODO: NGƯỜI 5 - Thêm method lấy top khách hàng theo doanh thu
    // @Query("SELECT dh.taiKhoan, SUM(dh.tongTien) FROM DonHang dh GROUP BY dh.taiKhoan ORDER BY SUM(dh.tongTien) DESC")
    // List<Object[]> getTopCustomersByRevenue();

}
