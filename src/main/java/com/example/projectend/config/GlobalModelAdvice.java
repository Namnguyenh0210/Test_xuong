package com.example.projectend.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import java.time.LocalDate;

/**
 * GLOBAL MODEL ADVICE
 * Người 1 - Core System
 * Thêm các biến model dùng chung cho tất cả template (currentYear, tetYear ...)
 *
 * TODO NGƯỜI 2: Thêm model attribute "currentUser" sau khi hoàn thiện auth.
 * TODO NGƯỜI 3: Thêm preload danh mục sản phẩm (categories) nếu cần cho mọi trang.
 * TODO NGƯỜI 5: Có thể inject số liệu thống kê nhanh (hôm nay) cho header (optional).
 */
@ControllerAdvice
public class GlobalModelAdvice {

    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        int currentYear = LocalDate.now().getYear();
        model.addAttribute("currentYear", currentYear);
        model.addAttribute("tetYear", currentYear); // Tết Nguyên Đán 2025
    }
}
