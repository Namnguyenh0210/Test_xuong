package com.example.projectend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GIO HANG CONTROLLER - Quản lý giỏ hàng
 * Người 1 - Database Design & Backend Core ✅ ĐÃ HOÀN THÀNH (Cấu trúc cơ bản)
 * Người 3 - Frontend & Customer Website 🔄 CẦN HOÀN THIỆN
 * <p>
 * ========================================
 * TODO NGƯỜI 3 - DANH SÁCH CHI TIẾT:
 * ========================================
 * <p>
 * BƯỚC 1: Inject Services cần thiết
 *
 * @Autowired private GioHangService gioHangService;
 * @Autowired private SanPhamService sanPhamService;
 * @Autowired private TaiKhoanService taiKhoanService;
 * <p>
 * BƯỚC 2: Hoàn thiện method gioHang() - hiển thị giỏ hàng
 * BƯỚC 3: Tạo AJAX endpoints cho add/update/remove
 * BƯỚC 4: Cập nhật template giohang.html với JavaScript
 * BƯỚC 5: Thêm validation số lượng, kiểm tra tồn kho
 */
@Controller
public class GioHangController {

    // TODO NGƯỜI 3: Inject các service sau khi đã tạo
    // @Autowired private GioHangService gioHangService;
    // @Autowired private SanPhamService sanPhamService;
    // @Autowired private TaiKhoanService taiKhoanService;

    // Trang giỏ hàng
    @GetMapping("/giohang")
    public String gioHang(Model model, Principal principal) {
        model.addAttribute("currentPage", "giohang");

        // TODO NGƯỜI 3: Thêm logic sau khi có service
        // if (principal != null) {
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //     List<GioHang> gioHangItems = gioHangService.getGioHangByTaiKhoan(taiKhoan);
        //     model.addAttribute("gioHangItems", gioHangItems);
        //
        //     BigDecimal tongTien = gioHangService.tinhTongTien(gioHangItems);
        //     model.addAttribute("tongTien", tongTien);
        // }

        // Breadcrumb
        Map<String, String> breadcrumbItem = new HashMap<>();
        breadcrumbItem.put("name", "Giỏ hàng");
        breadcrumbItem.put("url", null);
        List<Map<String, String>> breadcrumbItems = List.of(breadcrumbItem);
        model.addAttribute("breadcrumbItems", breadcrumbItems);

        model.addAttribute("pageTitle", "Giỏ hàng - Cửa hàng đồ Tết");
        return "giohang";
    }

    // TODO NGƯỜI 3: Thêm sản phẩm vào giỏ hàng (AJAX)
    @PostMapping("/api/giohang/add")
    @ResponseBody
    public ResponseEntity<?> themVaoGioHang(
            @RequestParam Integer sanPhamId,
            @RequestParam(defaultValue = "1") Integer soLuong,
            Principal principal) {

        // TODO NGƯỜI 3: Implement logic
        // try {
        //     if (principal == null) {
        //         return ResponseEntity.status(401).body(Map.of("success", false, "message", "Vui lòng đăng nhập"));
        //     }
        //
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //     SanPham sanPham = sanPhamService.findById(sanPhamId).orElseThrow();
        //
        //     if (sanPham.getSoLuong() < soLuong) {
        //         return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Sản phẩm không đủ số lượng"));
        //     }
        //
        //     gioHangService.themSanPham(taiKhoan, sanPham, soLuong);
        //
        //     // Trả về số lượng items trong giỏ để update badge
        //     int totalItems = gioHangService.countItems(taiKhoan);
        //
        //     return ResponseEntity.ok(Map.of(
        //         "success", true,
        //         "message", "Đã thêm vào giỏ hàng",
        //         "totalItems", totalItems
        //     ));
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage()));
        // }

        return ResponseEntity.ok(Map.of("success", false, "message", "Chưa implement"));
    }

    // TODO NGƯỜI 3: Cập nhật số lượng sản phẩm (AJAX)
    @PostMapping("/api/giohang/update")
    @ResponseBody
    public ResponseEntity<?> capNhatSoLuong(
            @RequestParam Integer sanPhamId,
            @RequestParam Integer soLuong,
            Principal principal) {

        // TODO NGƯỜI 3: Implement logic
        // try {
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //
        //     if (soLuong <= 0) {
        //         gioHangService.xoaSanPham(taiKhoan, sanPhamId);
        //     } else {
        //         gioHangService.capNhatSoLuong(taiKhoan, sanPhamId, soLuong);
        //     }
        //
        //     BigDecimal tongTien = gioHangService.tinhTongTienByTaiKhoan(taiKhoan);
        //
        //     return ResponseEntity.ok(Map.of(
        //         "success", true,
        //         "tongTien", tongTien
        //     ));
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage()));
        // }

        return ResponseEntity.ok(Map.of("success", false, "message", "Chưa implement"));
    }

    // TODO NGƯỜI 3: Xóa sản phẩm khỏi giỏ hàng (AJAX)
    @DeleteMapping("/api/giohang/remove/{sanPhamId}")
    @ResponseBody
    public ResponseEntity<?> xoaSanPham(
            @PathVariable Integer sanPhamId,
            Principal principal) {

        // TODO NGƯỜI 3: Implement logic
        // try {
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //     gioHangService.xoaSanPham(taiKhoan, sanPhamId);
        //
        //     return ResponseEntity.ok(Map.of("success", true, "message", "Đã xóa sản phẩm"));
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage()));
        // }

        return ResponseEntity.ok(Map.of("success", false, "message", "Chưa implement"));
    }

    // TODO NGƯỜI 3: Lấy số lượng items trong giỏ hàng (AJAX - cho header badge)
    @GetMapping("/api/giohang/count")
    @ResponseBody
    public ResponseEntity<?> countItems(Principal principal) {

        // TODO NGƯỜI 3: Implement logic
        // try {
        //     if (principal == null) {
        //         return ResponseEntity.ok(Map.of("count", 0));
        //     }
        //
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //     int count = gioHangService.countItems(taiKhoan);
        //
        //     return ResponseEntity.ok(Map.of("count", count));
        // } catch (Exception e) {
        //     return ResponseEntity.ok(Map.of("count", 0));
        // }

        return ResponseEntity.ok(Map.of("count", 0));
    }
}
