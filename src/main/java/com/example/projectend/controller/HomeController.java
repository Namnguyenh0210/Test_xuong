package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HOME CONTROLLER - Trang chủ website bán đồ Tết
 * Người 1 - Database Design & Backend Core ✅ ĐÃ HOÀN THÀNH (Cấu trúc cơ bản)
 * Người 3 - Frontend & Customer Website 🔄 CẦN HOÀN THIỆN
 * <p>
 * ========================================
 * TODO NGƯỜI 3 - DANH SÁCH CHI TIẾT:
 * ========================================
 * <p>
 * BƯỚC 1: Inject Services (sau khi đã tạo)
 *
 * @Autowired private SanPhamService sanPhamService;
 * @Autowired private BaiVietService baiVietService;
 * <p>
 * BƯỚC 2: Trong method home() - thêm logic:
 * - Lấy 4 sản phẩm nổi bật: model.addAttribute("featuredProducts", sanPhamService.getFeaturedProducts(4));
 * - Lấy 3 bài viết mới nhất: model.addAttribute("featuredPosts", baiVietService.getFeaturedPosts(3));
 * - Lấy danh mục sản phẩm: model.addAttribute("categories", sanPhamService.getAllCategories());
 * <p>
 * BƯỚC 3: Cập nhật home.html template:
 * - Thêm slider banner Tết 2025
 * - Grid hiển thị 4 sản phẩm nổi bật
 * - Section 3 bài viết kiến thức mới nhất
 * - Footer với thông tin liên hệ
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("currentPage", "home");

        // TODO NGƯỜI 3: Thêm các dòng sau khi đã tạo SanPhamService và BaiVietService
        // List<SanPham> featuredProducts = sanPhamService.getFeaturedProducts(4);
        // model.addAttribute("featuredProducts", featuredProducts);

        // List<BaiViet> featuredPosts = baiVietService.getFeaturedPosts(3);
        // model.addAttribute("featuredPosts", featuredPosts);

        // List<LoaiSanPham> categories = sanPhamService.getAllCategories();
        // model.addAttribute("categories", categories);

        model.addAttribute("pageTitle", "Trang chủ - Cửa hàng đồ Tết Nguyên Đán 2025");
        return "home";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        return home(model);
    }
}
