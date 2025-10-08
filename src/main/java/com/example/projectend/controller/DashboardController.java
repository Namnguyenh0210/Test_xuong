package com.example.projectend.controller;

import com.example.projectend.entity.BaiViet;
import com.example.projectend.entity.TaiKhoan;
import com.example.projectend.service.BaiVietService;
import com.example.projectend.service.DanhGiaService;
import com.example.projectend.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Optional;

/**
 * DASHBOARD CONTROLLER - Trang quản lý admin
 * Người 1 - Database Design & Backend Core ✅ ĐÃ HOÀN THÀNH (Cấu trúc cơ bản)
 * Người 2 - Authentication & Security ✅ ĐÃ HOÀN THÀNH (Security config)
 * Người 5 - Admin Dashboard & Reports 🔄 CẦN HOÀN THIỆN
 * <p>
 * ========================================
 * TODO NGƯỜI 5 - DANH SÁCH CHI TIẾT:
 * ========================================
 * <p>
 * BƯỚC 1: Tạo các service còn thiếu (SanPhamService, DonHangService, v.v.)
 * BƯỚC 2: Hoàn thiện Dashboard chính với thống kê
 * BƯỚC 3: Hoàn thiện CRUD quản lý đơn hàng với filter trạng thái
 * BƯỚC 4: Tạo trang báo cáo thống kê với charts
 * BƯỚC 5: Thêm tính năng export Excel/PDF
 * BƯỚC 6: Tạo các template admin với DataTables
 * BƯỚC 7: Thêm real-time notifications cho đơn hàng mới
 */
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN') or hasRole('NHANVIEN')")
public class DashboardController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    // TODO NGƯỜI 5: Tạo các service này
    // @Autowired private SanPhamService sanPhamService;
    // @Autowired private DonHangService donHangService;

    @Autowired
    private BaiVietService baiVietService;

    @Autowired
    private DanhGiaService danhGiaService;

    // TODO NGƯỜI 5: Inject thêm service cần thiết
    // @Autowired private ThongKeService thongKeService;
    // @Autowired private AdminService adminService;

    // Dashboard chính với thống kê tổng quan
    @GetMapping("")
    public String dashboard(Model model) {

        // TODO NGƯỜI 5: Sau khi tạo các service, uncomment các dòng dưới
        // Thống kê cơ bản
        // model.addAttribute("totalUsers", taiKhoanService.countByVaiTro("Khách hàng"));
        // model.addAttribute("totalProducts", sanPhamService.countAll());
        // model.addAttribute("totalOrders", donHangService.countAll());
        model.addAttribute("totalPosts", baiVietService.countActivePosts());

        // TODO NGƯỜI 5: Thêm thống kê nâng cao
        // LocalDate today = LocalDate.now();
        // LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        // LocalDate startOfMonth = today.withDayOfMonth(1);

        // BigDecimal doanhThuHomNay = thongKeService.getDoanhThuByDate(today);
        // BigDecimal doanhThuTuan = thongKeService.getDoanhThuBetweenDates(startOfWeek, today);
        // BigDecimal doanhThuThang = thongKeService.getDoanhThuBetweenDates(startOfMonth, today);

        // model.addAttribute("doanhThuHomNay", doanhThuHomNay);
        // model.addAttribute("doanhThuTuan", doanhThuTuan);
        // model.addAttribute("doanhThuThang", doanhThuThang);

        // // Top sản phẩm bán chạy
        // List<Object[]> topProducts = thongKeService.getTopSellingProducts(5);
        // model.addAttribute("topProducts", topProducts);

        // // Đơn hàng mới cần xử lý
        // List<DonHang> pendingOrders = donHangService.getPendingOrders(10);
        // model.addAttribute("pendingOrders", pendingOrders);

        // // Dữ liệu cho chart doanh thu 7 ngày
        // List<Object[]> chartData = thongKeService.getRevenueChart7Days();
        // model.addAttribute("chartData", chartData);

        model.addAttribute("currentPage", "dashboard");
        model.addAttribute("pageTitle", "Dashboard - Quản lý cửa hàng");

        return "admin/dashboard";
    }

    // ========== QUẢN LÝ BÀI VIẾT (ĐÃ HOÀN THÀNH) ==========
    @GetMapping("/baiviet")
    public String quanLyBaiViet(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BaiViet> baiVietPage = baiVietService.getAllBaiViet(pageable);

        model.addAttribute("baiVietPage", baiVietPage);
        model.addAttribute("currentPage", "baiviet");
        model.addAttribute("pageTitle", "Quản lý bài viết");

        return "admin/baiviet/list";
    }

    @GetMapping("/baiviet/add")
    public String themBaiViet(Model model) {
        model.addAttribute("baiViet", new BaiViet());
        model.addAttribute("currentPage", "baiviet");
        model.addAttribute("pageTitle", "Thêm bài viết mới");

        return "admin/baiviet/form";
    }

    @PostMapping("/baiviet/save")
    public String luuBaiViet(@ModelAttribute BaiViet baiViet,
                             Principal principal,
                             RedirectAttributes redirectAttributes) {
        try {
            // Lấy tài khoản hiện tại
            TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
            baiViet.setTaiKhoan(taiKhoan);

            baiVietService.save(baiViet);
            redirectAttributes.addFlashAttribute("success", "Lưu bài viết thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
        }

        return "redirect:/admin/baiviet";
    }

    @GetMapping("/baiviet/edit/{id}")
    public String suaBaiViet(@PathVariable Integer id, Model model) {
        Optional<BaiViet> baiVietOpt = baiVietService.findById(id);
        if (baiVietOpt.isEmpty()) {
            return "redirect:/admin/baiviet?notfound";
        }

        model.addAttribute("baiViet", baiVietOpt.get());
        model.addAttribute("currentPage", "baiviet");
        model.addAttribute("pageTitle", "Sửa bài viết");

        return "admin/baiviet/form";
    }

    @PostMapping("/baiviet/delete/{id}")
    public String xoaBaiViet(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            baiVietService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Xóa bài viết thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Không thể xóa bài viết: " + e.getMessage());
        }

        return "redirect:/admin/baiviet";
    }

    // ========== QUẢN LÝ ĐÁNH GIÁ (ĐÃ HOÀN THÀNH) ==========
    @GetMapping("/danhgia")
    public String quanLyDanhGia(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                Model model) {
        // TODO NGƯỜI 5: Implement pagination for all reviews
        model.addAttribute("currentPage", "danhgia");
        model.addAttribute("pageTitle", "Quản lý đánh giá");

        return "admin/danhgia/list";
    }

    @PostMapping("/danhgia/delete/{id}")
    public String xoaDanhGia(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            danhGiaService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Xóa đánh giá thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Không thể xóa đánh giá: " + e.getMessage());
        }

        return "redirect:/admin/danhgia";
    }

    // ========== THỐNG KÊ ==========
    @GetMapping("/thongke")
    public String thongKe(Model model) {
        // TODO NGƯỜI 5: Implement statistics dashboard
        model.addAttribute("currentPage", "thongke");
        model.addAttribute("pageTitle", "Thống kê");

        return "admin/thongke";
    }

    // TODO NGƯỜI 5: CÁC CHỨC NĂNG CẦN HOÀN THIỆN
    // 1. Quản lý tài khoản (CRUD)
    // 2. Quản lý sản phẩm (CRUD)
    // 3. Quản lý đơn hàng với filter nâng cao
    // 4. Báo cáo thống kê với charts
    // 5. Export Excel/PDF
    // 6. Cài đặt hệ thống
}
