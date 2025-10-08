package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CHECKOUT CONTROLLER - Xử lý đặt hàng và thanh toán
 * Người 4 - Order Management & Checkout 🔄 CẦN HOÀN THIỆN
 * <p>
 * ========================================
 * TODO NGƯỜI 4 - DANH SÁCH CHI TIẾT:
 * ========================================
 * <p>
 * BƯỚC 1: Inject Services cần thiết
 *
 * @Autowired private GioHangService gioHangService;
 * @Autowired private DonHangService donHangService;
 * @Autowired private TaiKhoanService taiKhoanService;
 * @Autowired private DiaChiService diaChiService;
 * @Autowired private PhuongThucThanhToanService phuongThucThanhToanService;
 * <p>
 * BƯỚC 2: Hoàn thiện method checkout() - hiển thị trang thanh toán
 * BƯỚC 3: Hoàn thiện method processCheckout() - xử lý đặt hàng
 * BƯỚC 4: Tạo method checkoutSuccess() - trang cảm ơn
 * BƯỚC 5: Cập nhật template checkout.html và checkout-success.html
 * BƯỚC 6: Thêm validation form và tính phí ship
 */
@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    // TODO NGƯỜI 4: Inject các service sau khi đã tạo
    // @Autowired private GioHangService gioHangService;
    // @Autowired private DonHangService donHangService;
    // @Autowired private TaiKhoanService taiKhoanService;
    // @Autowired private DiaChiService diaChiService;
    // @Autowired private PhuongThucThanhToanService phuongThucThanhToanService;

    // Trang checkout - hiển thị form đặt hàng
    @GetMapping("")
    public String checkout(Model model, Principal principal) {

        // TODO NGƯỜI 4: Thêm logic sau khi có service
        // if (principal == null) {
        //     return "redirect:/login?checkout";
        // }

        // TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        // List<GioHang> gioHangItems = gioHangService.getGioHangByTaiKhoan(taiKhoan);

        // if (gioHangItems.isEmpty()) {
        //     return "redirect:/giohang?empty";
        // }

        // model.addAttribute("taiKhoan", taiKhoan);
        // model.addAttribute("gioHangItems", gioHangItems);

        // BigDecimal tongTien = gioHangService.tinhTongTien(gioHangItems);
        // BigDecimal phiShip = donHangService.tinhPhiShip(tongTien);
        // BigDecimal tongThanhToan = tongTien.add(phiShip);

        // model.addAttribute("tongTien", tongTien);
        // model.addAttribute("phiShip", phiShip);
        // model.addAttribute("tongThanhToan", tongThanhToan);

        // // Lấy địa chỉ giao hàng
        // List<DiaChi> diaChiList = diaChiService.getDiaChiByTaiKhoan(taiKhoan);
        // model.addAttribute("diaChiList", diaChiList);

        // // Lấy phương thức thanh toán
        // List<PhuongThucThanhToan> phuongThucList = phuongThucThanhToanService.findAll();
        // model.addAttribute("phuongThucList", phuongThucList);

        // Breadcrumb
        Map<String, String> breadcrumb1 = new HashMap<>();
        breadcrumb1.put("name", "Giỏ hàng");
        breadcrumb1.put("url", "/giohang");

        Map<String, String> breadcrumb2 = new HashMap<>();
        breadcrumb2.put("name", "Thanh toán");
        breadcrumb2.put("url", null);

        List<Map<String, String>> breadcrumbItems = List.of(breadcrumb1, breadcrumb2);
        model.addAttribute("breadcrumbItems", breadcrumbItems);

        model.addAttribute("currentPage", "checkout");
        model.addAttribute("pageTitle", "Thanh toán - Cửa hàng đồ Tết");
        return "checkout";
    }

    // Xử lý đặt hàng
    @PostMapping("/process")
    public String processCheckout(
            @RequestParam Integer diaChiId,
            @RequestParam Integer phuongThucThanhToanId,
            @RequestParam(required = false) String ghiChu,
            Principal principal,
            RedirectAttributes redirectAttributes) {

        // TODO NGƯỜI 4: Implement logic đặt hàng
        // try {
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //     List<GioHang> gioHangItems = gioHangService.getGioHangByTaiKhoan(taiKhoan);
        //
        //     if (gioHangItems.isEmpty()) {
        //         redirectAttributes.addFlashAttribute("error", "Giỏ hàng trống!");
        //         return "redirect:/giohang";
        //     }
        //
        //     // Kiểm tra tồn kho trước khi đặt hàng
        //     for (GioHang item : gioHangItems) {
        //         if (item.getSanPham().getSoLuong() < item.getSoLuong()) {
        //             redirectAttributes.addFlashAttribute("error",
        //                 "Sản phẩm " + item.getSanPham().getTenSP() + " không đủ số lượng!");
        //             return "redirect:/checkout";
        //         }
        //     }
        //
        //     // Tạo đơn hàng
        //     DonHang donHang = donHangService.createDonHang(taiKhoan, diaChiId, phuongThucThanhToanId, gioHangItems, ghiChu);
        //
        //     // Xóa giỏ hàng sau khi đặt thành công
        //     gioHangService.clearGioHang(taiKhoan);
        //
        //     redirectAttributes.addFlashAttribute("success", "Đặt hàng thành công!");
        //     return "redirect:/checkout/success/" + donHang.getMaDH();
        //
        // } catch (Exception e) {
        //     redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
        //     return "redirect:/checkout";
        // }

        return "redirect:/checkout?todo";
    }

    // Trang cảm ơn sau khi đặt hàng thành công
    @GetMapping("/success/{donHangId}")
    public String checkoutSuccess(@PathVariable Integer donHangId, Model model, Principal principal) {

        // TODO NGƯỜI 4: Implement logic
        // try {
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //     Optional<DonHang> donHangOpt = donHangService.findByIdAndKhachHang(donHangId, taiKhoan);
        //
        //     if (donHangOpt.isEmpty()) {
        //         return "redirect:/profile";
        //     }
        //
        //     DonHang donHang = donHangOpt.get();
        //     model.addAttribute("donHang", donHang);
        //
        //     // Lấy chi tiết đơn hàng
        //     List<DonHangChiTiet> chiTietList = donHangService.getChiTietDonHang(donHang);
        //     model.addAttribute("chiTietList", chiTietList);
        // } catch (Exception e) {
        //     return "redirect:/profile?error";
        // }

        model.addAttribute("currentPage", "checkout");
        model.addAttribute("pageTitle", "Đặt hàng thành công - Cửa hàng đồ Tết");
        return "checkout-success";
    }

    // TODO NGƯỜI 4: API tính phí ship theo địa chỉ (AJAX)
    @GetMapping("/api/shipping-fee")
    @ResponseBody
    public Map<String, Object> calculateShippingFee(@RequestParam Integer diaChiId) {

        // TODO NGƯỜI 4: Implement logic
        // try {
        //     DiaChi diaChi = diaChiService.findById(diaChiId).orElseThrow();
        //     BigDecimal phiShip = donHangService.tinhPhiShipByDiaChi(diaChi);
        //
        //     return Map.of(
        //         "success", true,
        //         "phiShip", phiShip
        //     );
        // } catch (Exception e) {
        //     return Map.of(
        //         "success", false,
        //         "message", e.getMessage()
        //     );
        // }

        return Map.of("success", false, "message", "Chưa implement");
    }

    // TODO NGƯỜI 4: Thêm địa chỉ giao hàng mới (AJAX)
    @PostMapping("/api/address/add")
    @ResponseBody
    public Map<String, Object> addNewAddress(
            @RequestParam String diaChiChiTiet,
            Principal principal) {

        // TODO NGƯỜI 4: Implement logic
        // try {
        //     TaiKhoan taiKhoan = taiKhoanService.findByEmail(principal.getName());
        //
        //     DiaChi diaChi = new DiaChi();
        //     diaChi.setTaiKhoan(taiKhoan);
        //     diaChi.setDiaChiChiTiet(diaChiChiTiet);
        //     diaChi.setMacDinh(false);
        //
        //     DiaChi savedDiaChi = diaChiService.save(diaChi);
        //
        //     return Map.of(
        //         "success", true,
        //         "diaChi", savedDiaChi
        //     );
        // } catch (Exception e) {
        //     return Map.of(
        //         "success", false,
        //         "message", e.getMessage()
        //     );
        // }

        return Map.of("success", false, "message", "Chưa implement");
    }
}
