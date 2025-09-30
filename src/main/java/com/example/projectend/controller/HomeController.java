package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HOME CONTROLLER - Trang chủ website bán đồ Tết
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * TODO: Người 3 - Frontend & Customer Website (Hoàn thiện tính năng)
 */
@Controller
public class HomeController {

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website
    // ========================================

    @GetMapping("/")
    public String home(Model model) {
        // TODO: NGƯỜI 3 - Inject SanPhamService và LoaiSanPhamService
        // @Autowired private SanPhamService sanPhamService;
        // @Autowired private LoaiSanPhamService loaiSanPhamService;

        // TODO: NGƯỜI 3 - Lấy sản phẩm nổi bật (top 6 sản phẩm bán chạy)
        // List<SanPham> featuredProducts = sanPhamService.getFeaturedProducts(6);
        // model.addAttribute("featuredProducts", featuredProducts);

        // TODO: NGƯỜI 3 - Lấy sản phẩm mới nhất (6 sản phẩm mới nhất)
        // List<SanPham> newProducts = sanPhamService.getNewestProducts(6);
        // model.addAttribute("newProducts", newProducts);

        // TODO: NGƯỜI 3 - Lấy tất cả danh mục để hiển thị menu
        // List<LoaiSanPham> categories = loaiSanPhamService.getAllCategories();
        // model.addAttribute("categories", categories);

        // TODO: NGƯỜI 3 - Thêm banner/slider cho trang chủ
        // model.addAttribute("banners", bannerService.getActiveBanners());

        model.addAttribute("pageTitle", "Trang chủ - Cửa hàng đồ Tết");
        return "home";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        return home(model);
    }
}
