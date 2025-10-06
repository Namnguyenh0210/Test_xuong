package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PROFILE CONTROLLER - Quản lý thông tin cá nhân và đơn hàng
 * Người 1 - Database Design & Backend Core ✅ ĐÃ HOÀN THÀNH (Cấu trúc cơ bản)
 * Người 4 - Order Management & Checkout 🔄 CẦN HOÀN THIỆN
 *
 * ========================================
 * TODO NGƯỜI 4 - DANH SÁCH CHI TIẾT:
 * ========================================
 *
 * BƯỚC 1: Inject Services cần thiết
 * @Autowired private TaiKhoanService taiKhoanService;
 * @Autowired private DonHangService donHangService;
 * @Autowired private DiaChiService diaChiService;
 *
 * BƯỚC 2: Hoàn thiện method profile() - hiển thị thông tin & lịch sử đơn hàng
 * BƯỚC 3: Tạo method updateProfile() - cập nhật thông tin cá nhân
 * BƯỚC 4: Tạo method changePassword() - đổi mật khẩu
 * BƯỚC 5: Tạo method orderDetail() - xem chi tiết đơn hàng
 * BƯỚC 6: Cập nhật template profile.html với tabs
 */
@Controller
public class ProfileController {

    // TODO NGƯỜI 4: Inject các service sau khi đã tạo
    // @Autowired private TaiKhoanService taiKhoanService;
    // @Autowired private DonHangService donHangService;
    // @Autowired private DiaChiService diaChiService;

    // Trang thông tin cá nhân với lịch sử đơn hàng
    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        model.addAttribute("currentPage", "profile");

        // TODO NGƯỜI 4: Thêm logic sau khi có service
        // if (principal != null) {
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //     model.addAttribute("taiKhoan", taiKhoan);
        //
        //     // Lấy danh sách đơn hàng của user (phân trang)
        //     Page<DonHang> donHangPage = donHangService.getDonHangByKhachHang(taiKhoan, PageRequest.of(0, 10));
        //     model.addAttribute("donHangPage", donHangPage);
        //
        //     // Lấy địa chỉ giao hàng
        //     List<DiaChi> diaChiList = diaChiService.getDiaChiByTaiKhoan(taiKhoan);
        //     model.addAttribute("diaChiList", diaChiList);
        // }

        // Breadcrumb
        Map<String, String> breadcrumbItem = new HashMap<>();
        breadcrumbItem.put("name", "Thông tin cá nhân");
        breadcrumbItem.put("url", null);
        List<Map<String, String>> breadcrumbItems = List.of(breadcrumbItem);
        model.addAttribute("breadcrumbItems", breadcrumbItems);

        model.addAttribute("pageTitle", "Thông tin cá nhân - Cửa hàng đồ Tết");
        return "profile";
    }

    // TODO NGƯỜI 4: Cập nhật thông tin cá nhân
    @PostMapping("/profile/update")
    public String updateProfile(
            @RequestParam String hoTen,
            @RequestParam String soDienThoai,
            Principal principal,
            RedirectAttributes redirectAttributes) {

        // TODO NGƯỜI 4: Implement logic
        // try {
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //     taiKhoan.setHoTen(hoTen);
        //     taiKhoan.setSoDienThoai(soDienThoai);
        //
        //     taiKhoanService.save(taiKhoan);
        //     redirectAttributes.addFlashAttribute("success", "Cập nhật thông tin thành công!");
        // } catch (Exception e) {
        //     redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
        // }

        return "redirect:/profile";
    }

    // TODO NGƯỜI 4: Đổi mật khẩu
    @PostMapping("/profile/change-password")
    public String changePassword(
            @RequestParam String currentPassword,
            @RequestParam String newPassword,
            @RequestParam String confirmPassword,
            Principal principal,
            RedirectAttributes redirectAttributes) {

        // TODO NGƯỜI 4: Implement logic
        // try {
        //     if (!newPassword.equals(confirmPassword)) {
        //         redirectAttributes.addFlashAttribute("error", "Mật khẩu xác nhận không khớp!");
        //         return "redirect:/profile";
        //     }
        //
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //
        //     // Kiểm tra mật khẩu hiện tại (plain text cho ASM)
        //     if (!currentPassword.equals(taiKhoan.getMatKhau())) {
        //         redirectAttributes.addFlashAttribute("error", "Mật khẩu hiện tại không đúng!");
        //         return "redirect:/profile";
        //     }
        //
        //     taiKhoan.setMatKhau(newPassword);
        //     taiKhoanService.save(taiKhoan);
        //
        //     redirectAttributes.addFlashAttribute("success", "Đổi mật khẩu thành công!");
        // } catch (Exception e) {
        //     redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
        // }

        return "redirect:/profile";
    }

    // TODO NGƯỜI 4: Chi tiết đơn hàng
    @GetMapping("/profile/orders/{id}")
    public String orderDetail(@PathVariable Integer id, Model model, Principal principal) {

        // TODO NGƯỜI 4: Implement logic
        // try {
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //     Optional<DonHang> donHangOpt = donHangService.findByIdAndKhachHang(id, taiKhoan);
        //
        //     if (donHangOpt.isEmpty()) {
        //         return "redirect:/profile?notfound";
        //     }
        //
        //     DonHang donHang = donHangOpt.get();
        //     model.addAttribute("donHang", donHang);
        //
        //     // Lấy chi tiết đơn hàng
        //     List<DonHangChiTiet> chiTietList = donHangService.getChiTietDonHang(donHang);
        //     model.addAttribute("chiTietList", chiTietList);
        // } catch (Exception e) {
        //     return "redirect:/profile?error";
        // }

        // Breadcrumb
        Map<String, String> breadcrumb1 = new HashMap<>();
        breadcrumb1.put("name", "Thông tin cá nhân");
        breadcrumb1.put("url", "/profile");

        Map<String, String> breadcrumb2 = new HashMap<>();
        breadcrumb2.put("name", "Chi tiết đơn hàng");
        breadcrumb2.put("url", null);

        List<Map<String, String>> breadcrumbItems = List.of(breadcrumb1, breadcrumb2);
        model.addAttribute("breadcrumbItems", breadcrumbItems);

        model.addAttribute("currentPage", "profile");
        model.addAttribute("pageTitle", "Chi tiết đơn hàng - Cửa hàng đồ Tết");
        return "order-detail";
    }

    // TODO NGƯỜI 4: Hủy đơn hàng (chỉ khi chưa giao)
    @PostMapping("/profile/orders/{id}/cancel")
    public String cancelOrder(@PathVariable Integer id, Principal principal, RedirectAttributes redirectAttributes) {

        // TODO NGƯỜI 4: Implement logic
        // try {
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //     boolean success = donHangService.cancelOrder(id, taiKhoan);
        //
        //     if (success) {
        //         redirectAttributes.addFlashAttribute("success", "Hủy đơn hàng thành công!");
        //     } else {
        //         redirectAttributes.addFlashAttribute("error", "Không thể hủy đơn hàng này!");
        //     }
        // } catch (Exception e) {
        //     redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
        // }

        return "redirect:/profile";
    }
}
