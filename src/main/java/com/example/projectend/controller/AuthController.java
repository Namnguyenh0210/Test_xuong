package com.example.projectend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * AUTH CONTROLLER - Bạn C hoàn thiện
 * TODO:
 * 1. Implement login/register logic
 * 2. Thêm session management 
 * 3. Integration với SecurityConfig
 * 4. Handle login errors và success messages
 */
@Controller
public class AuthController {
    
    // TODO: Inject UserService khi Bạn B tạo xong
    
    // TODO: Custom login page
    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        
        // TODO: Handle error messages
        if (error != null) {
            model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng!");
        }
        
        // TODO: Handle logout message
        if (logout != null) {
            model.addAttribute("logoutMessage", "Đăng xuất thành công!");
        }
        
        return "login1"; // Sử dụng template login1.html hiện có
    }
    
    // TODO: Register page
    @GetMapping("/register")
    public String registerPage() {
        // TODO: Tạo template register.html
        return "register";
    }
    
    // TODO: Handle register form submission
    @PostMapping("/register")
    public String handleRegister(@RequestParam String username,
                                @RequestParam String email,
                                @RequestParam String password,
                                @RequestParam String confirmPassword,
                                RedirectAttributes redirectAttributes) {
        
        // TODO: Validate input data
        // TODO: Check password confirmation
        // TODO: Check user không tồn tại
        // TODO: Create new user với UserService
        // TODO: Redirect với success message
        
        redirectAttributes.addFlashAttribute("message", "Đăng ký thành công! Vui lòng đăng nhập.");
        return "redirect:/login";
    }
    
    // TODO: Handle session management
    @GetMapping("/api/auth/status")
    public String getAuthStatus(HttpSession session, Model model) {
        // TODO: Check user login status
        // TODO: Return JSON response cho JavaScript
        boolean isAuthenticated = session.getAttribute("user") != null;
        
        model.addAttribute("isAuthenticated", isAuthenticated);
        return "json/auth-status"; // Template trả JSON
    }
    
    // TODO: Custom logout handling (nếu cần)
    @PostMapping("/logout")
    public String handleLogout(HttpSession session, RedirectAttributes redirectAttributes) {
        // TODO: Custom logout logic
        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "Đăng xuất thành công!");
        return "redirect:/";
    }
}
