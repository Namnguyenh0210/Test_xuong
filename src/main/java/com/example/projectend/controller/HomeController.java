package com.example.projectend.controller;

import com.example.projectend.service.DateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HOME CONTROLLER - Trang chủ website bán đồ Tết
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * Người 3 - Frontend & Customer Website (CẦN HOÀN THIỆN THEO TODO)
 *
 * TODO (Người 3) Feature backlog:
 *  1. Inject SanPhamService & LoaiSanPhamService khi đã tạo service layer
 *  2. Lấy danh sách sản phẩm nổi bật (top n bán chạy) -> model.addAttribute("featuredProducts", ...)
 *  3. Lấy danh sách sản phẩm mới nhất -> model.addAttribute("newProducts", ...)
 *  4. Hiển thị danh mục sản phẩm cho mega menu / filter -> model.addAttribute("categories", ...)
 *  5. Thêm banner/slider (model.addAttribute("banners", ...))
 *  6. Tối ưu SEO: thêm model.addAttribute("metaDescription", ...) nếu cần override
 *  7. Cache tạm thời (Spring Cache) cho dữ liệu ít thay đổi (danh mục, bestseller)
 *  8. Thêm section thống kê mini (tổng SP, khách hàng) nếu có logic
 */
@Controller
public class HomeController {

    private final DateService dateService; // Dùng lại cho các logic ngày tháng nếu cần (future)

    public HomeController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("currentPage", "home");
        // currentYear & tetYear đã được thêm global ở GlobalModelAdvice -> không cần set lại ở đây
        // TODO (Người 3): Sau khi có service sản phẩm, thay placeholder dữ liệu dưới.

        // ============= PLACEHOLDER DATA (Người 3 sẽ thay) =============
        // model.addAttribute("featuredProducts", sanPhamService.getFeaturedProducts(6));
        // model.addAttribute("newProducts", sanPhamService.getNewestProducts(6));
        // model.addAttribute("categories", loaiSanPhamService.getAll());
        // model.addAttribute("banners", bannerService.getActive());
        // ==============================================================

        model.addAttribute("pageTitle", "Trang chủ - Cửa hàng đồ Tết");
        return "home";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        return home(model);
    }
}
