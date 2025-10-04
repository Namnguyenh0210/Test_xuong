package com.example.projectend.config;

import com.example.projectend.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

/**
 * GLOBAL MODEL ADVICE
 * Người 1 - Core (Bổ sung 03/10/2025)
 * Thêm các biến model dùng chung cho tất cả template (currentYear, tetYear ...)
 *
 * TODO (Người 2): Thêm model attribute "currentUser" sau khi hoàn thiện auth.
 * TODO (Người 3): Thêm preload danh mục sản phẩm (categories) nếu cần cho mọi trang.
 * TODO (Người 5): Có thể inject số liệu thống kê nhanh (hôm nay) cho header (optional).
 */
@ControllerAdvice
public class GlobalModelAdvice {

    private final DateService dateService;

    @Autowired
    public GlobalModelAdvice(DateService dateService) {
        this.dateService = dateService;
    }

    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        model.addAttribute("currentYear", dateService.getCurrentYear());
        model.addAttribute("tetYear", dateService.getTetYear());
        // Placeholder / TODO cho các thuộc tính khác ở trên.
    }
}

