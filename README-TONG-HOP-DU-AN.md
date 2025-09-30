# 🎯 DỰ ÁN WEBSITE BÁN ĐỒ TẾT NGUYÊN ĐÁN
## Nhóm 5 Người - Spring Boot + SQL Server

---

## 📋 **TỔNG QUAN DỰ ÁN**

**Tên dự án:** Website Bán Đồ Tết Nguyên Đán  
**Công nghệ:** Spring Boot 3.2.0 + SQL Server + Thymeleaf + Bootstrap  
**Tham khảo:** https://tetviet.monamedia.net/  
**Database:** WebBanHangTet (12 bảng, kết nối từ bên ngoài)

### 🎨 **Sản phẩm bán:**
- 🧺 Giỏ quà Tết (combo đa dạng)
- 🎁 Hộp quà Tết (cao cấp, sang trọng)  
- 🍯 Mứt - Bánh kẹo (đặc sản truyền thống)
- 💰 Bao lì xì & Trang trí (phụ kiện may mắn)

---

## ✅ **TIẾN ĐỘ DỰ ÁN**

### 🟢 **ĐÃ HOÀN THÀNH 100% - NGƯỜI 1 (Database Design & Backend Core)**

#### 1. **Database Schema WebBanHangTet** ✅
```sql
📁 /database/create_database.sql
✅ 12 bảng đầy đủ theo yêu cầu:
   - VaiTro (3 vai trò: Admin, Staff, Customer)
   - TaiKhoan (với mật khẩu NVARCHAR plain text)
   - DiaChi (địa chỉ giao hàng)
   - LoaiSanPham (4 loại: Giỏ quà, Hộp quà, Mứt-Bánh kẹo, Bao lì xì)
   - TrangThaiSanPham (Còn hàng, Hết hàng, Ngừng kinh doanh)
   - SanPham (sản phẩm chính với giá, số lượng, hình ảnh)
   - NhapKho (quản lý nhập kho)
   - GioHang (giỏ hàng với constraint UNIQUE)
   - TrangThaiDonHang (4 trạng thái đơn hàng)
   - PhuongThucThanhToan (3 phương thức: COD, Chuyển khoản, Momo)
   - DonHang (đơn hàng chính)
   - DonHangChiTiet (chi tiết từng sản phẩm)
   - ThongKe (báo cáo doanh thu)

✅ Dữ liệu mẫu hoàn chỉnh:
   - 3 tài khoản test (Admin/Staff/Customer)
   - 4 sản phẩm đa dạng (500k - 1.2M)
   - 2 đơn hàng mẫu với chi tiết
   - Quan hệ Foreign Key đầy đủ
```

#### 2. **Entity Classes (13 entities)** ✅
```java
📁 /src/main/java/com/example/projectend/entity/
✅ VaiTro.java - Mapping bảng VaiTro với JPA annotations
✅ TaiKhoan.java - Entity chính với quan hệ ManyToOne đến VaiTro
✅ DiaChi.java - Địa chỉ giao hàng liên kết với TaiKhoan
✅ LoaiSanPham.java - Danh mục sản phẩm
✅ TrangThaiSanPham.java - Trạng thái sản phẩm
✅ SanPham.java - Entity sản phẩm chính với BigDecimal cho giá
✅ NhapKho.java - Quản lý nhập kho với LocalDateTime
✅ GioHang.java - Giỏ hàng với UniqueConstraint
✅ TrangThaiDonHang.java - Trạng thái đơn hàng
✅ PhuongThucThanhToan.java - Phương thức thanh toán
✅ DonHang.java - Đơn hàng chính với các quan hệ
✅ DonHangChiTiet.java - Chi tiết đơn hàng với computed method getThanhTien()
✅ ThongKe.java - Báo cáo với LocalDate và BigDecimal

🔧 Tất cả entities đã có:
   - Constructors đầy đủ (default + parameterized)
   - Getters/Setters hoàn chỉnh
   - JPA annotations chính xác
   - Quan hệ Foreign Key mapping đúng
```

#### 3. **Repository Interfaces (6 repositories)** ✅
```java
📁 /src/main/java/com/example/projectend/repository/
✅ VaiTroRepository.java - JpaRepository<VaiTro, Integer>
✅ TaiKhoanRepository.java - Có TODO method cho authentication
✅ SanPhamRepository.java - Có TODO methods cho tìm kiếm, lọc
✅ LoaiSanPhamRepository.java - Có TODO cho menu danh mục
✅ GioHangRepository.java - Có TODO cho giỏ hàng operations
✅ DonHangRepository.java - Có TODO cho quản lý đơn hàng

🔧 Tất cả repositories:
   - Extend JpaRepository với type safety
   - Có @Repository annotation
   - Comment TODO rõ ràng cho từng người
   - Sẵn sàng cho custom query methods
```

#### 4. **Controller Classes với TODO Framework** ✅
```java
📁 /src/main/java/com/example/projectend/controller/
✅ ProjectendApplication.java - Main Spring Boot class
✅ HomeController.java - Trang chủ với @GetMapping("/") và ("/home")
✅ AuthController.java - Login page với TODO cho Người 2
✅ SanPhamController.java - Danh sách sản phẩm với TODO cho Người 3
✅ GioHangController.java - Giỏ hàng với TODO cho Người 3
✅ ProfileController.java - Profile với TODO cho Người 2
✅ GioiThieuController.java - Giới thiệu (Người 3)
✅ KienThucController.java - Blog Tết (Người 3)
✅ LienHeController.java - Liên hệ (Người 3)
✅ ApiController.java - REST APIs với TODO cho tất cả

🔧 Tất cả controllers:
   - Có @Controller hoặc @RestController
   - Basic @GetMapping routes
   - Model attributes setup
   - TODO comments chi tiết cho từng người
```

#### 5. **Configuration Files** ✅
```properties
✅ pom.xml - Dependencies hoàn chỉnh:
   - spring-boot-starter-web
   - spring-boot-starter-thymeleaf  
   - spring-boot-starter-data-jpa
   - spring-boot-starter-security
   - mssql-jdbc driver
   - spring-boot-starter-validation
   - spring-boot-devtools

✅ application.properties - Cấu hình đầy đủ:
   - SQL Server connection (WebBanHangTet database)
   - JPA/Hibernate settings (ddl-auto=none)
   - Thymeleaf configuration với UTF-8
   - File upload settings (5MB)
   - Logging configuration
   - Static resources mapping

✅ SecurityConfig.java - Bảo mật cơ bản:
   - Permit public pages (/, /home, /sanpham, etc.)
   - Permit static resources
   - Basic form login setup
   - CSRF disabled for development
   - TODO cho Người 2 về UserDetailsService
```

#### 6. **Test Setup** ✅
```bash
✅ Maven project structure hoàn chỉnh
✅ Compilation success: mvn clean compile
✅ Database connection ready
✅ Test accounts có sẵn:
   - admin@webtet.com / admin123 (Admin)  
   - staff@webtet.com / staff123 (Staff)
   - customer@webtet.com / cust123 (Customer)
✅ Spring Boot có thể run: mvn spring-boot:run
✅ Access http://localhost:8080 ready
```

---

## 🔴 **CHƯA HOÀN THÀNH - CẦN PHÂN CHIA**

### 👤 **NGƯỜI 2 - Authentication & Authorization**
**Deadline:** [Điền deadline]  
**Trách nhiệm:** Hệ thống bảo mật và phân quyền (mật khẩu plain text)

#### 📋 **Nhiệm vụ cụ thể:**
1. **Hoàn thiện SecurityConfig.java**
   - Cấu hình UserDetailsService
   - Phân quyền theo vai trò (Admin/Staff/Customer)
   - Session management

2. **Authentication Service**
   - Tạo UserDetailsServiceImpl
   - Login/Logout functionality với plain text password
   - Remember me feature
   - Account lockout sau n lần sai

3. **Hoàn thiện AuthController.java**
   - POST /login - Xử lý đăng nhập (so sánh plain text)
   - GET/POST /register - Đăng ký tài khoản mới
   - Email verification (optional)
   - Forgot password (optional)

4. **Cập nhật TaiKhoanRepository.java**
   ```java
   Optional<TaiKhoan> findByEmail(String email);
   boolean existsByEmail(String email);
   Optional<TaiKhoan> findByEmailAndMatKhau(String email, String matKhau);
   ```

5. **Hoàn thiện ProfileController.java**
   - Hiển thị thông tin user đang đăng nhập
   - Cập nhật profile
   - Đổi mật khẩu (plain text)
   - Lịch sử đơn hàng

#### ✅ **Deliverables:**
- [ ] Login/Register hoạt động đầy đủ
- [ ] Phân quyền Admin/Staff/Customer
- [ ] Profile management
- [ ] Unit tests cho authentication

---

### 🎨 **NGƯỜI 3 - Frontend & Customer Website**
**Deadline:** [Điền deadline]  
**Trách nhiệm:** Giao diện khách hàng và business logic

#### 📋 **Nhiệm vụ cụ thể:**
1. **Service Classes**
   ```java
   📁 /src/main/java/com/example/projectend/service/
   - SanPhamService.java - Logic sản phẩm
   - GioHangService.java - Logic giỏ hàng  
   - DonHangService.java - Logic đơn hàng
   - LoaiSanPhamService.java - Logic danh mục
   ```

2. **Hoàn thiện Controllers**
   - **HomeController:** Hiển thị sản phẩm nổi bật, mới nhất
   - **SanPhamController:** Danh sách, chi tiết, tìm kiếm, lọc
   - **GioHangController:** CRUD giỏ hàng, checkout
   - **GioiThieuController:** Nội dung trang giới thiệu
   - **KienThucController:** Blog văn hóa Tết
   - **LienHeController:** Form liên hệ

3. **Cập nhật Repository Methods**
   ```java
   // SanPhamRepository
   List<SanPham> findByLoaiSanPham(LoaiSanPham loai);
   List<SanPham> findByTenSPContaining(String keyword);
   List<SanPham> findTop6ByOrderByNgayTaoDesc();
   
   // GioHangRepository  
   List<GioHang> findByTaiKhoan(TaiKhoan taiKhoan);
   Optional<GioHang> findByTaiKhoanAndSanPham(TaiKhoan tk, SanPham sp);
   ```

4. **Thymeleaf Templates**
   - Sửa tất cả templates trong `/templates/`
   - Responsive design với Bootstrap
   - AJAX cho giỏ hàng
   - SEO optimization

5. **Static Resources**
   - Tối ưu CSS, JS trong `/static/`
   - Responsive mobile-first
   - Image optimization

#### ✅ **Deliverables:**
- [ ] Website hoạt động đầy đủ cho khách hàng
- [ ] Giỏ hàng và checkout flow
- [ ] Tìm kiếm và lọc sản phẩm
- [ ] Responsive trên mobile

---

### ⚙️ **NGƯỜI 4 - Admin Panel & Product Management**
**Deadline:** [Điền deadline]  
**Trách nhiệm:** Quản trị hệ thống và sản phẩm

#### 📋 **Nhiệm vụ cụ thể:**
1. **Admin Controllers**
   ```java
   📁 /controller/admin/
   - AdminHomeController.java - Dashboard admin
   - AdminSanPhamController.java - CRUD sản phẩm
   - AdminDonHangController.java - Quản lý đơn hàng
   - AdminTaiKhoanController.java - Quản lý user
   - AdminThongKeController.java - Báo cáo cơ bản
   ```

2. **Product Management**
   - CRUD sản phẩm đầy đủ
   - Upload và quản lý hình ảnh
   - Batch import sản phẩm (Excel/CSV)
   - Quản lý danh mục sản phẩm

3. **Order Management**
   - Xem danh sách đơn hàng
   - Cập nhật trạng thái đơn hàng
   - In hóa đơn/phiếu giao hàng
   - Quản lý phương thức thanh toán

4. **User Management**
   - Quản lý tài khoản khách hàng
   - Phân quyền staff
   - Block/Unblock accounts

5. **Admin Templates**
   - Admin dashboard với charts
   - Responsive admin interface
   - Data tables với pagination
   - Form validation

#### ✅ **Deliverables:**
- [ ] Admin panel hoạt động đầy đủ
- [ ] CRUD sản phẩm với upload ảnh
- [ ] Quản lý đơn hàng và user
- [ ] Dashboard với số liệu cơ bản

---

### 📊 **NGƯỜI 5 - Reports & Analytics**
**Deadline:** [Điền deadline]  
**Trách nhiệm:** Báo cáo và phân tích dữ liệu

#### 📋 **Nhiệm vụ cụ thể:**
1. **ThongKe Service & Repository**
   ```java
   // ThongKeRepository methods
   List<ThongKe> findByNgayBaoCaoBetween(LocalDate start, LocalDate end);
   
   // DonHangRepository for reports
   @Query("SELECT SUM(dh.tongTien) FROM DonHang dh WHERE dh.ngayDat BETWEEN :start AND :end")
   BigDecimal calculateRevenueByDateRange(LocalDateTime start, LocalDateTime end);
   ```

2. **Report Controllers**
   ```java
   📁 /controller/reports/
   - ReportController.java - Báo cáo tổng quan
   - RevenueController.java - Báo cáo doanh thu
   - ProductAnalyticsController.java - Phân tích sản phẩm
   ```

3. **Analytics Features**
   - Doanh thu theo ngày/tháng/quý
   - Top sản phẩm bán chạy
   - Phân tích khách hàng
   - Conversion rate
   - Seasonal trends (Tết)

4. **Charts & Visualization**
   - Chart.js integration
   - Revenue charts
   - Product performance charts
   - Customer analytics

5. **Export Features**
   - Export Excel reports
   - PDF invoice generation
   - Scheduled reports (optional)

#### ✅ **Deliverables:**
- [ ] Báo cáo doanh thu chi tiết
- [ ] Analytics dashboard với charts
- [ ] Export Excel/PDF
- [ ] Automated daily/monthly reports

---

## 🚀 **HƯỚNG DẪN SETUP & TEST**

### 1. **Database Setup**
```sql
-- Chạy trong SQL Server Management Studio
-- File: /database/create_database.sql
-- Tạo database WebBanHangTet với dữ liệu mẫu
```

### 2. **Application Properties**
```properties
# Cập nhật thông tin kết nối database nếu cần
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=WebBanHangTet
spring.datasource.username=sa
spring.datasource.password=123456
```

### 3. **Test Commands**
```bash
# Clean và compile project
mvn clean compile

# Chạy ứng dụng
mvn spring-boot:run

# Truy cập ứng dụng
http://localhost:8080
```

### 4. **Test Accounts**
```
Admin: admin@webtet.com / admin123
Staff: staff@webtet.com / staff123  
Customer: customer@webtet.com / cust123
```

### 5. **Kiểm tra Database**
```sql
-- Test queries để kiểm tra dữ liệu
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

---

## 📝 **QUY TẮC LÀM VIỆC**

### 🔄 **Git Workflow**
- Mỗi người tạo branch riêng: `nguoi-2-auth`, `nguoi-3-frontend`, etc.
- Commit thường xuyên với message rõ ràng
- Pull request trước khi merge vào main
- Code review bắt buộc

### 📋 **Code Standards**
- Java: CamelCase, meaningful names
- Comment bằng tiếng Việt có dấu cho dễ hiểu
- Xử lý exception đầy đủ
- Validation input đầy đủ

### 🧪 **Testing**
- Unit tests cho Service classes
- Integration tests cho Controllers
- Manual testing trước khi demo

---

## 📅 **TIMELINE & MILESTONES**

### Week 1: Setup & Authentication
- [x] Người 1: Database & Backend Core **HOÀN THÀNH** ✅
- [ ] Người 2: Authentication & Authorization

### Week 2: Frontend & Admin
- [ ] Người 3: Customer Website
- [ ] Người 4: Admin Panel

### Week 3: Analytics & Polish
- [ ] Người 5: Reports & Analytics  
- [ ] All: Bug fixes & Testing

### Week 4: Demo & Deployment  
- [ ] Final testing
- [ ] Demo preparation
- [ ] Documentation

---

## 🎯 **TIÊU CHÍ ĐÁNH GIÁ**

### Functionality (40%)
- [ ] Tất cả tính năng hoạt động đúng
- [ ] Database integration hoàn chỉnh
- [ ] Error handling tốt

### Code Quality (30%)
- [ ] Code clean, dễ đọc
- [ ] Architecture hợp lý
- [ ] Documentation đầy đủ

### UI/UX (20%)
- [ ] Giao diện đẹp, responsive  
- [ ] User experience mượt mà
- [ ] Consistent design

### Teamwork (10%)
- [ ] Phân chia công việc rõ ràng
- [ ] Collaboration tốt
- [ ] Git workflow đúng

---

## 📞 **LIÊN HỆ & HỖ TRỢ**

**Người 1 (Database Lead):** ✅ HOÀN THÀNH - Có thể hỗ trợ technical  
**Người 2 (Auth Lead):** [Điền thông tin]  
**Người 3 (Frontend Lead):** [Điền thông tin]  
**Người 4 (Admin Lead):** [Điền thông tin]  
**Người 5 (Analytics Lead):** [Điền thông tin]

---

## 🎉 **LỜI KẾT**

Dự án đã có **foundation vững chắc 100%** với:
- ✅ Database schema hoàn chỉnh với 12 bảng và dữ liệu mẫu
- ✅ 13 Entity classes với JPA mapping đúng cách  
- ✅ 6 Repository interfaces sẵn sàng cho custom methods
- ✅ 10 Controller classes với TODO framework rõ ràng
- ✅ Configuration files đầy đủ và test thành công

Từng thành viên có nhiệm vụ rõ ràng và có thể làm việc song song mà không bị conflict.

**Foundation đã sẵn sàng - Let's build amazing things! 🚀**

---
*Cập nhật lần cuối: 30/09/2025*  
*File tổng hợp duy nhất cho toàn bộ dự án*  
*Tạo bởi: Người 1 - Database Design & Backend Core*
