package com.example.projectend.controller;

import com.example.projectend.service.CartService;
import com.example.projectend.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * GIO HANG CONTROLLER - Bạn D hoàn thiện
 * Nhiệm vụ: Tích hợp giohang.js hiện có với backend
 * TODO:
 * 1. KHÔNG SỬA giohang.js - giữ nguyên localStorage logic
 * 2. Thêm form submit cho checkout 
 * 3. Tạo API endpoints để sync với localStorage
 * 4. Test integration giữa JS và backend
 */
@Controller
public class GioHangController {

    @Autowired
    private CartService cartService;
    
    @Autowired  
    private ProductService productService;

    @GetMapping("/giohang")
    public String gioHang(Model model, HttpSession session) {
        model.addAttribute("pageTitle", "Giỏ hàng");
        return "giohang"; // giohang.html với JavaScript hiện có
    }
    
    @PostMapping("/api/cart/sync")
    @ResponseBody
    public String syncCart(@RequestBody String localStorageData, HttpSession session) {
        return "{}"; // placeholder
    }
    
    @GetMapping("/api/cart")
    @ResponseBody  
    public String getCartData(HttpSession session) {
        return "[]"; // placeholder - giohang.js sẽ dùng localStorage
    }
    
    @PostMapping("/giohang/checkout")
    public String checkout(@RequestParam(required = false) String cartData,
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {
        
        redirectAttributes.addFlashAttribute("error", "Giỏ hàng trống hoặc có lỗi!");
        return "redirect:/giohang";
    }
    
    @PostMapping("/giohang/save-for-later")
    public String saveCartForLater(@RequestParam String cartData,
                                  RedirectAttributes redirectAttributes) {
        
        redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập để lưu giỏ hàng!");
        return "redirect:/login";
    }
}
