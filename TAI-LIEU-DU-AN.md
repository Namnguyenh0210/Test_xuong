# 📚 TÀI LIỆU DỰ ÁN - WEB BÁN HÀNG TẾT NGUYÊN ĐÁN 2025

## 📋 **TỔNG QUAN DỰ ÁN**
- **Tên**: Website Bán Đồ Tết Nguyên Đán 2025
- **Framework**: Spring Boot 3.x + Thymeleaf + SQL Server
- **Database**: WebBanHangTet (theo file `asmfpt5 22.23.14.sql`)
- **Tổng files Java**: 47 files
- **Architecture**: MVC Pattern với Spring Boot

---

## 🗂️ **SƠ ĐỒ CẤU TRÚC DỰ ÁN**

### 📊 **1. SƠ ĐỒ TỔNG QUAN ARCHITECTURE**

```
┌─────────────────────────────────────────────────────────────────┐
│                    🌐 SPRING BOOT APPLICATION                    │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  👤 USER INTERFACE (Browser)                                   │
│  ├── 🏠 Trang chủ (home.html) ← HomeController.java           │
│  ├── 🛍️ Sản phẩm (sanpham.html) ← SanPhamController.java      │
│  ├── 🛒 Giỏ hàng (giohang.html) ← GioHangController.java       │
│  ├── 💳 Checkout (checkout.html) ← CheckoutController.java     │
│  ├── 👨‍💼 Profile (profile.html) ← ProfileController.java        │
│  ├── 📚 Kiến thức (kienthuc.html) ← KienThucController.java    │
│  ├── 🔐 Login/Register ← AuthController.java                   │
│  └── ⚙️ Admin Dashboard ← DashboardController.java             │
│                                                                 │
├─────────────────────────────────────────────────────────────────┤
│                    🏗️ BUSINESS LOGIC LAYER                      │
│  ├── 🔧 SanPhamService.java (TODO NGƯỜI 3)                     │
│  ├── 🛒 GioHangService.java (TODO NGƯỜI 3)                     │
│  ├── 📦 DonHangService.java (TODO NGƯỜI 4)                     │
│  ├── 💰 ThanhToanService.java (TODO NGƯỜI 4)                   │
│  ├── 📊 ThongKeService.java (TODO NGƯỜI 5)                     │
│  ├── 📝 BaiVietService.java ✅ (ĐÃ HOÀN THÀNH)                │
│  ├── ⭐ DanhGiaService.java ✅ (ĐÃ HOÀN THÀNH)                 │
│  └── 🔐 UserDetailsServiceImpl.java ✅ (ĐÃ HOÀN THÀNH)        │
│                                                                 │
├─────────────────────────────────────────────────────────────────┤
│                    🗃️ DATA ACCESS LAYER                         │
│  ├── 📋 13 Repository interfaces ✅ (TẤT CẢ ĐÃ HOÀN THÀNH)   │
│  └── 🗂️ 14 Entity classes ✅ (KHỚP 100% VỚI FILE SQL)        │
│                                                                 │
├─────────────────────────────────────────────────────────────────┤
│                    💾 DATABASE LAYER                            │
│  └── 🗄️ SQL Server - WebBanHangTet                            │
│      └── 📄 asmfpt5 22.23.14.sql (14 bảng + triggers)         │
└─────────────────────────────────────────────────────────────────┘
```

### 🏢 **2. SƠ ĐỒ PHÂN CHIA TRÁCH NHIỆM**

```
👥 NHÓM 5 NGƯỜI - PHÂN CHIA CÔNG BẰNG (20% MỖI NGƯỜI)

┌──────────────────┐  ┌──────────────────┐  ┌──────────────────┐
│ 🏗️ NGƯỜI 1       │  │ 🔐 NGƯỜI 2       │  │ 🛍️ NGƯỜI 3       │
│ Database & Core  │  │ Authentication   │  │ Customer Web     │
│ ✅ ĐÃ HOÀN THÀNH │  │ ✅ ĐÃ HOÀN THÀNH │  │ 🔄 CẦN HOÀN THIỆN│
├──────────────────┤  ├──────────────────┤  ├──────────────────┤
│ • 14 Entities    │  │ • SecurityConfig │  │ • SanPhamService │
│ • 13 Repositories│  │ • AuthController │  │ • HomeController │
│ • Configuration  │  │ • UserDetails    │  │ • SanPhamCtrl    │
│ • SQL Schema     │  │ • Login/Register │  │ • GioHangCtrl    │
└──────────────────┘  └──────────────────┘  └──────────────────┘

┌──────────────────┐  ┌──────────────────┐
│ 📦 NGƯỜI 4       │  │ 🏢 NGƯỜI 5       │
│ Order & Checkout │  │ Admin Dashboard  │
│ 🔄 CẦN HOÀN THIỆN│  │ 🔄 CẦN HOÀN THIỆN│
├──────────────────┤  ├──────────────────┤
│ • DonHangService │  │ • ThongKeService │
│ • CheckoutCtrl   │  │ • AdminService   │
│ • ProfileCtrl    │  │ • DashboardCtrl  │
│ • ThanhToanSvc   │  │ • Reports/Charts │
└──────────────────┘  └──────────────────┘
```

### 🗄️ **3. SƠ ĐỒ DATABASE SCHEMA (14 BẢNG)**

```
📊 DATABASE: WebBanHangTet (theo file asmfpt5 22.23.14.sql)

👥 QUẢN LÝ TÀI KHOẢN:
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│   VaiTro    │    │  TaiKhoan   │    │   DiaChi    │
│ MaVT (PK)   │───▶│ MaTK (PK)   │◄──▶│ MaDC (PK)   │
│ TenVT       │    │ HoTen       │    │ MaTK (FK)   │
└─────────────┘    │ Email       │    │ DiaChiChiTiet│
                   │ MatKhau     │    │ MacDinh     │
                   │ MaVT (FK)   │    └─────────────┘
                   └─────────────┘

🛍️ QUẢN LỦ SẢN PHẨM:
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│LoaiSanPham  │    │  SanPham    │    │  NhapKho    │
│ MaLoai (PK) │───▶│ MaSP (PK)   │◄──▶│ MaNK (PK)   │
│ TenLoai     │    │ TenSP       │    │ MaSP (FK)   │
└─────────────┘    │ Gia         │    │ SoLuong     │
                   │ SoLuong     │    │ NgayNhap    │
                   │ MaLoai (FK) │    └─────────────┘
                   └─────────────┘
                          │
                          ▼
                   ┌─────────────┐
                   │  GioHang    │
                   │ MaTK (FK)   │◄── Composite Key
                   │ MaSP (FK)   │◄── (MaTK, MaSP)
                   │ SoLuong     │
                   └─────────────┘

📦 QUẢN LÝ ĐƠN HÀNG:
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│TrangThaiDH  │    │  DonHang    │    │PhuongThucTT │
│ MaTTDH (PK) │───▶│ MaDH (PK)   │◄──▶│ MaPTTT (PK) │
│ TenTTDH     │    │ MaKH (FK)   │    │ TenPTTT     │
└─────────────┘    │ MaNV (FK)   │    └─────────────┘
                   │ MaDC (FK)   │
                   │ TongTien    │
                   └─────────────┘
                          │
                          ▼
                   ┌─────────────┐
                   │DonHangChiTiet│
                   │ MaDHCT (PK) │
                   │ MaDH (FK)   │
                   │ MaSP (FK)   │
                   │ SoLuong     │
                   │ DonGia      │
                   └─────────────┘

📊 HỆ THỐNG KHÁC:
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│  ThongKe    │    │  BaiViet    │    │  DanhGia    │
│ MaThongKe   │    │ MaBV (PK)   │    │ MaDG (PK)   │
│ NgayBaoCao  │    │ MaTK (FK)   │    │ MaKH (FK)   │
│ TongDoanhThu│    │ TieuDe      │    │ MaSP (FK)   │
│ TongDonHang │    │ NoiDung     │    │ MaDH (FK)   │
└─────────────┘    │ TrangThai   │    │ SoSao (1-5) │
                   └─────────────┘    │ BinhLuan    │
                                      └─────────────┘
```

### 🔄 **4. SƠ ĐỒ LUỒNG HOẠT ĐỘNG WEBSITE**

```
🌐 LUỒNG SỬ DỤNG WEBSITE BÁN HÀNG TẾT

┌─────────────────────────────────────────────────────────────────┐
│                      👤 KHÁCH HÀNG                               │
└─────────────────────┬───────────────────────────────────────────┘
                      │
          ┌───────────▼────────────┐
          │   🏠 Trang chủ        │ ← HomeController
          │ • 4 sản phẩm nổi bật   │ ← SanPhamService.getFeaturedProducts()
          │ • 3 bài viết mới      │ ← BaiVietService.getFeaturedPosts()
          │ • Danh mục SP         │
          └───────────┬────────────┘
                      │
      ┌───────────────┼───────────────┐
      │               │               │
      ▼               ▼               ▼
┌──────────┐   ┌─────────────┐   ┌─────────────┐
│🛍️ Sản phẩm│   │📚 Kiến thức │   │👤 Account │
│• Tìm kiếm │   │• Bài viết   │   │• Login   │
│• Filter   │   │• Tips Tết   │   │• Register│
│• Chi tiết │   │• Phân trang │   └──────────┘
└─────┬────┘   └─────────────┘
      │
      ▼ (Thêm vào giỏ)
┌──────────────┐
│🛒 Giỏ hàng   │ ← GioHangController
│• AJAX update │ ← GioHangService
│• Tính tiền   │
└──────┬───────┘
       │ (Đặt hàng)
       ▼
┌──────────────┐
│💳 Checkout   │ ← CheckoutController  
│• Địa chỉ GH  │ ← DonHangService
│• Thanh toán  │ ← ThanhToanService
│• Xác nhận    │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│✅ Hoàn tất   │
│• Trang cảm ơn│
│• Theo dõi ĐH │ ← ProfileController
└──────────────┘
```

### ⚙️ **5. SƠ ĐỒ ADMIN DASHBOARD**

```
🏢 LUỒNG QUẢN LÝ ADMIN

┌─────────────────────────────────────────────────────────────────┐
│                    👨‍💼 ADMIN/NHÂN VIÊN                          │
└─────────────────────┬───────────────────────────────────────────┘
                      │ (Login)
          ┌───────────▼────────────┐
          │  📊 Dashboard          │ ← DashboardController
          │ • Thống kê tổng quan   │ ← ThongKeService
          │ • Charts doanh thu     │
          │ • Đơn hàng mới         │
          └────────┬───────────────┘
                   │
    ┌──────────────┼──────────────┐
    │              │              │
    ▼              ▼              ▼
┌─────────┐  ┌─────────────┐  ┌─────────────┐
│📝 Bài viết│  │📦 Đơn hàng   │  │📊 Báo cáo   │
│• CRUD   │  │• Xử lý ĐH   │  │• Doanh thu  │
│• Editor │  │• Cập nhật TT│  │• SP bán chạy│
│✅ XONG  │  │• In hóa đơn │  │• Export Excel│
└─────────┘  │🔄 TODO Ng5  │  │🔄 TODO Ng5  │
             └─────────────┘  └─────────────┘

┌─────────────┐  ┌─────────────┐  ┌─────────────┐
│👥 Tài khoản  │  │🛍️ Sản phẩm   │  │⭐ Đánh giá   │
│• CRUD User  │  │• CRUD SP    │  │• Quản lý DG │
│🔄 TODO Ng5  │  │🔄 TODO Ng5  │  │✅ XONG      │
└─────────────┘  └─────────────┘  └─────────────┘
```

### 📁 **6. SƠ ĐỒ CẤU TRÚC FILE VÀ TRÁCH NHIỆM**

```
📂 projectend-spring/
├── 📄 asmfpt5 22.23.14.sql ← 🗄️ Database Schema (NGƯỜI 1 ✅)
├── 📄 PHAN-CONG-CHI-TIET.md ← 📋 Phân công nhóm
├── 📄 TAI-LIEU-DU-AN.md ← 📚 Tài liệu này
│
├── 📂 src/main/java/com/example/projectend/
│   ├── 📄 ProjectendApplication.java ← 🚀 Main class (NGƯỜI 1 ✅)
│   │
│   ├── 📂 config/ ← ⚙️ Configuration (NGƯỜI 1,2 ✅)
│   │   ├── SecurityConfig.java ← 🔐 Bảo mật (NGƯỜI 2 ✅)
│   │   └── GlobalModelAdvice.java ← 🌐 Global vars (NGƯỜI 1 ✅)
│   │
│   ├── 📂 entity/ ← 🗃️ 14 Entities (NGƯỜI 1 ✅)
│   │   ├── TaiKhoan.java ← 👤 User accounts
│   │   ├── VaiTro.java ← 👥 User roles  
│   │   ├── SanPham.java ← 🛍️ Products
│   │   ├── DonHang.java ← 📦 Orders
│   │   └── ... (10 entities khác)
│   │
│   ├── 📂 repository/ ← 🗄️ 13 Repositories (NGƯỜI 1 ✅)
│   │   ├── TaiKhoanRepository.java
│   │   ├── SanPhamRepository.java
│   │   └── ... (11 repositories khác)
│   │
│   ├── 📂 service/ ← 🏢 Business Logic
│   │   ├── 📂 auth/
│   │   │   └── UserDetailsServiceImpl.java ← 🔐 (NGƯỜI 2 ✅)
│   │   ├── BaiVietService.java ← 📝 (NGƯỜI 1 ✅)
│   │   ├── DanhGiaService.java ← ⭐ (NGƯỜI 1 ✅)  
│   │   ├── SanPhamService.java ← 🛍️ (NGƯỜI 3 🔄)
│   │   ├── GioHangService.java ← 🛒 (NGƯỜI 3 🔄 TODO)
│   │   ├── DonHangService.java ← 📦 (NGƯỜI 4 🔄 TODO)
│   │   ├── ThanhToanService.java ← 💳 (NGƯỜI 4 🔄 TODO)
│   │   └── ThongKeService.java ← 📊 (NGƯỜI 5 🔄 TODO)
│   │
│   └── 📂 controller/ ← 🎮 11 Controllers
│       ├── AuthController.java ← 🔐 Login/Register (NGƯỜI 2 ✅)
│       ├── HomeController.java ← 🏠 Trang chủ (NGƯỜI 3 🔄)
│       ├── SanPhamController.java ← 🛍️ Products (NGƯỜI 3 🔄)
│       ├── GioHangController.java ← 🛒 Cart (NGƯỜI 3 🔄)
│       ├── CheckoutController.java ← 💳 Checkout (NGƯỜI 4 🔄)
│       ├── ProfileController.java ← 👤 Profile (NGƯỜI 4 🔄)
│       ├── DashboardController.java ← 🏢 Admin (NGƯỜI 5 🔄)
│       ├── KienThucController.java ← 📚 Knowledge (NGƯỜI 1 ✅)
│       ├── GioiThieuController.java ← ℹ️ About (NGƯỜI 1 ✅)
│       ├── LienHeController.java ← 📞 Contact (NGƯỜI 1 ✅)
│       └── ApiController.java ← 🔌 REST APIs (NGƯỜI 3,4,5 🔄)
│
└── 📂 src/main/resources/ ← 🎨 Frontend & Config
    ├── application.properties ← ⚙️ DB Config (NGƯỜI 1 ✅)
    ├── 📂 static/ ← CSS, JS, Images
    └── 📂 templates/ ← HTML Templates (NGƯỜI 3,4,5 🔄)

CHƯA KỂ: 📁 target/ ← Build output (auto-generated)
```

---

## 🏗️ **CẤU TRÚC DỰ ÁN THEO LAYER**

### 📁 **1. APPLICATION LAYER (1 file)**

#### `ProjectendApplication.java` 
**👤 Người phụ trách**: Người 1 - Database & Core System  
**🎯 Chức năng**: Main class khởi tạo Spring Boot application  
**📝 Chi tiết**:
- Entry point của toàn bộ ứng dụng
- Chứa method `main()` để chạy Spring Boot
- Tự động scan components trong package `com.example.projectend`
- **Không cần sửa đổi** - đã hoàn thành

---

### ⚙️ **2. CONFIGURATION LAYER (2 files)**

#### `SecurityConfig.java`
**👤 Người phụ trách**: Người 2 - Authentication & Security  
**🎯 Chức năng**: Cấu hình bảo mật toàn hệ thống  
**📝 Chi tiết**:
- Phân quyền theo vai trò: Admin, Nhân viên, Khách hàng
- Login bằng email (không username)
- BCrypt password encoding
- Session management
- CSRF protection disabled (đơn giản cho ASM)
- Route protection: `/admin/**`, `/profile/**`
- **Đã hoàn thành** - không cần sửa

#### `GlobalModelAdvice.java`
**👤 Người phụ trách**: Người 1 - Database & Core System  
**🎯 Chức năng**: Inject biến global cho tất cả templates  
**📝 Chi tiết**:
- Tự động thêm `currentYear` và `tetYear` vào mọi template
- Dùng `@ControllerAdvice` để áp dụng toàn cục
- **Có thể mở rộng**: thêm `currentUser`, `categories` global
- **Đã hoàn thành** - hoạt động tốt

---

### 🗃️ **3. ENTITY LAYER - 14 ENTITIES (Theo file SQL)**

#### 👥 **Quản lý tài khoản (3 entities)**

##### `VaiTro.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Phân quyền hệ thống  
**🔗 Bảng SQL**: `VaiTro (MaVT, TenVT)`  
**📝 Chi tiết**:
- Lưu 3 vai trò: "Khách hàng", "Nhân viên", "Admin"
- OneToMany với TaiKhoan
- **Đã hoàn thành** - khớp 100% với SQL

##### `TaiKhoan.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Tài khoản người dùng  
**🔗 Bảng SQL**: `TaiKhoan (MaTK, HoTen, Email, MatKhau, SoDienThoai, MaVT, TrangThai, NgayTao)`  
**📝 Chi tiết**:
- Login bằng Email (unique)
- ManyToOne với VaiTro
- OneToMany với DiaChi, DonHang, BaiViet
- **Đã sửa** khớp với SQL schema

##### `DiaChi.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Địa chỉ giao hàng  
**🔗 Bảng SQL**: `DiaChi (MaDC, MaTK, DiaChiChiTiet, MacDinh)`  
**📝 Chi tiết**:
- ManyToOne với TaiKhoan
- Có địa chỉ mặc định (MacDinh)
- **Đã hoàn thành**

#### 🛍️ **Quản lý sản phẩm (4 entities)**

##### `LoaiSanPham.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Danh mục sản phẩm  
**🔗 Bảng SQL**: `LoaiSanPham (MaLoai, TenLoai)`  
**📝 Chi tiết**:
- 4 loại: "Giỏ quà Tết", "Hộp quà Tết", "Mứt - Bánh kẹo", "Bao lì xì & Trang trí"
- OneToMany với SanPham
- **Đã hoàn thành**

##### `SanPham.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Sản phẩm bán hàng  
**🔗 Bảng SQL**: `SanPham (MaSP, TenSP, MoTa, Gia, SoLuong, HinhAnh, MaLoai, NgayTao)`  
**📝 Chi tiết**:
- ManyToOne với LoaiSanPham
- Trigger tự động cập nhật SoLuong khi nhập kho/đặt hàng
- **Đã hoàn thành**

##### `NhapKho.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Lịch sử nhập kho  
**🔗 Bảng SQL**: `NhapKho (MaNK, MaSP, SoLuong, NgayNhap)`  
**📝 Chi tiết**:
- ManyToOne với SanPham  
- Có trigger tự động tăng SoLuong của SanPham
- **Đã hoàn thành**

##### `GioHang.java + GioHangId.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Giỏ hàng composite key  
**🔗 Bảng SQL**: `GioHang (MaTK, MaSP, SoLuong)`  
**📝 Chi tiết**:
- Composite key: (MaTK, MaSP)
- ManyToOne với TaiKhoan và SanPham
- **Đã hoàn thành**

#### 📦 **Quản lý đơn hàng (4 entities)**

##### `TrangThaiDonHang.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Trạng thái đơn hàng  
**🔗 Bảng SQL**: `TrangThaiDonHang (MaTTDH, TenTTDH)`  
**📝 Chi tiết**:
- 4 trạng thái: "Chờ xác nhận", "Đang giao", "Hoàn tất", "Đã hủy"
- **Đã hoàn thành**

##### `PhuongThucThanhToan.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Phương thức thanh toán  
**🔗 Bảng SQL**: `PhuongThucThanhToan (MaPTTT, TenPTTT)`  
**📝 Chi tiết**:
- 3 phương thức: COD, Chuyển khoản, Ví điện tử
- **Đã hoàn thành**

##### `DonHang.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Đơn hàng chính  
**🔗 Bảng SQL**: `DonHang (MaDH, MaKH, MaNV, MaDC, NgayDat, TongTien, MaTTDH, MaPTTT)`  
**📝 Chi tiết**:
- MaKH và MaNV đều reference TaiKhoan
- MaNV = null ban đầu (admin assign sau)
- OneToMany với DonHangChiTiet
- **Đã hoàn thành**

##### `DonHangChiTiet.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Chi tiết đơn hàng  
**🔗 Bảng SQL**: `DonHangChiTiet (MaDHCT, MaDH, MaSP, SoLuong, DonGia)`  
**📝 Chi tiết**:
- ManyToOne với DonHang và SanPham
- Có trigger tự động trừ SoLuong khi tạo đơn
- **Đã hoàn thành**

#### 📊 **Hệ thống khác (3 entities)**

##### `ThongKe.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Báo cáo thống kê hằng ngày  
**🔗 Bảng SQL**: `ThongKe (MaThongKe, NgayBaoCao, TongDoanhThu, TongDonHang, TongSanPhamBanRa)`  
**📝 Chi tiết**:
- Unique constraint trên NgayBaoCao
- **Đã hoàn thành**

##### `BaiViet.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Bài viết kiến thức Tết  
**🔗 Bảng SQL**: `BaiViet (MaBV, MaTK, TieuDe, NoiDung, NgayDang, HinhAnh, TrangThai)`  
**📝 Chi tiết**:
- ManyToOne với TaiKhoan (người đăng)
- TrangThai: "Hiển thị" / "Ẩn"
- **Đã hoàn thành**

##### `DanhGia.java`
**👤 Người phụ trách**: Người 1  
**🎯 Chức năng**: Đánh giá sản phẩm  
**🔗 Bảng SQL**: `DanhGia (MaDG, MaKH, MaSP, MaDH, SoSao, BinhLuan, NgayDG)`  
**📝 Chi tiết**:
- Unique constraint: (MaKH, MaSP, MaDH) - mỗi khách chỉ đánh giá 1 lần
- SoSao: CHECK constraint (1-5)
- **Đã hoàn thành**

---

### 🗄️ **4. REPOSITORY LAYER - 13 REPOSITORIES**

**👤 Tất cả được tạo bởi**: Người 1 - Database & Core System  
**🎯 Chức năng chung**: Data Access Layer, tương tác với database  
**📝 Pattern**: Tất cả extend `JpaRepository<Entity, ID>`  

#### **Danh sách đầy đủ:**
1. `TaiKhoanRepository.java` - CRUD tài khoản, tìm theo email
2. `VaiTroRepository.java` - CRUD vai trò  
3. `DiaChiRepository.java` - CRUD địa chỉ giao hàng
4. `LoaiSanPhamRepository.java` - CRUD danh mục sản phẩm
5. `SanPhamRepository.java` - CRUD sản phẩm, query phức tạp
6. `NhapKhoRepository.java` - CRUD lịch sử nhập kho
7. `GioHangRepository.java` - CRUD giỏ hàng (composite key)
8. `TrangThaiDonHangRepository.java` - CRUD trạng thái đơn hàng
9. `PhuongThucThanhToanRepository.java` - CRUD phương thức thanh toán
10. `DonHangRepository.java` - CRUD đơn hàng, query theo khách hàng
11. `DonHangChiTietRepository.java` - CRUD chi tiết đơn hàng
12. `ThongKeRepository.java` - CRUD thống kê, query theo ngày
13. `BaiVietRepository.java` - CRUD bài viết, tìm kiếm, phân trang
14. `DanhGiaRepository.java` - CRUD đánh giá, tính điểm trung bình

**✅ Trạng thái**: Tất cả đã hoàn thành với method cơ bản

---

### 🏢 **5. SERVICE LAYER - 4 SERVICES (Đã clean)**

#### `UserDetailsServiceImpl.java`
**👤 Người phụ trách**: Người 2 - Authentication & Security  
**🎯 Chức năng**: Load user cho Spring Security  
**📝 Chi tiết**:
- Implement `UserDetailsService` của Spring Security
- Load user từ TaiKhoan.email
- Convert VaiTro thành GrantedAuthority
- **Đã hoàn thành**

#### `BaiVietService.java`
**👤 Người phụ trách**: Người 1 (tạo), Người 5 (sử dụng trong admin)  
**🎯 Chức năng**: Logic nghiệp vụ bài viết  
**📝 Chi tiết**:
- CRUD bài viết
- Tìm kiếm theo tiêu đề
- Phân trang, lấy bài nổi bật
- Toggle trạng thái Hiển thị/Ẩn
- **Đã hoàn thành**

#### `DanhGiaService.java`
**👤 Người phụ trách**: Người 1 (tạo), Người 3 (sử dụng)  
**🎯 Chức năng**: Logic nghiệp vụ đánh giá  
**📝 Chi tiết**:
- CRUD đánh giá sản phẩm
- Tính điểm trung bình
- Check đã đánh giá chưa
- Filter theo số sao
- **Đã hoàn thành**

#### `SanPhamService.java` 
**👤 Người phụ trách**: Người 3 - Customer Website & Shopping  
**🎯 Chức năng**: Logic nghiệp vụ sản phẩm  
**📝 Chi tiết**:
- ⚠️ **CẦN HOÀN THIỆN**: Chỉ có template và TODO
- Tìm kiếm, lọc sản phẩm  
- Sản phẩm nổi bật cho trang chủ
- Sản phẩm liên quan
- **TODO NGƯỜI 3**: Uncomment và implement logic

---

### 🎮 **6. CONTROLLER LAYER - 11 CONTROLLERS**

#### **Đã hoàn thành (5 controllers)**

##### `AuthController.java`
**👤 Người phụ trách**: Người 2 - Authentication & Security  
**🎯 Chức năng**: Xử lý đăng nhập, đăng ký  
**📝 Chi tiết**:
- `/login` - Form đăng nhập
- `/register` - Form + xử lý đăng ký  
- Validation, error handling
- Redirect theo role sau login
- **Đã hoàn thành** - production ready

##### `KienThucController.java`
**👤 Người phụ trách**: Người 1 (cấu trúc), Người 3 (hoàn thiện)  
**🎯 Chức năng**: Trang kiến thức về Tết  
**📝 Chi tiết**:
- `/kienthuc` - Danh sách bài viết có phân trang
- `/kienthuc/{id}` - Chi tiết bài viết
- `/kienthuc/search` - Tìm kiếm bài viết
- Breadcrumb navigation
- **Đã hoàn thành** - sử dụng BaiVietService

##### `DashboardController.java`
**👤 Người phụ trách**: Người 5 - Admin Dashboard & Reports  
**🎯 Chức năng**: Quản lý admin  
**📝 Chi tiết**:
- `/admin` - Dashboard với thống kê
- `/admin/baiviet/**` - CRUD bài viết (đã hoàn thành)
- `/admin/danhgia/**` - Quản lý đánh giá (đã hoàn thành)
- **TODO NGƯỜI 5**: Hoàn thiện phần thống kê, reports

##### `GioiThieuController.java`
**👤 Người phụ trách**: Người 1 - Cấu trúc static  
**🎯 Chức năng**: Trang giới thiệu công ty  
**📝 Chi tiết**:
- `/gioithieu` - Trang tĩnh giới thiệu
- **Đã hoàn thành** - chỉ render template

##### `LienHeController.java`
**👤 Người phụ trách**: Người 1 - Cấu trúc static  
**🎯 Chức năng**: Trang liên hệ  
**📝 Chi tiết**:
- `/lienhe` - Form liên hệ
- **Đã hoàn thành** - chỉ render template

#### **Cần hoàn thiện (6 controllers)**

##### `HomeController.java`
**👤 Người phụ trách**: Người 3 - Customer Website & Shopping  
**🎯 Chức năng**: Trang chủ website  
**📝 Chi tiết**:
- `/` và `/home` - Trang chủ
- **TODO NGƯỜI 3**: 
  - Inject SanPhamService và BaiVietService
  - Hiển thị 4 sản phẩm nổi bật
  - Hiển thị 3 bài viết mới nhất
  - Hiển thị danh mục sản phẩm

##### `SanPhamController.java`
**👤 Người phụ trách**: Người 3 - Customer Website & Shopping  
**🎯 Chức năng**: Trang sản phẩm  
**📝 Chi tiết**:
- `/sanpham` - Danh sách sản phẩm với filter, search, phân trang
- `/sanpham/{id}` - Chi tiết sản phẩm với đánh giá
- **TODO NGƯỜI 3**: 
  - Implement tìm kiếm, lọc theo loại, giá
  - Hiển thị sản phẩm liên quan
  - Tích hợp đánh giá sản phẩm

##### `GioHangController.java`
**👤 Người phụ trách**: Người 3 - Customer Website & Shopping  
**🎯 Chức năng**: Quản lý giỏ hàng  
**📝 Chi tiết**:
- `/giohang` - Trang giỏ hàng
- `/api/giohang/**` - AJAX APIs cho add/update/remove
- **TODO NGƯỜI 3**:
  - Tạo GioHangService
  - Implement AJAX operations
  - Real-time update tổng tiền

##### `CheckoutController.java`
**👤 Người phụ trách**: Người 4 - Order Management & Checkout  
**🎯 Chức năng**: Đặt hàng và thanh toán  
**📝 Chi tiết**:
- `/checkout` - Trang thanh toán
- `/checkout/process` - Xử lý đặt hàng
- `/checkout/success/{id}` - Trang cảm ơn
- **TODO NGƯỜI 4**:
  - Tạo DonHangService và ThanhToanService
  - Implement logic đặt hàng
  - Validation và error handling

##### `ProfileController.java`
**👤 Người phụ trách**: Người 4 - Order Management & Checkout  
**🎯 Chức năng**: Thông tin cá nhân và lịch sử đơn hàng  
**📝 Chi tiết**:
- `/profile` - Thông tin cá nhân và lịch sử đơn hàng
- `/profile/orders/{id}` - Chi tiết đơn hàng
- `/profile/update` - Cập nhật thông tin
- **TODO NGƯỜI 4**:
  - Hiển thị lịch sử đơn hàng có phân trang
  - Form cập nhật thông tin cá nhân
  - Đổi mật khẩu

##### `ApiController.java`
**👤 Người phụ trách**: Tùy theo API (Người 3, 4, 5)  
**🎯 Chức năng**: REST APIs cho AJAX calls  
**📝 Chi tiết**:
- Chứa các REST endpoints
- **TODO**: Kiểm tra và phân loại APIs theo chức năng

---

## 📊 **TÌNH TRẠNG HIỆN TẠI**

### ✅ **HOÀN THÀNH (65%)**
- **Người 1**: Database, Entities, Repositories, Configuration ✅
- **Người 2**: Authentication, Security, Login/Register ✅  
- **Phần khung**: All controllers có cấu trúc cơ bản ✅

### 🔄 **CẦN HOÀN THIỆN (35%)**
- **Người 3** (20%): SanPhamService, HomeController, SanPhamController, GioHangController
- **Người 4** (10%): DonHangService, CheckoutController, ProfileController  
- **Người 5** (5%): ThongKeService, Admin Dashboard nâng cao

### 📋 **CHECKLIST CHO TỪNG NGƯỜI**

#### **NGƯỜI 3 - Customer Website & Shopping**
- [ ] Hoàn thiện `SanPhamService.java` (uncomment và implement)
- [ ] Cập nhật `HomeController.java` (inject services)  
- [ ] Hoàn thiện `SanPhamController.java` (tìm kiếm, filter)
- [ ] Tạo `GioHangService.java` và hoàn thiện `GioHangController.java`
- [ ] Cập nhật templates: `home.html`, `sanpham.html`, `giohang.html`

#### **NGƯỜI 4 - Order Management & Checkout**  
- [ ] Tạo `DonHangService.java` và `ThanhToanService.java`
- [ ] Hoàn thiện `CheckoutController.java` (logic đặt hàng)
- [ ] Hoàn thiện `ProfileController.java` (lịch sử đơn hàng)
- [ ] Tạo templates: `checkout.html`, `profile.html`, `order-detail.html`

#### **NGƯỜI 5 - Admin Dashboard & Reports**
- [ ] Tạo `ThongKeService.java` và `AdminService.java`  
- [ ] Hoàn thiện `DashboardController.java` (thống kê nâng cao)
- [ ] Tạo admin templates với charts và reports
- [ ] Implement export Excel/PDF

---

## 🚀 **HƯỚNG DẪN CHẠY DỰ ÁN**

### 1. **Setup Database**
```sql
-- Import file này vào SQL Server
asmfpt5 22.23.14.sql
```

### 2. **Cấu hình kết nối**
```properties
# File: application.properties (đã có)
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=WebBanHangTet
spring.datasource.username=sa
spring.datasource.password=Aa@123456
```

### 3. **Chạy ứng dụng**
```bash
# Từ thư mục root
./mvnw spring-boot:run
# Hoặc
mvn spring-boot:run
```

### 4. **Truy cập**
- **Trang chủ**: http://localhost:8080
- **Admin**: http://localhost:8080/admin
- **Login**: http://localhost:8080/login

---

## 🏆 **KẾT LUẬN**

Dự án đã có cơ sở hạ tầng vững chắc với 47 files Java được tổ chức rõ ràng. Database layer và Authentication đã hoàn thành 100%. Còn lại cần hoàn thiện Service layer và một số Controllers để có website bán hàng Tết hoàn chỉnh.

**Ước tính thời gian hoàn thành**: 2-3 tuần nếu 3 người (Người 3, 4, 5) làm song song theo TODO đã phân chia.
