package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * SAN PHAM CONTROLLER - Hiển thị và quản lý sản phẩm
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * TODO: Người 3 - Frontend & Customer Website (Hoàn thiện tính năng)
 */
@Controller
public class SanPhamController {

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website
    // ========================================

    // TODO: NGƯỜI 3 - Inject các service cần thiết
    // @Autowired private SanPhamService sanPhamService;
    // @Autowired private LoaiSanPhamService loaiSanPhamService;

    // TODO: Người 3 - Trang danh sách sản phẩm
    @GetMapping("/sanpham")
    public String sanPham(Model model) {
        // TODO: NGƯỜI 3 - Lấy danh sách tất cả sản phẩm (có phân trang)
        // Pageable pageable = PageRequest.of(page, size);
        // Page<SanPham> sanPhamPage = sanPhamService.getAllProducts(pageable);
        // model.addAttribute("sanPhamPage", sanPhamPage);

        // TODO: NGƯỜI 3 - Lấy danh sách danh mục để hiển thị filter
        // List<LoaiSanPham> categories = loaiSanPhamService.getAllCategories();
        // model.addAttribute("categories", categories);

        // TODO: NGƯỜI 3 - Thêm tham số lọc (giá, danh mục, tìm kiếm)
        // @RequestParam(required = false) Integer categoryId
        // @RequestParam(required = false) String keyword
        // @RequestParam(required = false) BigDecimal minPrice
        // @RequestParam(required = false) BigDecimal maxPrice

        model.addAttribute("pageTitle", "Sản phẩm - Cửa hàng đồ Tết");
        return "sanpham";
    }

    // TODO: NGƯỜI 3 - Chi tiết sản phẩm
    // @GetMapping("/sanpham/{id}")
    // public String chiTietSanPham(@PathVariable Integer id, Model model) {
    //     SanPham sanPham = sanPhamService.findById(id);
    //     if (sanPham == null) {
    //         return "redirect:/sanpham?notfound";
    //     }
    //
    //     // Lấy sản phẩm liên quan cùng loại
    //     List<SanPham> relatedProducts = sanPhamService.findRelatedProducts(sanPham.getLoaiSanPham(), 4);
    //
    //     model.addAttribute("sanPham", sanPham);
    //     model.addAttribute("relatedProducts", relatedProducts);
    //     return "sanpham-detail";
    // }

    // TODO: NGƯỜI 3 - Sản phẩm theo danh mục
    // @GetMapping("/sanpham/category/{categoryId}")
    // public String sanPhamTheoLoai(@PathVariable Integer categoryId,
    //                               @RequestParam(defaultValue = "0") int page,
    //                               Model model) {
    //     // Logic lọc sản phẩm theo danh mục
    //     return "sanpham";
    // }

    // TODO: NGƯỜI 3 - Tìm kiếm sản phẩm
    // @GetMapping("/sanpham/search")
    // public String timKiemSanPham(@RequestParam String keyword,
    //                              @RequestParam(defaultValue = "0") int page,
    //                              Model model) {
    //     // Logic tìm kiếm sản phẩm
    //     return "sanpham";
    // }

}
