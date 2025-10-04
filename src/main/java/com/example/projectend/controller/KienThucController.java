package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * KIEN THUC CONTROLLER - Trang kiến thức về văn hóa Tết
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * TODO: Người 3 - Frontend & Customer Website (Hoàn thiện tính năng)
 */
@Controller
public class KienThucController {

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website
    // ========================================

    // TODO: NGƯỜI 3 - Tạo BaiVietService để quản lý bài viết
    // @Autowired private BaiVietService baiVietService;

    @GetMapping("/kienthuc")
    public String kienThuc(Model model) {
        // Add current page for navigation active state
        model.addAttribute("currentPage", "kienthuc");

        // Add breadcrumb data - using HashMap to allow null values
        Map<String, String> breadcrumbItem = new HashMap<>();
        breadcrumbItem.put("name", "Kiến Thức");
        breadcrumbItem.put("url", null);

        List<Map<String, String>> breadcrumbItems = List.of(breadcrumbItem);
        model.addAttribute("breadcrumbItems", breadcrumbItems);

        // TODO: NGƯỜI 3 - Lấy danh sách bài viết từ database (có phân trang)
        // Pageable pageable = PageRequest.of(page, size);
        // Page<BaiViet> baiVietPage = baiVietService.getAllBaiViet(pageable);
        // model.addAttribute("baiVietPage", baiVietPage);

        // TODO: NGƯỜI 3 - Lấy bài viết nổi bật (có lượt xem cao)
        // List<BaiViet> featuredPosts = baiVietService.getFeaturedPosts(3);
        // model.addAttribute("featuredPosts", featuredPosts);

        // TODO: NGƯỜI 3 - Lấy các tag phổ biến
        // List<String> popularTags = baiVietService.getPopularTags();
        // model.addAttribute("popularTags", popularTags);

        model.addAttribute("pageTitle", "Kiến thức - Cửa hàng đồ Tết");
        model.addAttribute("tetYear", "2025");

        return "kienthuc";
    }

    // TODO: NGƯỜI 3 - Chi tiết bài viết
    // @GetMapping("/kienthuc/{id}")
    // public String chiTietBaiViet(@PathVariable Integer id, Model model) {
    //     BaiViet baiViet = baiVietService.findById(id);
    //     if (baiViet == null) {
    //         return "redirect:/kienthuc?notfound";
    //     }
    //     model.addAttribute("baiViet", baiViet);
    //     return "kienthuc-detail";
    // }

    // TODO: NGƯỜI 3 - Tìm kiếm bài viết theo tag
    // @GetMapping("/kienthuc/tag/{tag}")
    // public String baiVietTheoTag(@PathVariable String tag,
    //                              @RequestParam(defaultValue = "0") int page,
    //                              Model model) {
    //     // Logic tìm bài viết theo tag
    //     return "kienthuc";
    // }

    // TODO: NGƯỜI 3 - Tìm kiếm bài viết
    // @GetMapping("/kienthuc/search")
    // public String timKiemBaiViet(@RequestParam String keyword,
    //                              @RequestParam(defaultValue = "0") int page,
    //                              Model model) {
    //     // Logic tìm kiếm bài viết theo tiêu đề và nội dung
    //     return "kienthuc";
    // }
}
