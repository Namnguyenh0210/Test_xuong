package com.example.projectend.service;

import com.example.projectend.entity.GioHang;
import com.example.projectend.entity.SanPham;
import com.example.projectend.entity.TaiKhoan;

import java.math.BigDecimal;
import java.util.List;

/**
 * CART SERVICE (Giỏ hàng)
 * TODO (Người 3): Implement toàn bộ logic chính cho khách hàng.
 * TODO (Người 2): Khi login xong, đồng bộ giỏ hàng tạm (cookie) vào DB (nếu làm nâng cao).
 */
public interface CartService {
    // ================= CUSTOMER OPS (Người 3) =================
    // Lấy toàn bộ item trong giỏ của user (đảm bảo sort theo tên hoặc thời gian thêm nếu cần UX)
    List<GioHang> getItems(TaiKhoan user);

    // Thêm mới hoặc cộng dồn số lượng nếu (MaTK, MaSP) đã tồn tại
    void addItem(TaiKhoan user, SanPham sp, int quantity);

    // Cập nhật số lượng tuyệt đối (set quantity). Nếu quantity <= 0 => xoá item
    void updateItem(TaiKhoan user, SanPham sp, int quantity);

    // Tăng / giảm delta (ví dụ +1 hoặc -1 cho nút +/-). Nếu giảm dẫn tới <=0 => xoá
    void incrementItem(TaiKhoan user, SanPham sp, int delta);

    // Xoá 1 sản phẩm khỏi giỏ
    void removeItem(TaiKhoan user, SanPham sp);

    // Xoá toàn bộ giỏ hàng
    void clearCart(TaiKhoan user);

    // Tổng tiền (sử dụng giá hiện tại của sản phẩm hoặc giá snapshot? -> TODO Người 3: quyết định)
    BigDecimal getTotal(TaiKhoan user);

    // Tổng số lượng item (cộng dồn SoLuong)
    int getTotalQuantity(TaiKhoan user);

    // ================= MERGE & CHECKOUT (Người 2 + Người 3) =================
    // Merge giỏ hàng tạm (cookie JSON) vào DB sau khi user login
    // TODO (Người 2/3): Implement khi làm nâng cao remember cart
    void mergeTemporaryCart(TaiKhoan user, List<GioHang> tempItems);

    // Tạo snapshot chi tiết giỏ để chuyển sang bước checkout (tránh thay đổi khi user mở 2 tab)
    // TODO (Người 3): Có thể triển khai tuỳ nhu cầu
    List<GioHang> snapshotForCheckout(TaiKhoan user);
}
