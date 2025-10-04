package com.example.projectend.service;

import com.example.projectend.entity.DonHangChiTiet;
import com.example.projectend.entity.ThongKe;
import com.example.projectend.entity.TaiKhoan;
import com.example.projectend.entity.SanPham;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * REPORT SERVICE (ThongKe / Analytics)
 * Tách khỏi repository để gom logic tổng hợp.
 * TODO (Người 5): Implement tất cả.
 * TODO (Người 4): Có thể gọi nhanh revenueToday() cho dashboard admin.
 */
public interface ReportService {
    // ================== DOANH THU CƠ BẢN ==================
    // TODO (Người 5): Chỉ tính doanh thu từ các đơn ở trạng thái HOÀN TẤT (không tính đơn hủy / đang xử lý)
    BigDecimal revenueBetween(LocalDateTime start, LocalDateTime end);

    // Doanh thu nhóm theo loại sản phẩm (categoryName, totalRevenue, totalQty)
    // TODO (Người 5): Sử dụng JOIN DonHang -> DonHangChiTiet -> SanPham -> LoaiSanPham và filter trạng thái HOÀN TẤT
    List<Object[]> revenueGroupByCategory(LocalDateTime start, LocalDateTime end);

    // Top khách hàng: (TaiKhoan, tổng tiền hoàn tất, ngày mua đầu tiên, ngày mua cuối cùng)
    // TODO (Người 5): Lấy từ DonHang HOÀN TẤT group by MaKH order by SUM(TongTien) desc
    List<Object[]> topCustomers(int limit);

    // Top sản phẩm: (SanPham, tổng SL bán ra, tổng doanh thu) – dựa trên DonHangChiTiet của đơn HOÀN TẤT
    List<Object[]> topProducts(int limit);

    // ================== DAILY SUMMARY (ThongKe) ==================
    // upsertDailySummary: nếu đã có record ngày đó -> cập nhật, nếu chưa thì tạo mới.
    // Công thức:
    //  - TongDoanhThu = SUM(TongTien) của DonHang HOÀN TẤT trong ngày (0h00 -> 23h59:59)
    //  - TongDonHang = COUNT(đơn HOÀN TẤT trong ngày)
    //  - TongSanPhamBanRa = SUM(SoLuong) của DonHangChiTiet thuộc các đơn HOÀN TẤT trong ngày
    // TODO (Người 5): Dùng Transaction để đảm bảo tính nhất quán nếu nhiều insert song song
    ThongKe upsertDailySummary(LocalDate day);

    // Lấy danh sách thống kê trong khoảng ngày (bao gồm cả ngày start & end)
    List<ThongKe> findRange(LocalDate start, LocalDate end);

    // Doanh thu hôm nay (dựa trên HOÀN TẤT)
    BigDecimal revenueToday();

    // Doanh thu tháng hiện tại (1 -> ngày hôm nay) trạng thái HOÀN TẤT
    BigDecimal revenueThisMonth();

    // ================== DRILL DOWN & HỖ TRỢ PHÂN TÍCH ==================
    // Chi tiết đơn hàng đã bán của 1 sản phẩm (phục vụ xem lịch sử / drilldown dashboard)
    List<DonHangChiTiet> rawDetailsForProduct(SanPham sp);

    // Lịch sử mua hàng của 1 khách hàng ở cấp sản phẩm: (product, totalQty, lastDate)
    // TODO (Người 5): Giúp màn profile hoặc gợi ý sản phẩm (Người 3 có thể tái sử dụng)
    List<Object[]> customerPurchaseHistory(TaiKhoan customer);

    // ================== OPTIONAL NÂNG CAO ==================
    // TODO (Người 5): Thêm phương thức thống kê tăng trưởng theo ngày (growth %) nếu còn thời gian.
    // Map<LocalDate, BigDecimal> revenueTrend(LocalDate start, LocalDate end);
}
