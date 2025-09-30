package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * GIO HANG CONTROLLER - Quản lý giỏ hàng
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * TODO: Người 3 - Frontend & Customer Website (Hoàn thiện tính năng)
 */
@Controller
public class GioHangController {

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website
    // ========================================

    // TODO: NGƯỜI 3 - Inject các service cần thiết
    // @Autowired private GioHangService gioHangService;
    // @Autowired private SanPhamService sanPhamService;
    // @Autowired private DonHangService donHangService;

    // TODO: Người 3 - Trang giỏ hàng
    @GetMapping("/giohang")
    public String gioHang(Model model) {
        // TODO: NGƯỜI 3 - Lấy user đang đăng nhập
        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // String email = auth.getName();
        // TaiKhoan currentUser = taiKhoanService.findByEmail(email);

        // TODO: NGƯỜI 3 - Lấy giỏ hàng của user hiện tại
        // List<GioHang> gioHangItems = gioHangService.getCartItems(currentUser);
        // model.addAttribute("gioHangItems", gioHangItems);

        // TODO: NGƯỜI 3 - Tính tổng tiền giỏ hàng
        // BigDecimal totalAmount = gioHangService.calculateTotal(currentUser);
        // model.addAttribute("totalAmount", totalAmount);

        // TODO: NGƯỜI 3 - Đếm số lượng items trong giỏ
        // Long itemCount = gioHangService.countItems(currentUser);
        // model.addAttribute("itemCount", itemCount);

        model.addAttribute("pageTitle", "Giỏ hàng - Cửa hàng đồ Tết");
        return "giohang";
    }

    // TODO: NGƯỜI 3 - Thêm sản phẩm vào giỏ hàng
    // @PostMapping("/giohang/add")
    // @ResponseBody
    // public ResponseEntity<?> themVaoGioHang(@RequestParam Integer sanPhamId,
    //                                         @RequestParam(defaultValue = "1") Integer soLuong) {
    //     try {
    //         // Lấy current user
    //         // Kiểm tra sản phẩm tồn tại và còn hàng
    //         // Thêm vào giỏ hàng hoặc cập nhật số lượng
    //         return ResponseEntity.ok(Map.of("success", true, "message", "Đã thêm vào giỏ hàng"));
    //     } catch (Exception e) {
    //         return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage()));
    //     }
    // }

    // TODO: NGƯỜI 3 - Cập nhật số lượng sản phẩm trong giỏ
    // @PostMapping("/giohang/update")
    // @ResponseBody
    // public ResponseEntity<?> capNhatGioHang(@RequestParam Integer gioHangId,
    //                                         @RequestParam Integer soLuong) {
    //     // Logic cập nhật số lượng
    //     return ResponseEntity.ok(Map.of("success", true));
    // }

    // TODO: NGƯỜI 3 - Xóa sản phẩm khỏi giỏ hàng
    // @PostMapping("/giohang/remove")
    // @ResponseBody
    // public ResponseEntity<?> xoaKhoiGioHang(@RequestParam Integer gioHangId) {
    //     // Logic xóa sản phẩm
    //     return ResponseEntity.ok(Map.of("success", true));
    // }

    // TODO: NGƯỜI 3 - Trang checkout
    // @GetMapping("/checkout")
    // public String checkout(Model model) {
    //     // Lấy giỏ hàng và tính tổng tiền
    //     // Lấy danh sách địa chỉ của user
    //     // Lấy danh sách phương thức thanh toán
    //     return "checkout";
    // }

    // TODO: NGƯỜI 3 - Xử lý đặt hàng
    // @PostMapping("/checkout")
    // public String datHang(@Valid @ModelAttribute DonHangForm donHangForm,
    //                       BindingResult result, Model model) {
    //     // Validate dữ liệu đơn hàng
    //     // Tạo đơn hàng mới
    //     // Chuyển giỏ hàng thành chi tiết đơn hàng
    //     // Xóa giỏ hàng sau khi đặt hàng thành công
    //     return "redirect:/don-hang/" + donHang.getMaDH();
    // }

}
