package com.example.projectend.controller;

import org.springframework.web.bind.annotation.*;

/**
 * API CONTROLLER - REST API endpoints
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * TODO: Người 2,3,4,5 - Phát triển các API endpoints theo chuyên môn
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    // ========================================
    // TODO: NGƯỜI 2 - Authentication & Authorization APIs
    // ========================================

    // TODO: NGƯỜI 2 - API đăng nhập (plain text password)
    // @PostMapping("/login")
    // public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    //     // Xác thực email + mật khẩu plain text
    //     // Tạo JWT token hoặc session
    //     // Return user info + token
    // }

    // TODO: NGƯỜI 2 - API đăng ký tài khoản mới
    // @PostMapping("/register")
    // public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
    //     // Validate dữ liệu đăng ký
    //     // Kiểm tra email đã tồn tại chưa
    //     // Lưu mật khẩu plain text vào database
    //     // Set vai trò mặc định là "Khách hàng"
    // }

    // TODO: NGƯỜI 2 - API refresh token
    // @PostMapping("/refresh-token")

    // TODO: NGƯỜI 2 - API đăng xuất
    // @PostMapping("/logout")

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website APIs
    // ========================================

    // TODO: NGƯỜI 3 - API lấy danh sách sản phẩm (có filter, search, pagination)
    // @GetMapping("/products")
    // public ResponseEntity<Page<SanPham>> getProducts(
    //         @RequestParam(defaultValue = "0") int page,
    //         @RequestParam(defaultValue = "12") int size,
    //         @RequestParam(required = false) Integer categoryId,
    //         @RequestParam(required = false) String keyword,
    //         @RequestParam(required = false) BigDecimal minPrice,
    //         @RequestParam(required = false) BigDecimal maxPrice) {
    //     // Logic tìm kiếm và lọc sản phẩm
    // }

    // TODO: NGƯỜI 3 - API chi tiết sản phẩm
    // @GetMapping("/products/{id}")
    // public ResponseEntity<SanPham> getProductById(@PathVariable Integer id) {
    //     // Lấy thông tin chi tiết sản phẩm
    //     // Tăng lượt xem
    // }

    // TODO: NGƯỜI 3 - API lấy danh mục sản phẩm
    // @GetMapping("/categories")
    // public ResponseEntity<List<LoaiSanPham>> getCategories() {
    //     // Lấy tất cả danh mục để hiển thị menu
    // }

    // TODO: NGƯỜI 3 - API giỏ hàng - Lấy giỏ hàng
    // @GetMapping("/cart")
    // public ResponseEntity<List<GioHang>> getCart() {
    //     // Lấy giỏ hàng của user hiện tại
    // }

    // TODO: NGƯỜI 3 - API giỏ hàng - Thêm sản phẩm
    // @PostMapping("/cart/add")
    // public ResponseEntity<?> addToCart(@RequestBody AddToCartRequest request) {
    //     // Thêm sản phẩm vào giỏ hàng
    //     // Kiểm tra số lượng tồn kho
    // }

    // TODO: NGƯỜI 3 - API giỏ hàng - Cập nhật số lượng
    // @PutMapping("/cart/update")
    // public ResponseEntity<?> updateCart(@RequestBody UpdateCartRequest request) {
    //     // Cập nhật số lượng sản phẩm trong giỏ
    // }

    // TODO: NGƯỜI 3 - API giỏ hàng - Xóa sản phẩm
    // @DeleteMapping("/cart/remove/{itemId}")
    // public ResponseEntity<?> removeFromCart(@PathVariable Integer itemId) {
    //     // Xóa sản phẩm khỏi giỏ hàng
    // }

    // TODO: NGƯỜI 3 - API đặt hàng
    // @PostMapping("/orders")
    // public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {
    //     // Tạo đơn hàng từ giỏ hàng
    //     // Chuyển trạng thái sang "Chờ xác nhận"
    // }

    // ========================================
    // TODO: NGƯỜI 4 - Admin Panel & Product Management APIs
    // ========================================

    // TODO: NGƯỜI 4 - API admin dashboard statistics
    // @GetMapping("/admin/dashboard")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> getDashboardStats() {
    //     // Thống kê tổng quan: số sản phẩm, đơn hàng, doanh thu
    // }

    // TODO: NGƯỜI 4 - API quản lý sản phẩm - CRUD
    // @GetMapping("/admin/products")
    // @PostMapping("/admin/products")
    // @PutMapping("/admin/products/{id}")
    // @DeleteMapping("/admin/products/{id}")
    // @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF')")

    // TODO: NGƯỜI 4 - API upload hình ảnh sản phẩm
    // @PostMapping("/admin/products/upload-image")
    // @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF')")
    // public ResponseEntity<?> uploadProductImage(@RequestParam("file") MultipartFile file) {
    //     // Upload và lưu hình ảnh sản phẩm
    // }

    // TODO: NGƯỜI 4 - API quản lý đơn hàng
    // @GetMapping("/admin/orders")
    // @PutMapping("/admin/orders/{id}/status")
    // @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF')")

    // TODO: NGƯỜI 4 - API quản lý người dùng
    // @GetMapping("/admin/users")
    // @PutMapping("/admin/users/{id}/status")
    // @PreAuthorize("hasRole('ADMIN')")

    // ========================================
    // TODO: NGƯỜI 5 - Reports & Analytics APIs
    // ========================================

    // TODO: NGƯỜI 5 - API báo cáo doanh thu theo thời gian
    // @GetMapping("/reports/revenue")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> getRevenueReport(
    //         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
    //         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
    //     // Báo cáo doanh thu theo ngày/tháng/quý
    // }

    // TODO: NGƯỜI 5 - API thống kê sản phẩm bán chạy
    // @GetMapping("/reports/top-products")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> getTopSellingProducts(
    //         @RequestParam(defaultValue = "10") int limit) {
    //     // Top sản phẩm bán chạy nhất
    // }

    // TODO: NGƯỜI 5 - API phân tích khách hàng
    // @GetMapping("/reports/customer-analytics")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> getCustomerAnalytics() {
    //     // Phân tích hành vi khách hàng, top khách hàng VIP
    // }

    // TODO: NGƯỜI 5 - API export báo cáo Excel
    // @GetMapping("/reports/export/excel")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<Resource> exportExcelReport(
    //         @RequestParam String reportType,
    //         @RequestParam LocalDate startDate,
    //         @RequestParam LocalDate endDate) {
    //     // Export báo cáo ra file Excel
    // }

    // TODO: NGƯỜI 5 - API thống kê theo thời gian thực
    // @GetMapping("/reports/realtime-stats")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> getRealtimeStats() {
    //     // Thống kê real-time: đơn hàng hôm nay, doanh thu, sản phẩm hot
    // }

}
