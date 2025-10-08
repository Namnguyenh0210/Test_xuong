package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LIEN HE CONTROLLER - Trang liên hệ
 */
@Controller
public class LienHeController {

    @GetMapping("/lienhe")
    public String lienHe(Model model) {
        // Add current page for navigation active state
        model.addAttribute("currentPage", "lienhe");

        // Add breadcrumb data - using HashMap to allow null values
        Map<String, String> breadcrumbItem = new HashMap<>();
        breadcrumbItem.put("name", "Liên Hệ");
        breadcrumbItem.put("url", null);

        List<Map<String, String>> breadcrumbItems = List.of(breadcrumbItem);
        model.addAttribute("breadcrumbItems", breadcrumbItems);

        // Thông tin liên hệ cửa hàng
        model.addAttribute("shopAddress", "123 Đường ABC, Quận XYZ, TP.HCM");
        model.addAttribute("shopPhone", "0909 123 456");
        model.addAttribute("shopEmail", "contact@tetmarket.com");
        model.addAttribute("shopHours", "8:00 - 22:00 hàng ngày");

        model.addAttribute("pageTitle", "Liên hệ - Cửa hàng đồ Tết");
        model.addAttribute("tetYear", "2025");

        return "lienhe";
    }

    // TODO: NGƯỜI 3 - Xử lý form gửi liên hệ
    // @PostMapping("/lienhe/gui")
    // public String guiLienHe(@Valid @ModelAttribute LienHeForm form,
    //                         BindingResult result,
    //                         RedirectAttributes redirectAttributes) {
    //     if (result.hasErrors()) {
    //         return "lienhe";
    //     }
    //
    //     try {
    //         lienHeService.guiLienHe(form);
    //         redirectAttributes.addFlashAttribute("message", "Gửi liên hệ thành công!");
    //         redirectAttributes.addFlashAttribute("messageType", "success");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("message", "Có lỗi xảy ra, vui lòng thử lại!");
    //         redirectAttributes.addFlashAttribute("messageType", "error");
    //     }
    //
    //     return "redirect:/lienhe";
    // }
}
