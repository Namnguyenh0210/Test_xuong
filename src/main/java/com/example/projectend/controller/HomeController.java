package com.example.projectend.controller;

import com.example.projectend.service.ProductService;
import com.example.projectend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HOME CONTROLLER - Trang chủ website bán đồ Tết
 * TODO: Người 3 - Frontend & Customer Website
 * Yêu cầu: Hiển thị sản phẩm từ database thay vì dữ liệu mẫu cứng
 */
@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {
        // TODO: Người 3 - Thay thế dữ liệu mẫu bằng dữ liệu từ database

        // Lấy sản phẩm nổi bật (top 6 sản phẩm bán chạy)
        // model.addAttribute("featuredProducts", productService.getFeaturedProducts(6));

        // Lấy sản phẩm mới (6 sản phẩm mới nhất)
        // model.addAttribute("newProducts", productService.getNewestProducts(6));

        // Lấy sản phẩm giảm giá
        // model.addAttribute("discountProducts", productService.getDiscountProducts(6));

        // Lấy tất cả danh mục để hiển thị menu
        // model.addAttribute("categories", categoryService.getAllCategories());

        model.addAttribute("pageTitle", "Trang chủ - Cửa hàng đồ Tết");
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return index(model);
    }
}
