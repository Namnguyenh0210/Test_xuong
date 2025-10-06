package com.example.projectend.controller;

import org.springframework.web.bind.annotation.*;

/**
 * API CONTROLLER - ASM WEB BÁN HÀNG TẾT
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * TODO: Người 3,4,5 - Phát triển các API endpoints theo chuyên môn
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website APIs
    // ========================================

    // TODO: NGƯỜI 3 - API lấy danh sách sản phẩm (có search, pagination)
    // @GetMapping("/products")
    // public ResponseEntity<Page<SanPham>> getProducts(
    //         @RequestParam(defaultValue = "0") int page,
    //         @RequestParam(defaultValue = "12") int size,
    //         @RequestParam(required = false) String keyword) {
    //     // Logic tìm kiếm sản phẩm theo tên
    //     // Phân trang 12 sản phẩm/trang
    // }

    // TODO: NGƯỜI 3 - API chi tiết sản phẩm
    // @GetMapping("/products/{id}")
    // public ResponseEntity<SanPham> getProductById(@PathVariable Integer id) {
    //     // Lấy thông tin chi tiết sản phẩm
    // }

    // TODO: NGƯỜI 3 - API lấy danh mục sản phẩm
    // @GetMapping("/categories")
    // public ResponseEntity<List<LoaiSanPham>> getCategories() {
    //     // Lấy tất cả danh mục để hiển thị menu
    // }

    // TODO: NGƯỜI 3 - API giỏ hàng - Thêm sản phẩm
    // @PostMapping("/cart/add")
    // public ResponseEntity<?> addToCart(@RequestParam Integer productId,
    //                                   @RequestParam Integer quantity) {
    //     // Thêm sản phẩm vào giỏ hàng
    //     // Kiểm tra số lượng tồn kho
    // }

    // TODO: NGƯỜI 3 - API giỏ hàng - Xem giỏ hàng
    // @GetMapping("/cart")
    // public ResponseEntity<List<GioHang>> getCart() {
    //     // Lấy giỏ hàng của user hiện tại
    // }

    // TODO: NGƯỜI 3 - API đặt hàng đơn giản
    // @PostMapping("/orders")
    // public ResponseEntity<?> createOrder(@RequestParam String diaChiGiaoHang,
    //                                     @RequestParam String ghiChu) {
    //     // Tạo đơn hàng từ giỏ hàng
    //     // Trạng thái mặc định: "Chờ xác nhận"
    // }

    // ========================================
    // TODO: NGƯỜI 4 - Admin Panel & Product Management APIs
    // ========================================

    // TODO: NGƯỜI 4 - API quản lý sản phẩm - Lấy danh sách
    // @GetMapping("/admin/products")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<List<SanPham>> getAllProducts() {
    //     // Lấy tất cả sản phẩm cho admin
    // }

    // TODO: NGƯỜI 4 - API quản lý sản phẩm - Thêm mới
    // @PostMapping("/admin/products")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> createProduct(@RequestBody SanPham sanPham) {
    //     // Thêm sản phẩm mới
    // }

    // TODO: NGƯỜI 4 - API quản lý sản phẩm - Cập nhật
    // @PutMapping("/admin/products/{id}")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> updateProduct(@PathVariable Integer id,
    //                                       @RequestBody SanPham sanPham) {
    //     // Cập nhật thông tin sản phẩm
    // }

    // TODO: NGƯỜI 4 - API quản lý đơn hàng
    // @GetMapping("/admin/orders")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<List<DonHang>> getAllOrders() {
    //     // Lấy tất cả đơn hàng
    // }

    // TODO: NGƯỜI 4 - API cập nhật trạng thái đơn hàng
    // @PutMapping("/admin/orders/{id}/status")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> updateOrderStatus(@PathVariable Integer id,
    //                                           @RequestParam String trangThai) {
    //     // Cập nhật trạng thái: Chờ xác nhận → Đang giao → Hoàn thành
    // }

    // ========================================
    // TODO: NGƯỜI 5 - Reports & Analytics APIs (ĐƠN GIẢN)
    // ========================================

    // TODO: NGƯỜI 5 - API thống kê cơ bản
    // @GetMapping("/admin/stats")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> getBasicStats() {
    //     // Thống kê: Tổng sản phẩm, đơn hàng, doanh thu
    // }

    // TODO: NGƯỜI 5 - API sản phẩm bán chạy
    // @GetMapping("/admin/top-products")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> getTopProducts() {
    //     // Top 10 sản phẩm bán chạy nhất
    // }

    // TODO: NGƯỜI 5 - API doanh thu theo tháng (đơn giản)
    // @GetMapping("/admin/revenue-monthly")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> getMonthlyRevenue() {
    //     // Doanh thu 12 tháng gần nhất
    // }
}
