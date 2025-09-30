package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        model.addAttribute("pageTitle", "Kiến thức Tết - Văn hóa truyền thống");
        return "kienthuc";
    }

    // TODO: NGƯỜI 3 - Chi tiết bài viết
    // @GetMapping("/kienthuc/{id}")
    // public String chiTietBaiViet(@PathVariable Integer id, Model model) {
    //     BaiViet baiViet = baiVietService.findById(id);
    //     if (baiViet == null) {
    //         return "redirect:/kienthuc?notfound";
    //     }
    //
    //     // Tăng lượt xem
    //     baiVietService.increaseViewCount(id);
    //
    //     // Lấy bài viết liên quan
    //     List<BaiViet> relatedPosts = baiVietService.getRelatedPosts(baiViet.getTags(), 4);
    //
    //     model.addAttribute("baiViet", baiViet);
    //     model.addAttribute("relatedPosts", relatedPosts);
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
