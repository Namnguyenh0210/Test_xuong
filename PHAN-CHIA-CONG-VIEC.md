# HƯỚNG DẪN PHÂN CHIA CÔNG VIỆC NHÓM 5 NGƯỜI
# Assignment: Website Bán Đồ Tết - Java Spring Boot

## TỔNG QUAN DỰ ÁN
- **Chủ đề**: Website bán đồ Tết 
- **Công nghệ**: Spring Boot + Thymeleaf + JPA + SQL Server
- **Thời gian**: 3-4 tuần
- **Mục tiêu**: Đạt grade A (90%+ yêu cầu)

## PHÂN CHIA CÔNG VIỆC CHI TIẾT

### 👑 NGƯỜI 1: DATABASE & ENTITIES (LEADER)
**Vai trò**: Quản lý cơ sở dữ liệu và các entity

**Nhiệm vụ**:
1. **Tạo database SQL Server**
   - Chạy script SQL để tạo database DoTetDB
   - Cấu hình connection trong application.properties

2. **Hoàn thiện các Entity classes**
   - ✅ VaiTro.java (đã tạo)
   - ✅ TaiKhoan.java (đã tạo) 
   - ✅ LoaiSanPham.java (đã tạo)
   - ✅ SanPham.java (đã tạo)
   - ❌ DiaChi.java (cần tạo)
   - ❌ GioHang.java (cần tạo)
   - ❌ DonHang.java (cần tạo)
   - ❌ DonHangChiTiet.java (cần tạo)

3. **Tạo Repository interfaces**
   - ✅ VaiTroRepository (đã tạo)
   - ✅ TaiKhoanRepository (đã tạo)
   - ✅ LoaiSanPhamRepository (đã tạo) 
   - ✅ SanPhamRepository (đã tạo)
   - ❌ DiaChiRepository (cần tạo)
   - ❌ GioHangRepository (cần tạo)
   - ❌ DonHangRepository (cần tạo)

4. **Tạo dữ liệu mẫu (DataInitializer)**
   - 10 loại sản phẩm
   - 200 sản phẩm đồ Tết
   - 5 người dùng + 1 admin
   - Dữ liệu test cho đơn hàng

**Timeline**: Tuần 1-2

---

### 🔐 NGƯỜI 2: AUTHENTICATION & SECURITY  
**Vai trò**: Quản lý đăng nhập, bảo mật

**Nhiệm vụ**:
1. **Spring Security Configuration**
   - SecurityConfig.java
   - Password encoding (BCrypt)
   - Session management

2. **Authentication Controllers**
   - AuthController.java (login/logout)
   - RegistrationController.java
   - ForgotPasswordController.java

3. **User Management**
   - UserDetailsService implementation
   - Role-based authorization
   - Email verification service

4. **Templates**
   - login.html (cập nhật)
   - register.html
   - forgot-password.html

**Phụ thuộc**: Cần Entity TaiKhoan từ Người 1
**Timeline**: Tuần 2-3

---

### 🎨 NGƯỜI 3: FRONTEND & CUSTOMER WEBSITE
**Vai trò**: Giao diện khách hàng và trải nghiệm người dùng

**Nhiệm vụ**:
1. **Product Display Controllers**
   - ✅ HomeController.java (đã có sườn)
   - ProductController.java (detail, search, category)
   - CartController.java

2. **Customer Templates** 
   - ✅ home.html (cập nhật để lấy data từ DB)
   - product-list.html
   - product-detail.html
   - cart.html (cập nhật)
   
3. **Order Management**
   - OrderController.java (checkout, order history)
   - checkout.html
   - order-list.html
   - order-detail.html

4. **JavaScript Enhancement**
   - Cart functionality (add/remove/update)
   - AJAX cho smooth UX
   - Form validation

**Phụ thuộc**: Cần Entity & Service từ Người 1, 5
**Timeline**: Tuần 2-4

---

### 🛠️ NGƯỜI 4: ADMIN PANEL
**Vai trò**: Công cụ quản trị và CRUD operations

**Nhiệm vụ**:
1. **Admin Controllers**
   - CategoryAdminController.java (CRUD danh mục)
   - ProductAdminController.java (CRUD sản phẩm)  
   - OrderAdminController.java (quản lý đơn hàng)
   - AccountAdminController.java (quản lý user)

2. **Admin Templates**
   - admin/category.html
   - admin/product.html (với upload hình ảnh)
   - admin/order.html
   - admin/account.html
   - admin/dashboard.html

3. **File Upload Service**
   - Upload hình ảnh sản phẩm
   - Validation file types
   - Resize images

4. **Admin Security**
   - Phân quyền admin
   - Admin layout template

**Phụ thuộc**: Cần tất cả Entity từ Người 1
**Timeline**: Tuần 3-4

---

### 📊 NGƯỜI 5: SERVICES & REPORTS  
**Vai trò**: Logic nghiệp vụ và báo cáo thống kê

**Nhiệm vụ**:
1. **Service Implementations**
   - ✅ ProductService.java (đã có interface)
   - ✅ CategoryService.java (đã có interface) 
   - AccountService.java
   - CartService.java
   - OrderService.java

2. **Utility Services**
   - MailService.java (gửi email xác nhận)
   - FileService.java (xử lý upload)
   - CookieService.java
   - AuthService.java

3. **Reports & Statistics**
   - ReportController.java
   - Thống kê doanh thu theo loại hàng
   - Top 10 khách hàng VIP
   - revenue.html
   - vip.html

4. **Business Logic**
   - Xử lý đặt hàng
   - Cập nhật tồn kho
   - Tính toán giá, thuế

**Phụ thuộc**: Cần Entity từ Người 1
**Timeline**: Tuần 2-4

---

## LỊCH TRÌNH THỰC HIỆN

### TUẦN 1: FOUNDATION
- **Người 1**: Tạo database + Entity classes
- **Người 2-5**: Research và chuẩn bị

### TUẦN 2: CORE DEVELOPMENT  
- **Người 1**: Hoàn thiện Repository + Data seeding
- **Người 2**: Security configuration
- **Người 5**: Service implementations
- **Người 3,4**: Bắt đầu controllers

### TUẦN 3: FEATURE DEVELOPMENT
- **Người 3**: Customer website
- **Người 4**: Admin panel  
- **Người 2**: Authentication features
- **Người 5**: Reports

### TUẦN 4: INTEGRATION & TESTING
- **Tất cả**: Testing, bug fixes, polish UI

## QUY TẮC LÀM VIỆC NHÓM

1. **Git Workflow**
   - Mỗi người tạo branch riêng
   - Pull request trước khi merge
   - Code review bởi leader (Người 1)

2. **Naming Convention**
   - Entity: PascalCase (VaiTro, SanPham)
   - Variables: camelCase (maTK, tenSP)
   - Tables: Tiếng Việt không dấu

3. **Testing**
   - Test từng feature trước khi commit
   - Integration testing cuối tuần
   - Document bugs và fixes

## KẾT QUẢ MONG ĐỢI
- ✅ Website bán hàng hoàn chỉnh
- ✅ Admin panel đầy đủ CRUD
- ✅ Authentication & Security
- ✅ Reports & Statistics  
- ✅ Grade A (90%+ requirements)
