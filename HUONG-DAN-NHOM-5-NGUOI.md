# 📋 PHÂN CHIA CÔNG VIỆC NHÓM 5 NGƯỜI - DỰ ÁN BÁN ĐỒ TẾT

## 🎯 TỔNG QUAN DỰ ÁN
- **Chủ đề**: Website bán đồ Tết (Spring Boot + Thymeleaf + SQL Server)
- **Assignment**: Java 5 - 60% tổng điểm
- **Mục tiêu**: Grade A (90%+ yêu cầu)
- **Timeline**: 3-4 tuần

---

## 👑 NGƯỜI 1: DATABASE & CORE ENTITIES (LEADER)
**Vai trò**: Quản lý database và các entity class

### 📁 **FILES PHỤTRÁCH**:
```
src/main/java/com/example/projectend/
├── entity/
│   ├── ✅ VaiTro.java (Đã hoàn thành)
│   ├── ✅ TaiKhoan.java (Đã hoàn thành) 
│   ├── ✅ LoaiSanPham.java (Đã hoàn thành)
│   ├── ✅ SanPham.java (Đã hoàn thành - vừa rename từ Product.java)
│   ├── ❌ DiaChi.java (Cần tạo)
│   ├── ❌ GioHang.java (Cần tạo)
│   ├── ❌ DonHang.java (Cần tạo)
│   └── ❌ DonHangChiTiet.java (Cần tạo)
├── repository/
│   ├── ✅ VaiTroRepository.java (Đã có)
│   ├── ✅ TaiKhoanRepository.java (Đã có)
│   ├── ✅ LoaiSanPhamRepository.java (Đã có)
│   ├── ✅ SanPhamRepository.java (Đã có)
│   └── ❌ Các repository còn lại (Cần tạo)
└── src/main/resources/
    └── ❌ data.sql (Tạo dữ liệu mẫu)
```

### 🎯 **NHIỆM VỤ CỤ THỂ**:
1. **Tuần 1**: Tạo 4 Entity còn lại (DiaChi, GioHang, DonHang, DonHangChiTiet)
2. **Tuần 2**: Tạo tất cả Repository interfaces
3. **Tuần 3**: Tạo dữ liệu mẫu (10 loại, 200 sản phẩm, 5 users, 1 admin)
4. **Tuần 4**: Hỗ trợ các thành viên khác với database issues

### 📝 **HƯỚNG DẪN THỰC HIỆN**:
- Theo đúng schema SQL đã cung cấp
- Sử dụng JPA annotations (@Entity, @Table, @Column)
- Tạo relationships (@ManyToOne, @OneToMany)
- Validate với @NotNull, @NotBlank

---

## 🔐 NGƯỜI 2: AUTHENTICATION & SECURITY
**Vai trò**: Xử lý đăng nhập, bảo mật và phân quyền

### 📁 **FILES PHỤTRÁCH**:
```
src/main/java/com/example/projectend/
├── config/
│   ├── ✅ SecurityConfig.java (Đã có base)
│   └── ❌ AuthConfig.java (Cần tạo)
├── controller/
│   ├── ✅ AuthController.java (Đã có base)
│   └── ❌ AccountController.java (Cần tạo)
├── service/
│   ├── ❌ AuthService.java (Cần tạo)
│   ├── ❌ MailService.java (Cần tạo)
│   └── ❌ UserDetailsServiceImpl.java (Cần tạo)
└── src/main/resources/templates/
    ├── ✅ login1.html (Đã có)
    └── ❌ register.html, forgot-password.html (Cần tạo)
```

### 🎯 **NHIỆM VỤ CỤ THỂ**:
1. **Tu ần 1**: Setup Spring Security configuration
2. **Tuần 2**: Implement login/logout/register controllers  
3. **Tuần 3**: Email verification service
4. **Tuần 4**: Role-based authorization (Admin vs User)

### 📝 **HƯỚNG DẪN THỰC HIỆN**:
- Sử dụng BCryptPasswordEncoder cho mật khẩu
- Session-based authentication (không dùng JWT)
- Email service với Gmail SMTP
- Interceptor cho phân quyền

---

## 🎨 NGƯỜI 3: FRONTEND & CUSTOMER WEBSITE
**Vai trò**: Giao diện khách hàng và tương tác người dùng

### 📁 **FILES PHỤTRÁCH**:
```
src/main/java/com/example/projectend/controller/
├── ✅ HomeController.java (Đã có base)
├── ✅ SanPhamController.java (Đã có base) 
├── ✅ GioHangController.java (Đã có base)
└── ❌ OrderController.java (Cần tạo)

src/main/resources/
├── static/
│   ├── css/ (✅ Đã có: home.css, sanpham.css, giohang.css)
│   ├── js/ (✅ Đã có: main.js với jQuery + AJAX)
│   └── img/ (✅ Đã có images)
└── templates/
    ├── ✅ home.html (Cần update)
    ├── ✅ home-real.html (Template mẫu sẵn)
    ├── ✅ sanpham.html (Cần update)  
    ├── ✅ giohang.html (Cần update)
    └── ❌ product-detail.html, checkout.html (Cần tạo)
```

### 🎯 **NHIỆM VỤ CỤ THỂ**:
1. **Tuần 1**: Update templates sử dụng Bootstrap + jQuery (dùng home-real.html làm mẫu)
2. **Tuần 2**: Implement product display với AJAX
3. **Tuần 3**: Cart management (add/remove/update quantity)
4. **Tuần 4**: Order checkout process

### 📝 **HƯỚNG DẪN THỰC HIỆN**:
- Sử dụng file `main.js` đã có (jQuery + Bootstrap pattern)
- AJAX calls đến `/api/` endpoints
- Responsive design với Bootstrap grid
- Form validation với JavaScript

---

## 🛠️ NGƯỜI 4: ADMIN PANEL & MANAGEMENT
**Vai trò**: Công cụ quản trị và CRUD operations

### 📁 **FILES PHỤTRÁCH**:
```
src/main/java/com/example/projectend/controller/
├── ❌ CategoryAdminController.java (Cần tạo)
├── ❌ ProductAdminController.java (Cần tạo)
├── ❌ OrderAdminController.java (Cần tạo)
└── ❌ AccountAdminController.java (Cần tạo)

src/main/resources/templates/admin/
├── ❌ layout.html (Base template)
├── ❌ dashboard.html (Trang chủ admin)
├── ❌ category.html (CRUD danh mục)
├── ❌ product.html (CRUD sản phẩm)
├── ❌ order.html (Quản lý đơn hàng)
└── ❌ account.html (Quản lý user)

src/main/java/com/example/projectend/service/
└── ❌ FileService.java (Upload hình ảnh)
```

### 🎯 **NHIỆM VỤ CỤ THỂ**:
1. **Tuần 1**: Tạo admin layout và dashboard
2. **Tuần 2**: CRUD categories và products (có upload ảnh)
3. **Tuần 3**: Order management system
4. **Tuần 4**: User management và phân quyền

### 📝 **HƯỚNG DẪN THỰC HIỆN**:
- Admin area riêng biệt: `/admin/**`
- Upload file với MultipartFile
- Pagination cho danh sách
- Search và filter functionality

---

## 📊 NGƯỜI 5: SERVICES & REPORTS
**Vai trò**: Business logic và báo cáo thống kê

### 📁 **FILES PHỤTRÁCH**:
```
src/main/java/com/example/projectend/service/
├── ✅ ProductService.java (Đã có interface)
├── ✅ CategoryService.java (Đã có interface)
├── ❌ ProductServiceImpl.java (Cần implement)
├── ❌ CategoryServiceImpl.java (Cần implement)
├── ❌ CartService.java (Cần tạo)
├── ❌ OrderService.java (Cần tạo)
├── ❌ ReportService.java (Cần tạo)
└── ❌ CookieService.java (Cần tạo)

src/main/java/com/example/projectend/controller/
├── ✅ ApiController.java (Đã có base cho AJAX)
└── ❌ ReportController.java (Cần tạo)

src/main/resources/templates/admin/
├── ❌ revenue.html (Báo cáo doanh thu)
└── ❌ vip-customers.html (Khách hàng VIP)
```

### 🎯 **NHIỆM VỤ CỤ THỂ**:
1. **Tuần 1**: Implement tất cả Service classes
2. **Tuần 2**: Business logic cho cart và order
3. **Tuần 3**: Report service và statistics
4. **Tuần 4**: Performance optimization

### 📝 **HƯỚNG DẪN THỰC HIỆN**:
- Implement interface patterns
- Transaction management với @Transactional
- Query optimization với @Query
- Statistics với native SQL

---

## 📚 GIẢI THÍCH CHI TIẾT TỪNG FILE HIỆN CÓ

### 🗄️ **ENTITY LAYER** (Người 1 quản lý)

#### `VaiTro.java` - Quản lý vai trò người dùng
```java
// Bảng roles: Admin (1), Nhân viên (2), Khách hàng (3)
@Entity
@Table(name = "VaiTro")
public class VaiTro {
    private Integer maVT;    // Primary key
    private String tenVT;    // Tên vai trò
}
```

#### `TaiKhoan.java` - Thông tin người dùng  
```java
// Bảng users với authentication info
@Entity  
@Table(name = "TaiKhoan")
public class TaiKhoan {
    private Integer maTK;        // Primary key
    private String hoTen;        // Họ tên
    private String email;        // Email (unique)
    private String matKhau;      // Password (BCrypt)
    private VaiTro vaiTro;      // Foreign key to VaiTro
}
```

#### `LoaiSanPham.java` - Danh mục sản phẩm
```java
// Categories: Bánh kẹo, Giỏ quà, Đồ trang trí...
@Entity
@Table(name = "LoaiSanPham") 
public class LoaiSanPham {
    private Integer maLoai;      // Primary key
    private String tenLoai;      // Tên danh mục
}
```

#### `SanPham.java` - Sản phẩm đồ Tết
```java
// Products với full info
@Entity
@Table(name = "SanPham")
public class SanPham {
    private Integer maSP;            // Primary key
    private String tenSP;            // Tên sản phẩm
    private String moTa;             // Mô tả
    private BigDecimal gia;          // Giá bán
    private Integer soLuong;         // Tồn kho
    private LoaiSanPham loaiSanPham; // Foreign key
    private String hinhAnh;          // Đường dẫn ảnh
}
```

### 🌐 **CONTROLLER LAYER**

#### `HomeController.java` - Trang chủ
```java
// Hiển thị sản phẩm trên trang chủ
@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        // Load featured products, new products, categories
        return "home";
    }
}
```

#### `ApiController.java` - REST API cho AJAX
```java
// Cung cấp API endpoints cho JavaScript
@RestController
@RequestMapping("/api")
public class ApiController {
    @PostMapping("/cart/add")     // Thêm vào giỏ
    @DeleteMapping("/cart/remove/{id}")  // Xóa khỏi giỏ
    @GetMapping("/products/search")      // Tìm kiếm
}
```

### 🎨 **VIEW LAYER** (Templates)

#### `home-real.html` - Template mẫu chuẩn thực tế
```html
<!-- Bootstrap + jQuery + Thymeleaf -->
<!-- Pattern chuẩn công ty: responsive, AJAX, toast notifications -->
<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script> 
<script src="/js/main.js"></script>
```

#### `main.js` - JavaScript chuẩn thực tế
```javascript
// jQuery pattern cho AJAX calls
$('.add-to-cart').click(function(e) {
    $.ajax({
        url: '/api/cart/add',
        method: 'POST',
        success: function(response) {
            showToast('Đã thêm vào giỏ!', 'success');
        }
    });
});
```

---

## 📈 TIẾN ĐỘ THEO TUẦN

### **TUẦN 1: FOUNDATION (Người 1 lead)**
- ✅ Database entities hoàn chỉnh
- ✅ Repository interfaces  
- ✅ Basic configuration

### **TUẦN 2: CORE FEATURES (Tất cả cùng làm)**
- Người 2: Authentication
- Người 3: Product display  
- Người 4: Admin base
- Người 5: Service implementations

### **TUẦN 3: ADVANCED FEATURES**
- Người 2: Email verification
- Người 3: Cart management
- Người 4: CRUD operations  
- Người 5: Reports

### **TUẦN 4: INTEGRATION & TESTING**
- Bug fixes và optimization
- UI/UX improvements
- Testing tổng thể
- Demo preparation

---

## 🎯 CHECKLIST HOÀN THÀNH (Grade A)

### **Phần 1: Website bán hàng (70%)**
- [ ] Trưng bày hàng hóa (Người 3)
- [ ] Quản lý giỏ hàng (Người 3)  
- [ ] Quản lý tài khoản (Người 2)
- [ ] Đặt hàng và quản lý đơn hàng (Người 3, 5)
- [ ] Bảo mật ứng dụng (Người 2)

### **Phần 2: Công cụ quản trị (30%)**  
- [ ] CRUD loại hàng (Người 4)
- [ ] CRUD hàng hóa (Người 4)
- [ ] CRUD người dùng (Người 4)
- [ ] CRUD đơn hàng (Người 4)
- [ ] Thống kê doanh thu (Người 5)
- [ ] Khách hàng VIP (Người 5)

---

## 🚀 QUY TẮC TEAMWORK

1. **Git Workflow**: Mỗi người 1 branch riêng
2. **Code Review**: Leader (Người 1) review trước khi merge  
3. **Daily Standup**: Check progress hàng ngày
4. **Documentation**: Comment code tiếng Việt
5. **Testing**: Test function trước khi commit

**DỰ ÁN NÀY THIẾT KẾ ĐỂ ĐẠT GRADE A (90%+) NẾU TEAM LÀMĐÚNG TIMELINE!** 🎉
