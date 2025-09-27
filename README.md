# 🌕 Website Bán Bánh Trung Thu - MONA

Dự án website bán bánh trung thu sử dụng **Spring Boot** + **Thymeleaf** + **SQL Server**

## 🚀 CÁCH CHẠY DỰ ÁN

### Yêu cầu:
- **Java 17** trở lên
- **Maven** đã cài đặt
- **SQL Server** (hoặc dùng H2 để test)

### Chạy ngay:
```bash
mvn spring-boot:run
```

### Truy cập:
- Trang web: http://localhost:8080
- Database console: http://localhost:8080/h2-console

---

## 👥 PHÂN CÔNG CÔNG VIỆC

Mỗi bạn làm một phần, sau đó ghép lại với nhau:

### 🅰️ **BẠN A** - Database & Entities
**Làm gì:** Tạo database và các class Entity
- Cài SQL Server, tạo database
- Tạo các file Entity: User, Product, Order, Cart...
- Tạo Repository để truy vấn database
- **File cần làm:** TODO-BAN-A.md

### 🅱️ **BẠN B** - Business Logic  
**Làm gì:** Xử lý logic nghiệp vụ
- Tạo các Service class
- Xử lý đăng ký, đăng nhập, mua hàng
- Validation dữ liệu
- **File cần làm:** TODO-BAN-B.md

### 🅲 **BẠN C** - Bảo mật & Đăng nhập
**Làm gì:** Cấu hình bảo mật
- Setup Spring Security
- Làm chức năng đăng nhập/đăng ký
- Phân quyền Admin/User
- **File cần làm:** TODO-BAN-C.md

### 🅳 **BẠN D** - Frontend & Controllers
**Làm gì:** Hoàn thiện giao diện
- Hoàn thành các Controller
- Kết nối HTML với Backend
- Test toàn bộ website
- **File cần làm:** TODO-BAN-D.md

---

## 📁 CẤU TRÚC DỰ ÁN

```
src/main/java/com/example/projectend/
├── entity/          ← BẠN A làm (User, Product, Order...)
├── repository/      ← BẠN A làm (UserRepo, ProductRepo...)
├── service/         ← BẠN B làm (UserService, ProductService...)
├── controller/      ← BẠN D làm (HomeController, AuthController...)
├── config/          ← BẠN C làm (SecurityConfig...)
└── model/           ← Tất cả dùng chung (DTO classes)

src/main/resources/
├── templates/       ← HTML files (đã có sẵn)
├── static/          ← CSS, JS, images (đã có sẵn)
└── application.properties ← Cấu hình database
```

---

## ⚡ HƯỚNG DẪN NHANH

### 1. Clone và setup:
```bash
cd projectend-spring
mvn clean install
```

### 2. Chạy thử:
```bash
mvn spring-boot:run
```

### 3. Kiểm tra:
- Vào http://localhost:8080 
- Nếu thấy trang web → OK
- Nếu lỗi → đọc lỗi trong terminal

---

## 🎯 THỨ TỰ LÀM VIỆC

### Tuần 1:
1. **Bạn A**: Tạo database và Entity classes
2. **Bạn B**: Bắt đầu tạo Service classes
3. **Bạn C**: Research Spring Security
4. **Bạn D**: Tìm hiểu Thymeleaf

### Tuần 2:
1. **Bạn A**: Hoàn thành Repository classes
2. **Bạn B**: Hoàn thành Business Logic
3. **Bạn C**: Cấu hình Security
4. **Bạn D**: Hoàn thành Controllers

### Tuần 3:
- **Tất cả**: Test và debug
- **Tích hợp**: Ghép các phần lại
- **Deploy**: Chuẩn bị demo

---

## 🆘 KHI GẶP LỖI

### Lỗi thường gặp:
1. **"Port 8080 already in use"**
   - Tắt app khác đang chạy port 8080
   - Hoặc đổi port trong `application.properties`

2. **"Could not connect to database"**
   - Kiểm tra SQL Server đã chạy chưa
   - Kiểm tra username/password trong config

3. **"ClassNotFoundException"**
   - Chạy lại: `mvn clean install`

### Cần hỗ trợ:
- Đọc file TODO của từng bạn
- Hỏi trong group chat
- Google error message

---

## 📝 GHI CHÚ QUAN TRỌNG

- **Hiện tại**: Project đã setup cơ bản, có thể chạy được
- **Database**: Đang dùng H2 (tạm thời), cần chuyển sang SQL Server
- **Security**: Đã tắt để test, cần bật lại
- **Frontend**: HTML/CSS đã có, cần kết nối với Backend

**→ Mỗi bạn đọc file TODO của mình và bắt đầu làm việc!**
