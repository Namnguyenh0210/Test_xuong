package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * PROFILE CONTROLLER - Quản lý thông tin cá nhân
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * TODO: Người 2 - Authentication & Authorization (Hoàn thiện tính năng)
 */
@Controller
public class ProfileController {

    // ========================================
    // TODO: NGƯỜI 2 - Authentication & Authorization
    // ========================================

    // TODO: NGƯỜI 2 - Inject các service cần thiết
    // @Autowired private TaiKhoanService taiKhoanService;
    // @Autowired private DonHangService donHangService;
    // @Autowired private DiaChiService diaChiService;

    // TODO: Người 2 - Trang thông tin cá nhân
    @GetMapping("/profile")
    public String profile(Model model) {
        // TODO: NGƯỜI 2 - Lấy thông tin user đang đăng nhập
        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // String email = auth.getName();
        // TaiKhoan currentUser = taiKhoanService.findByEmail(email);
        // model.addAttribute("taiKhoan", currentUser);

        // TODO: NGƯỜI 2 - Lấy lịch sử đơn hàng của user (5 đơn gần nhất)
        // List<DonHang> recentOrders = donHangService.getRecentOrdersByUser(currentUser, 5);
        // model.addAttribute("recentOrders", recentOrders);

        // TODO: NGƯỜI 2 - Thống kê cơ bản của user
        // Long totalOrders = donHangService.countOrdersByUser(currentUser);
        // BigDecimal totalSpent = donHangService.calculateTotalSpentByUser(currentUser);
        // model.addAttribute("totalOrders", totalOrders);
        // model.addAttribute("totalSpent", totalSpent);

        model.addAttribute("pageTitle", "Thông tin cá nhân");
        return "profile";
    }

    // TODO: NGƯỜI 2 - Cập nhật thông tin cá nhân
    // @PostMapping("/profile/update")
    // public String updateProfile(@Valid @ModelAttribute TaiKhoan taiKhoan,
    //                            BindingResult result, Model model,
    //                            RedirectAttributes redirectAttributes) {
    //     if (result.hasErrors()) {
    //         return "profile";
    //     }
    //
    //     // Cập nhật thông tin (trừ mật khẩu)
    //     // Kiểm tra email không trùng với user khác
    //     taiKhoanService.updateProfile(taiKhoan);
    //     redirectAttributes.addFlashAttribute("success", "Cập nhật thông tin thành công!");
    //     return "redirect:/profile";
    // }

    // TODO: NGƯỜI 2 - Đổi mật khẩu (plain text)
    // @PostMapping("/profile/change-password")
    // public String changePassword(@RequestParam String currentPassword,
    //                             @RequestParam String newPassword,
    //                             @RequestParam String confirmPassword,
    //                             RedirectAttributes redirectAttributes) {
    //     // Lấy current user
    //     // Kiểm tra mật khẩu hiện tại (so sánh plain text)
    //     // Validate mật khẩu mới
    //     // Cập nhật mật khẩu mới (lưu plain text)
    //     redirectAttributes.addFlashAttribute("success", "Đổi mật khẩu thành công!");
    //     return "redirect:/profile";
    // }

    // TODO: NGƯỜI 2 - Xem lịch sử đơn hàng chi tiết
    // @GetMapping("/profile/orders")
    // public String orderHistory(@RequestParam(defaultValue = "0") int page, Model model) {
    //     // Lấy current user
    //     // Phân trang lịch sử đơn hàng
    //     // Có thể lọc theo trạng thái
    //     return "profile-orders";
    // }

    // TODO: NGƯỜI 2 - Chi tiết đơn hàng
    // @GetMapping("/profile/orders/{orderId}")
    // public String orderDetail(@PathVariable Integer orderId, Model model) {
    //     // Kiểm tra đơn hàng thuộc về user hiện tại
    //     // Lấy chi tiết đơn hàng
    //     return "order-detail";
    // }

    // TODO: NGƯỜI 2 - Quản lý địa chỉ giao hàng
    // @GetMapping("/profile/addresses")
    // @PostMapping("/profile/addresses/add")
    // @PostMapping("/profile/addresses/update")
    // @PostMapping("/profile/addresses/delete")

}
