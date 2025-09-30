# 🎯 HƯỚNG DẪN CÀI ĐẶT DATABASE - NGƯỜI 1
## Website Bán Đồ Tết Nguyên Đán

### 📋 Yêu cầu hệ thống:
- SQL Server 2019 hoặc mới hơn
- SQL Server Management Studio (SSMS)
- Java 17+
- Maven 3.8+

### 🚀 Bước 1: Cài đặt Database

1. **Mở SQL Server Management Studio**
2. **Kết nối với SQL Server instance**
3. **Chạy file SQL:**
   ```
   /database/create_database.sql
   ```

### 🔧 Bước 2: Cấu hình kết nối

Trong file `application.properties` đã được cấu hình:
```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=WebBanHangTet
spring.datasource.username=sa
spring.datasource.password=123456
```

**⚠️ Lưu ý:** Thay đổi `username` và `password` theo SQL Server của bạn.

### 📊 Database Schema Overview:

#### 12 Bảng chính:
- **VaiTro**: Quản lý vai trò (Khách hàng, Nhân viên, Admin)
- **TaiKhoan**: Thông tin người dùng
- **DiaChi**: Địa chỉ giao hàng
- **LoaiSanPham**: 4 loại sản phẩm Tết
- **TrangThaiSanPham**: Trạng thái sản phẩm
- **SanPham**: Sản phẩm đồ Tết
- **NhapKho**: Quản lý nhập kho
- **GioHang**: Giỏ hàng của khách
- **TrangThaiDonHang**: Trạng thái đơn hàng
- **PhuongThucThanhToan**: Phương thức thanh toán
- **DonHang**: Đơn hàng
- **DonHangChiTiet**: Chi tiết đơn hàng
- **ThongKe**: Thống kê doanh thu

### 🎨 4 Loại sản phẩm Tết:
1. **Giỏ quà Tết** - Combo quà đa dạng
2. **Hộp quà Tết** - Hộp quà cao cấp, sang trọng
3. **Mứt - Bánh kẹo** - Đặc sản truyền thống
4. **Bao lì xì & Trang trí** - Phụ kiện may mắn

### 🎭 Sản phẩm mẫu có sẵn:
- **Giỏ quà Tết An Khang** (500,000đ) - Bánh kẹo và trà cao cấp
- **Hộp quà Tết Phát Tài** (1,200,000đ) - Rượu vang và socola
- **Mứt dừa non hộp 500g** (150,000đ) - Thơm ngon, ngọt béo
- **Bao lì xì vàng 2025** (30,000đ) - Sang trọng, may mắn

### 💳 3 Phương thức thanh toán:
- COD - Thanh toán khi nhận hàng
- Chuyển khoản ngân hàng
- Ví điện tử Momo

### 📈 4 Trạng thái đơn hàng:
- Chờ xác nhận
- Đang giao
- Hoàn tất
- Đã hủy

### 🧪 Test Database:
```sql
-- Kiểm tra kết nối
SELECT COUNT(*) FROM SanPham;
SELECT COUNT(*) FROM LoaiSanPham;
SELECT * FROM VaiTro;
SELECT TOP 5 * FROM SanPham;

-- Kiểm tra đơn hàng mẫu
SELECT dh.MaDH, tk.HoTen, dh.TongTien, ttdh.TenTTDH
FROM DonHang dh
JOIN TaiKhoan tk ON dh.MaTK = tk.MaTK
JOIN TrangThaiDonHang ttdh ON dh.MaTTDH = ttdh.MaTTDH;
```

### ✅ Checklist cho Người 1:
- [x] Database schema hoàn chỉnh theo chuẩn
- [x] Cấu hình Spring Boot kết nối external SQL Server
- [x] 4 loại sản phẩm Tết
- [x] 4 sản phẩm mẫu đa dạng
- [x] 3 tài khoản test (Admin, Staff, Customer)
- [x] Dữ liệu đơn hàng mẫu
- [ ] Tạo Entity classes
- [ ] Tạo Repository classes  
- [ ] Tạo Service classes cơ bản

### 👥 Tài khoản test có sẵn:
- **Admin**: admin@webtet.com / admin123
- **Staff**: staff@webtet.com / staff123  
- **Customer**: customer@webtet.com / cust123

---
*Người 1 - Database Design & Backend Core*  
*Database: WebBanHangTet*
