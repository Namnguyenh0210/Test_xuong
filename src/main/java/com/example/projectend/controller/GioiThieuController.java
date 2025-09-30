package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * GIOI THIEU CONTROLLER - Trang giới thiệu
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * TODO: Người 3 - Frontend & Customer Website (Hoàn thiện tính năng)
 */
@Controller
public class GioiThieuController {

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website
    // ========================================

    // TODO: NGƯỜI 3 - Inject các service nếu cần (có thể lấy thống kê)
    // @Autowired private SanPhamService sanPhamService;
    // @Autowired private DonHangService donHangService;

    @GetMapping("/gioithieu")
    public String gioiThieu(Model model) {
        // TODO: NGƯỜI 3 - Thêm nội dung giới thiệu về cửa hàng
        // model.addAttribute("companyInfo", "Thông tin về cửa hàng đồ Tết");
        // model.addAttribute("mission", "Sứ mệnh của cửa hàng");
        // model.addAttribute("vision", "Tầm nhìn phát triển");

        // TODO: NGƯỜI 3 - Thêm một số thống kê ấn tượng (optional)
        // Long totalProducts = sanPhamService.countAllProducts();
        // Long totalOrders = donHangService.countAllOrders();
        // model.addAttribute("totalProducts", totalProducts);
        // model.addAttribute("totalOrders", totalOrders);

        // TODO: NGƯỜI 3 - Thêm thông tin đội ngũ (optional)
        // model.addAttribute("teamMembers", teamService.getAllMembers());

        // TODO: NGƯỜI 3 - Thêm timeline lịch sử phát triển (optional)
        // model.addAttribute("milestones", milestoneService.getAllMilestones());

        model.addAttribute("pageTitle", "Giới thiệu - Cửa hàng đồ Tết");
        return "gioithieu";
    }

    // TODO: NGƯỜI 3 - Thêm trang về chính sách (optional)
    // @GetMapping("/chinh-sach")
    // public String chinhSach(Model model) {
    //     model.addAttribute("pageTitle", "Chính sách - Cửa hàng đồ Tết");
    //     return "chinh-sach";
    // }

    // TODO: NGƯỜI 3 - Thêm trang điều khoản sử dụng (optional)
    // @GetMapping("/dieu-khoan")
    // public String dieuKhoan(Model model) {
    //     model.addAttribute("pageTitle", "Điều khoản sử dụng");
    //     return "dieu-khoan";
    // }
}
