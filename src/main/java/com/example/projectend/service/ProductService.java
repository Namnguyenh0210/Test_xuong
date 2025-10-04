package com.example.projectend.service;

import com.example.projectend.entity.SanPham;
import com.example.projectend.entity.LoaiSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * PRODUCT SERVICE (SanPhamService)
 * Mục tiêu: Bao bọc logic nghiệp vụ sản phẩm, tách khỏi Controller.
 *
 * TODO (Người 3): Implement toàn bộ phương thức chính.
 * TODO (Người 4): Thêm validate khi Admin CRUD (giá > 0, số lượng >= 0).
 * TODO (Người 5): Bổ sung phương thức thống kê (top bán chạy) dùng cho dashboard/report.
 */
public interface ProductService {
    List<SanPham> findAll();
    Page<SanPham> findAll(Pageable pageable);
    Optional<SanPham> findById(Integer id);

    // Tìm theo danh mục
    List<SanPham> findByCategory(LoaiSanPham loai);

    // Tìm kiếm tên chứa keyword
    List<SanPham> searchByName(String keyword);

    // Lọc theo khoảng giá
    List<SanPham> filterByPrice(BigDecimal min, BigDecimal max);

    // Sản phẩm mới nhất
    List<SanPham> findNewest(int limit);

    // Placeholder sản phẩm nổi bật (cần thêm logic dựa trên số lượng bán / view)
    // TODO (Người 5 + Người 3): Gợi ý implement:
    //  1. Dựa vào DonHangChiTiet (SUM soLuong) trong 30 ngày gần nhất -> top N
    //  2. Nếu chưa đủ dữ liệu đơn hàng (ví dụ hệ thống mới) -> fallback newest
    List<SanPham> findFeatured(int limit);

    // CRUD cơ bản (Admin)
    // TODO (Người 4): validate trước khi create/update:
    //  - tenSP không rỗng, giá > 0, soLuong >= 0
    //  - Hình ảnh: nếu null -> gán placeholder
    SanPham create(SanPham sp);
    SanPham update(SanPham sp);
    void delete(Integer id); // TODO (Người 4): Có thể chuyển thành soft delete (thêm cột TrangThai nếu mở rộng)
}
