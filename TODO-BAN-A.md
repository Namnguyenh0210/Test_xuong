# 🅰️ CÔNG VIỆC CỦA BẠN A - DATABASE & ENTITY

## 🎯 NHIỆM VỤ: Tạo database và các class Entity

### ✅ DANH SÁCH VIỆC CẦN LÀM:

#### 📋 Tuần 1:
- [ ] Cài đặt SQL Server Express
- [ ] Tạo database tên `monatrungtu_db`
- [ ] Tạo Entity `User.java`
- [ ] Tạo Entity `Product.java` 
- [ ] Test kết nối database

#### 📋 Tuần 2:
- [ ] Tạo Entity `Category.java`
- [ ] Tạo Entity `Order.java`
- [ ] Tạo Entity `Cart.java`
- [ ] Tạo các Repository classes
- [ ] Thêm dữ liệu mẫu

---

## 📖 HƯỚNG DẪN CHI TIẾT

### 1. Cài SQL Server:
- Tải SQL Server Express (miễn phí)
- Cài với tên instance: `SQLEXPRESS`
- Username: `sa`, Password: `123456`

### 2. Tạo Entity đầu tiên - User.java:
```java
// Tạo file: src/main/java/com/example/projectend/entity/User.java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String phone;
    
    // Constructor, getter, setter (tự tạo)
}
```

### 3. Tạo Entity Product.java:
```java
// Tạo file: src/main/java/com/example/projectend/entity/Product.java
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Integer quantity;
    
    // Constructor, getter, setter
}
```

### 4. Cấu hình database trong application.properties:
```properties
# Thay thế config H2 bằng SQL Server:
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=monatrungtu_db
spring.datasource.username=sa
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
```

### 5. Tạo Repository:
```java
// Tạo file: src/main/java/com/example/projectend/repository/UserRepository.java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
```

---

## 🎯 MỤC TIÊU CỦA TỪNG TUẦN

### Tuần 1 - Cơ bản:
- Setup SQL Server thành công
- Tạo được 2 Entity: User, Product
- App chạy không lỗi
- Database tạo table tự động

### Tuần 2 - Hoàn thiện:
- Thêm các Entity còn lại
- Tạo Repository cho tất cả Entity
- Thêm dữ liệu mẫu (Insert SQL)
- Test query cơ bản

---

## 🆘 KHI GẶP KHÓĐÓ

### Lỗi kết nối SQL Server:
1. Kiểm tra SQL Server đã chạy chưa
2. Kiểm tra port 1433 có mở không
3. Thử kết nối bằng SQL Server Management Studio trước

### Lỗi Entity:
1. Nhớ thêm `@Entity` trên class
2. Nhớ thêm `@Id` cho primary key
3. Constructor phải có default constructor

### File cần tạo:
```
entity/
├── User.java          ← Tuần 1
├── Product.java       ← Tuần 1  
├── Category.java      ← Tuần 2
├── Order.java         ← Tuần 2
└── Cart.java          ← Tuần 2

repository/
├── UserRepository.java      ← Tuần 2
├── ProductRepository.java   ← Tuần 2
└── ... các repo khác        ← Tuần 2
```

---

## 📞 HỖ TRỢ

- **Google**: "Spring Boot JPA Entity example"
- **YouTube**: "Spring Boot database tutorial"
- **Hỏi team**: Khi không hiểu
- **Test**: Sau mỗi Entity xong, chạy app để test

## ✨ LƯU Ý

- Làm từng bước một, đừng làm tất cả cùng lúc
- Test sau mỗi Entity xong
- Commit code thường xuyên
- Hỏi khi không biết, đừng ngồi mắc kẹt
