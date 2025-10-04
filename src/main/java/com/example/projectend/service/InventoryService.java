package com.example.projectend.service;

import com.example.projectend.entity.NhapKho;
import com.example.projectend.entity.SanPham;

import java.util.List;

/**
 * INVENTORY SERVICE (NhapKho + cập nhật tồn kho SanPham.SoLuong)
 * Gắn với bảng NhapKho để log lịch sử và cập nhật trường SoLuong của SanPham.
 *
 * TODO (Người 4): Implement recordImport và cập nhật số lượng sản phẩm.
 * TODO (Người 4): Thêm kiểm tra số lượng âm khi adjustStock (trả về lỗi / exception).
 * TODO (Người 5): Dùng dữ liệu history cho báo cáo nhập - bán để phân tích tồn kho.
 */
public interface InventoryService {
    NhapKho recordImport(SanPham sp, int quantity); // Lưu 1 dòng NhapKho + cộng SoLuong sản phẩm
    void adjustStock(SanPham sp, int delta); // delta âm khi bán, dương khi trả hàng
    int getCurrentStock(SanPham sp); // lấy từ SanPham.SoLuong
    List<NhapKho> getHistoryByProduct(SanPham sp);

    // TODO (Người 4): Khi đặt hàng (OrderService.placeOrder) phải trừ tồn kho từng sản phẩm:
    //  1. Kiểm tra đủ hàng (soLuong >= requested) – nếu thiếu -> throw IllegalArgumentException hoặc custom OutOfStockException
    //  2. Giảm tồn kho (adjustStock với delta âm)
    //  3. Nếu bất kỳ sản phẩm nào thất bại -> rollback toàn bộ (dùng @Transactional ở lớp impl)

    // TODO (Người 4): Khi huỷ đơn (trạng thái chuyển sang HỦY) có thể hoàn hàng lại (tùy chính sách) -> adjustStock(dương)

    // TODO (Người 5): Thống kê tồn kho thấp: có thể thêm method findLowStock(threshold)
}
