package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SAN PHAM CONTROLLER - Hiển thị và quản lý sản phẩm
 * Người 1 - Database Design & Backend Core ✅ ĐÃ HOÀN THÀNH (Cấu trúc cơ bản)
 * Người 3 - Frontend & Customer Website 🔄 CẦN HOÀN THIỆN
 * <p>
 * ========================================
 * TODO NGƯỜI 3 - DANH SÁCH CHI TIẾT:
 * ========================================
 * <p>
 * BƯỚC 1: Inject Services cần thiết
 *
 * @Autowired private SanPhamService sanPhamService;
 * @Autowired private LoaiSanPhamService loaiSanPhamService;
 * @Autowired private DanhGiaService danhGiaService;
 * <p>
 * BƯỚC 2: Hoàn thiện method sanPham() - danh sách sản phẩm
 * BƯỚC 3: Hoàn thiện method chiTietSanPham() - chi tiết sản phẩm
 * BƯỚC 4: Thêm method timKiemSanPham() - tìm kiếm
 * BƯỚC 5: Cập nhật template sanpham.html với filter, sort, phân trang
 */
@Controller
public class SanPhamController {

    // TODO NGƯỜI 3: Inject các service sau khi đã tạo
    // @Autowired private SanPhamService sanPhamService;
    // @Autowired private LoaiSanPhamService loaiSanPhamService;
    // @Autowired private DanhGiaService danhGiaService;

    // Danh sách sản phẩm với filter và phân trang
    @GetMapping("/sanpham")
    public String sanPham(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Integer loai,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(defaultValue = "moi") String sort,
            Model model) {

        model.addAttribute("currentPage", "sanpham");

        // TODO NGƯỜI 3: Thêm logic sau khi có service
        // Pageable pageable = PageRequest.of(page, size);
        // Page<SanPham> sanPhamPage = sanPhamService.findWithFilters(search, loai, minPrice, maxPrice, sort, pageable);
        // model.addAttribute("sanPhamPage", sanPhamPage);

        // TODO NGƯỜI 3: Lấy danh mục cho sidebar filter
        // List<LoaiSanPham> categories = loaiSanPhamService.findAll();
        // model.addAttribute("categories", categories);

        // Breadcrumb
        Map<String, String> breadcrumbItem = new HashMap<>();
        breadcrumbItem.put("name", "Sản phẩm");
        breadcrumbItem.put("url", null);
        List<Map<String, String>> breadcrumbItems = List.of(breadcrumbItem);
        model.addAttribute("breadcrumbItems", breadcrumbItems);

        // Giữ lại filter parameters
        model.addAttribute("search", search);
        model.addAttribute("loai", loai);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("sort", sort);

        model.addAttribute("pageTitle", "Sản phẩm - Cửa hàng đồ Tết");
        return "sanpham";
    }

    // Chi tiết sản phẩm
    @GetMapping("/sanpham/{id}")
    public String chiTietSanPham(@PathVariable Integer id, Model model) {

        // TODO NGƯỜI 3: Thêm logic sau khi có service
        // Optional<SanPham> sanPhamOpt = sanPhamService.findById(id);
        // if (sanPhamOpt.isEmpty()) {
        //     return "redirect:/sanpham?notfound";
        // }

        // SanPham sanPham = sanPhamOpt.get();
        // model.addAttribute("sanPham", sanPham);

        // TODO NGƯỜI 3: Lấy sản phẩm liên quan (cùng danh mục)
        // List<SanPham> relatedProducts = sanPhamService.findRelatedProducts(sanPham.getLoaiSanPham().getMaLoai(), sanPham.getMaSP(), 4);
        // model.addAttribute("relatedProducts", relatedProducts);

        // TODO NGƯỜI 3: Lấy đánh giá sản phẩm
        // Page<DanhGia> reviewsPage = danhGiaService.getDanhGiaBySanPham(sanPham, PageRequest.of(0, 5));
        // model.addAttribute("reviewsPage", reviewsPage);

        // TODO NGƯỜI 3: Tính điểm trung bình đánh giá
        // Double avgRating = danhGiaService.getAverageRating(sanPham);
        // Long totalReviews = danhGiaService.countReviews(sanPham);
        // model.addAttribute("avgRating", avgRating);
        // model.addAttribute("totalReviews", totalReviews);

        // Breadcrumb cho chi tiết
        Map<String, String> breadcrumb1 = new HashMap<>();
        breadcrumb1.put("name", "Sản phẩm");
        breadcrumb1.put("url", "/sanpham");

        Map<String, String> breadcrumb2 = new HashMap<>();
        breadcrumb2.put("name", "Chi tiết sản phẩm"); // TODO NGƯỜI 3: Thay bằng sanPham.getTenSP()
        breadcrumb2.put("url", null);

        List<Map<String, String>> breadcrumbItems = List.of(breadcrumb1, breadcrumb2);
        model.addAttribute("breadcrumbItems", breadcrumbItems);

        model.addAttribute("currentPage", "sanpham");
        model.addAttribute("pageTitle", "Chi tiết sản phẩm - Cửa hàng đồ Tết");
        return "sanpham-detail";
    }

    // TODO NGƯỜI 3: Thêm method tìm kiếm nhanh (AJAX)
    // @GetMapping("/api/sanpham/search")
    // @ResponseBody
    // public List<SanPham> searchProducts(@RequestParam String keyword) {
    //     return sanPhamService.searchByKeyword(keyword, 10);
    // }
}
