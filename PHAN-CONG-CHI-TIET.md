# 🎯 PHÂN CÔNG ASM - WEB BÁN HÀNG TẾT NGUYÊN ĐÁN (5 NGƯỜI)

## 📋 **TỔNG QUAN DỰ ÁN**
- **Tên dự án**: Website Bán Đồ Tết Nguyên Đán 2025
- **Framework**: Spring Boot + Thymeleaf + SQL Server
- **Database**: WebBanHangTet (THEO FILE asmfpt5 22.23.14.sql)
- **Chức năng chính**: Bán hàng online, quản lý đơn hàng, kiến thức Tết

## 🚨 **QUY TẮC QUAN TRỌNG**
### ⚠️ **TẤT CẢ CODE PHẢI DỰA TRÊN FILE SQL: `asmfpt5 22.23.14.sql`**
- ❌ **KHÔNG ĐƯỢC** thay đổi database schema
- ❌ **KHÔNG ĐƯỢC** thêm/xóa bảng hoặc cột
- ✅ **CHỈ ĐƯỢC** dùng đúng tên bảng, cột như trong file SQL
- ✅ **CHỈ ĐƯỢC** dùng đúng kiểu dữ liệu như đã định nghĩa
- ✅ **CHỈ ĐƯỢC** dùng các trigger và constraint đã có

### 📊 **DATABASE SCHEMA CHUẨN (từ file SQL):**
```sql
-- 13 BẢNG CHÍNH:
1. VaiTro (MaVT, TenVT)
2. TaiKhoan (MaTK, HoTen, Email, MatKhau, SoDienThoai, MaVT, TrangThai, NgayTao)
3. DiaChi (MaDC, MaTK, DiaChiChiTiet, MacDinh)
4. LoaiSanPham (MaLoai, TenLoai)
5. SanPham (MaSP, TenSP, MoTa, Gia, SoLuong, HinhAnh, MaLoai, NgayTao)
6. NhapKho (MaNK, MaSP, SoLuong, NgayNhap)
7. GioHang (MaTK, MaSP, SoLuong) -- COMPOSITE KEY
8. TrangThaiDonHang (MaTTDH, TenTTDH)
9. PhuongThucThanhToan (MaPTTT, TenPTTT)
10. DonHang (MaDH, MaKH, MaNV, MaDC, NgayDat, TongTien, MaTTDH, MaPTTT)
11. DonHangChiTiet (MaDHCT, MaDH, MaSP, SoLuong, DonGia)
12. ThongKe (MaThongKe, NgayBaoCao, TongDoanhThu, TongDonHang, TongSanPhamBanRa)
13. DanhGia (MaDG, MaKH, MaSP, MaDH, SoSao, BinhLuan, NgayDG)
14. BaiViet (MaBV, MaTK, TieuDe, NoiDung, NgayDang, HinhAnh, TrangThai)
```

---

## 👥 **PHÂN CHIA NHIỆM VỤ CÔNG BẰNG**

### 🏗️ **NGƯỜI 1 - DATABASE & CORE SYSTEM** ✅ **ĐÃ HOÀN THÀNH**
**Tỷ lệ công việc**: 20% dự án
**Trách nhiệm**: Thiết kế database, entities, cấu hình cơ bản

#### ✅ **Đã hoàn thành (100%) - THEO ĐÚNG FILE SQL:**
1. **Database Schema**: 
   - File `asmfpt5 22.23.14.sql` với 14 bảng hoàn chỉnh
   - Triggers tự động: trg_NhapKho_Insert, trg_DonHangChiTiet_Insert, trg_DonHangChiTiet_Delete
   - Constraints: FOREIGN KEY, CHECK, UNIQUE đầy đủ

2. **Entities (14 files) - 100% KHỚP VỚI SQL:**
   - ✅ `VaiTro.java` - Phân quyền (Admin, Nhân viên, Khách hàng)
   - ✅ `TaiKhoan.java` - Tài khoản (đã sửa khớp file SQL)
   - ✅ `DiaChi.java` - Địa chỉ giao hàng riêng biệt
   - ✅ `LoaiSanPham.java` - Danh mục sản phẩm
   - ✅ `SanPham.java` - Sản phẩm (theo đúng cột SQL)
   - ✅ `NhapKho.java` - Quản lý nhập kho
   - ✅ `GioHang.java` & `GioHangId.java` - Composite key (MaTK, MaSP)
   - ✅ `TrangThaiDonHang.java` - Trạng thái đơn hàng
   - ✅ `PhuongThucThanhToan.java` - Phương thức thanh toán
   - ✅ `DonHang.java` - Đơn hàng (MaKH, MaNV đều reference TaiKhoan)
   - ✅ `DonHangChiTiet.java` - Chi tiết đơn hàng
   - ✅ `ThongKe.java` - Báo cáo thống kê
   - ✅ `DanhGia.java` - Đánh giá sản phẩm (UNIQUE constraint)
   - ✅ `BaiViet.java` - Bài viết kiến thức

3. **Configuration Files:**
   - ✅ `application.properties` - Kết nối SQL Server (spring.jpa.hibernate.ddl-auto=none)
   - ✅ `ProjectendApplication.java` - Main class
   - ✅ Tất cả Repository interfaces (14 files)

---

### 🔐 **NGƯỜI 2 - AUTHENTICATION & SECURITY** ✅ **ĐÃ HOÀN THÀNH** 
**Tỷ lệ công việc**: 20% dự án
**Trách nhiệm**: Bảo mật, đăng nhập, phân quyền

#### ✅ **Đã hoàn thành (100%) - SỬ DỤNG ĐÚNG BẢNG SQL:**
1. **Security Configuration - DỰA TRÊN BẢNG VaiTro & TaiKhoan:**
   ```java
   // Sử dụng đúng cột Email từ bảng TaiKhoan
   .usernameParameter("email")
   
   // Phân quyền theo TenVT trong bảng VaiTro
   .requestMatchers("/admin/**").hasAnyRole("Admin", "Nhân viên")
   .requestMatchers("/profile/**").hasRole("Khách hàng")
   ```

2. **Authentication Logic:**
   - ✅ `SecurityConfig.java` - Spring Security với BCrypt
   - ✅ `UserDetailsServiceImpl.java` - Load từ TaiKhoan.Email
   - ✅ `AuthController.java` - Login/Register tương tác TaiKhoan table
   - ✅ `TaiKhoanService.java` - CRUD theo entity TaiKhoan

---

### 🛍️ **NGƯỜI 3 - CUSTOMER WEBSITE & SHOPPING** 🔄 **CẦN LÀM**
**Tỷ lệ công việc**: 20% dự án
**Trách nhiệm**: Trang khách hàng, mua sắm, tương tác

#### 🎯 **TODO NGƯỜI 3 - TUÂN THỦ ĐÚNG FILE SQL:**

##### **A. Tạo Services theo đúng bảng SQL:**
```java
// TODO NGƯỜI 3: SanPhamService.java - DỰA TRÊN BẢNG SanPham
@Query("SELECT s FROM SanPham s WHERE s.loaiSanPham.maLoai = :maLoai")
List<SanPham> findByLoaiSanPham(@Param("maLoai") Integer maLoai);

@Query("SELECT s FROM SanPham s WHERE s.tenSP LIKE %:keyword%")
Page<SanPham> findByTenSPContaining(@Param("keyword") String keyword, Pageable pageable);

// TODO NGƯỜI 3: GioHangService.java - DỰA TRÊN BẢNG GioHang
// Composite key: (MaTK, MaSP)
public void themSanPham(TaiKhoan taiKhoan, SanPham sanPham, Integer soLuong);
public void capNhatSoLuong(TaiKhoan taiKhoan, SanPham sanPham, Integer soLuong);
```

##### **B. Controllers sử dụng đúng entities:**
```java
// TODO NGƯỜI 3: HomeController.java
// Sử dụng đúng bảng SanPham, LoaiSanPham, BaiViet
List<SanPham> featuredProducts = sanPhamService.findTop4ByOrderByNgayTaoDesc();
List<LoaiSanPham> categories = loaiSanPhamService.findAll();
List<BaiViet> posts = baiVietService.findTop3ByTrangThaiOrderByNgayDangDesc("Hiển thị");

// TODO NGƯỜI 3: SanPhamController.java  
// Filter theo MaLoai, tìm kiếm theo TenSP
@RequestParam(required = false) Integer maLoai // ĐÚNG tên cột SQL
Page<SanPham> products = sanPhamService.findByMaLoaiAndTenSP(maLoai, keyword, pageable);

// TODO NGƯỜI 3: GioHangController.java
// Thao tác với bảng GioHang (composite key)
GioHangId gioHangId = new GioHangId(taiKhoan.getMaTK(), sanPham.getMaSP());
```

---

### 📦 **NGƯỜI 4 - ORDER MANAGEMENT & CHECKOUT** 🔄 **CẦN LÀM**
**Tỷ lệ công việc**: 20% dự án  
**Trách nhiệm**: Đặt hàng, thanh toán, quản lý đơn hàng

#### 🎯 **TODO NGƯỜI 4 - TUÂN THỦ ĐÚNG FILE SQL:**

##### **A. Services theo đúng bảng SQL:**
```java
// TODO NGƯỜI 4: DonHangService.java - DỰA TRÊN 3 BẢNG
// DonHang: MaDH, MaKH, MaNV, MaDC, NgayDat, TongTien, MaTTDH, MaPTTT
// DonHangChiTiet: MaDHCT, MaDH, MaSP, SoLuong, DonGia  
// TrangThaiDonHang: MaTTDH, TenTTDH

public DonHang createDonHang(TaiKhoan khachHang, Integer maDC, Integer maPTTT, List<GioHang> gioHangItems) {
    DonHang donHang = new DonHang();
    donHang.setKhachHang(khachHang);        // MaKH -> TaiKhoan
    donHang.setDiaChi(diaChiService.findById(maDC));  // MaDC -> DiaChi
    donHang.setPhuongThucThanhToan(ptttService.findById(maPTTT)); // MaPTTT
    // MaNV = null ban đầu (admin sẽ assign sau)
    
    // Tạo DonHangChiTiet cho từng item
    for (GioHang item : gioHangItems) {
        DonHangChiTiet chiTiet = new DonHangChiTiet();
        chiTiet.setDonHang(donHang);
        chiTiet.setSanPham(item.getSanPham());
        chiTiet.setSoLuong(item.getSoLuong());
        chiTiet.setDonGia(item.getSanPham().getGia());
    }
}
```

##### **B. Controllers tương tác đúng bảng:**
```java
// TODO NGƯỜI 4: CheckoutController.java
// Sử dụng bảng DiaChi, PhuongThucThanhToan
List<DiaChi> diaChiList = diaChiService.findByTaiKhoan(taiKhoan);
List<PhuongThucThanhToan> ptttList = ptttService.findAll();

// TODO NGƯỜI 4: ProfileController.java  
// Hiển thị DonHang của khách hàng, DonHangChiTiet
Page<DonHang> orders = donHangService.findByKhachHang(taiKhoan, pageable);
```

---

### 🏢 **NGƯỜI 5 - ADMIN DASHBOARD & REPORTS** 🔄 **CẦN LÀM**
**Tỷ lệ công việc**: 20% dự án
**Trách nhiệm**: Trang quản lý admin, báo cáo, thống kê

#### 🎯 **TODO NGƯỜI 5 - SỬ DỤNG ĐÚNG BẢNG THỐNG KÊ:**

##### **A. ThongKeService theo bảng ThongKe:**
```java
// TODO NGƯỜI 5: ThongKeService.java - DỰA TRÊN BẢNG ThongKe
// Cột: MaThongKe, NgayBaoCao, TongDoanhThu, TongDonHang, TongSanPhamBanRa

@Query("SELECT SUM(dh.tongTien) FROM DonHang dh WHERE DATE(dh.ngayDat) = :ngay")
BigDecimal getTongDoanhThuByNgay(@Param("ngay") LocalDate ngay);

@Query("SELECT COUNT(dh) FROM DonHang dh WHERE DATE(dh.ngayDat) = :ngay")
Long getTongDonHangByNgay(@Param("ngay") LocalDate ngay);

// Cập nhật bảng ThongKe hằng ngày
public void capNhatThongKeNgay(LocalDate ngay);
```

##### **B. Admin Dashboard sử dụng đúng bảng:**
```java
// TODO NGƯỜI 5: DashboardController.java
// Thống kê từ các bảng: DonHang, TaiKhoan, SanPham, ThongKe

// Đếm theo VaiTro
Long totalCustomers = taiKhoanRepository.countByVaiTro_TenVT("Khách hàng");
Long totalStaff = taiKhoanRepository.countByVaiTro_TenVT("Nhân viên");

// Thống kê DonHang theo TrangThaiDonHang  
@Query("SELECT ttdh.tenTTDH, COUNT(dh) FROM DonHang dh JOIN dh.trangThaiDonHang ttdh GROUP BY ttdh.tenTTDH")
List<Object[]> getThongKeDonHangByTrangThai();

// Top sản phẩm bán chạy từ DonHangChiTiet
@Query("SELECT dhct.sanPham, SUM(dhct.soLuong) as totalSold FROM DonHangChiTiet dhct GROUP BY dhct.sanPham ORDER BY totalSold DESC")
List<Object[]> getTopSellingProducts(Pageable pageable);
```

---

## 🚨 **CHECKPOINT - KIỂM TRA TUÂN THỦ SQL**

### ✅ **Trước khi code, CHECK:**
1. **Tên bảng**: Đúng như trong CREATE TABLE statements
2. **Tên cột**: Đúng như định nghĩa (MaTK, HoTen, Email,...)  
3. **Kiểu dữ liệu**: INT, NVARCHAR(n), DECIMAL(18,2), BIT, DATETIME
4. **Constraints**: NOT NULL, FOREIGN KEY, UNIQUE đúng như SQL
5. **Triggers**: Nhập kho tăng SoLuong, đặt hàng giảm SoLuong

### ✅ **Sau khi code, TEST:**
1. Import file `asmfpt5 22.23.14.sql` vào SQL Server  
2. Chạy ứng dụng Spring Boot
3. Kiểm tra kết nối database thành công
4. Test CRUD operations không lỗi constraint

---

## 🏆 **KẾT QUẢ MONG ĐỢI**
Website bán hàng Tết hoàn chỉnh, 100% tuân thủ file SQL gốc, không có mâu thuẫn database!
