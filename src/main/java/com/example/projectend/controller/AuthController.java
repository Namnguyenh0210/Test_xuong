package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * AUTH CONTROLLER - Đăng nhập/Đăng ký
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * TODO: Người 2 - Authentication & Authorization (Hoàn thiện tính năng)
 */
@Controller
public class AuthController {

    // ========================================
    // TODO: NGƯỜI 2 - Authentication & Authorization
    // ========================================

    // TODO: NGƯỜI 2 - Inject các service cần thiết
    // @Autowired private TaiKhoanService taiKhoanService;
    // @Autowired private AuthenticationManager authenticationManager;

    // TODO: Người 2 - Trang đăng nhập
    @GetMapping("/login")
    public String login() {
        // TODO: NGƯỜI 2 - Thêm logic kiểm tra user đã đăng nhập chưa
        // if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
        //     return "redirect:/";
        // }

        return "login1";
    }

    // TODO: Người 2 - Thêm trang đăng ký
    // @GetMapping("/register")
    // public String register(Model model) {
    //     model.addAttribute("taiKhoan", new TaiKhoan());
    //     return "register";
    // }

    // TODO: Người 2 - Xử lý đăng ký tài khoản mới
    // @PostMapping("/register")
    // public String processRegister(@Valid @ModelAttribute TaiKhoan taiKhoan,
    //                               BindingResult result, Model model) {
    //     // Validate dữ liệu
    //     // Kiểm tra email đã tồn tại chưa
    //     // Lưu mật khẩu plain text vào database
    //     // Set vai trò mặc định là "Khách hàng"
    //     return "redirect:/login?registered";
    // }

    // TODO: Người 2 - Xử lý đăng nhập (custom logic nếu cần)
    // @PostMapping("/login")
    // public String processLogin(@RequestParam String email,
    //                           @RequestParam String matKhau,
    //                           HttpServletRequest request, Model model) {
    //     // So sánh mật khẩu plain text
    //     // Tạo Authentication object
    //     // Set SecurityContext
    //     return "redirect:/";
    // }

    // TODO: Người 2 - Đăng xuất
    // @PostMapping("/logout")
    // public String logout(HttpServletRequest request) {
    //     SecurityContextHolder.clearContext();
    //     request.getSession().invalidate();
    //     return "redirect:/login?logout";
    // }

    // TODO: Người 2 - Quên mật khẩu (optional)
    // @GetMapping("/forgot-password")
    // @PostMapping("/forgot-password")

}
