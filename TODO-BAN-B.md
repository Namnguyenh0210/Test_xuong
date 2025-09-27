# TODO - BẠN B: SERVICE LAYER

## 📋 MỤC TIÊU
Implement business logic và đồng bộ localStorage với database

## 🎯 NHIỆM VỤ CHÍNH
1. Implement ProductService business logic
2. **QUAN TRỌNG**: Implement CartService để sync localStorage
3. Error handling & validation
4. Transaction management

---

## 🅱️ CÔNG VIỆC CỦA BẠN B - BUSINESS LOGIC

## 🎯 NHIỆM VỤ: Tạo các Service classes và xử lý logic nghiệp vụ

### ✅ DANH SÁCH VIỆC CẦN LÀM:

#### 📋 Tuần 1:
- [ ] Tạo `UserService.java` - Xử lý người dùng
- [ ] Tạo `ProductService.java` - Xử lý sản phẩm
- [ ] Tạo validation cơ bản
- [ ] Test các Service

#### 📋 Tuần 2:
- [ ] Tạo `OrderService.java` - Xử lý đơn hàng
- [ ] Tạo `CartService.java` - Xử lý giỏ hàng
- [ ] Thêm Exception handling
- [ ] Hoàn thiện validation

---

## 📖 HƯỚNG DẪN CHI TIẾT

### 1. Tạo UserService.java:
```java
// Tạo file: src/main/java/com/example/projectend/service/UserService.java
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // Đăng ký user mới
    public User registerUser(String username, String email, String password) {
        // Kiểm tra user đã tồn tại chưa
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username đã tồn tại!");
        }
        
        // T��o user mới
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password); // Sẽ mã hóa sau
        
        return userRepository.save(user);
    }
    
    // Tìm user theo username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
            .orElse(null);
    }
}
```

### 2. Tạo ProductService.java:
```java
// Tạo file: src/main/java/com/example/projectend/service/ProductService.java
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    // Lấy tất cả sản ph��m
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    // Tìm sản phẩm theo ID
    public Product findById(Long id) {
        return productRepository.findById(id)
            .orElse(null);
    }
    
    // Tìm sản phẩm theo tên
    public List<Product> searchByName(String name) {
        return productRepository.findByNameContaining(name);
    }
    
    // Thêm sản phẩm mới (cho admin)
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
```

### 3. Tạo Validation:
```java
// Tạo file: src/main/java/com/example/projectend/service/ValidationService.java
@Service
public class ValidationService {
    
    public boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
    
    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
    
    public boolean isValidUsername(String username) {
        return username != null && username.length() >= 3;
    }
}
```

---

## 🎯 MỤC TIÊU CỦA TỪNG TUẦN

### Tuần 1 - Service cơ bản:
- UserService: đăng ký, tìm user
- ProductService: hiển thị, tìm kiếm sản phẩm
- Validation cơ bản
- Test các method

### Tuần 2 - Service nâng cao:
- OrderService: tạo đơn hàng, tính tổng tiền
- CartService: thêm/xóa sản phẩm khỏi giỏ
- Exception handling cho lỗi
- Validation phức tạp hơn

---

## 📋 CÁC SERVICE CẦN TẠO

### File cần tạo tuần 1:
```
service/
├── UserService.java         ← Đăng ký, đăng nhập
├── ProductService.java      ← Hiển thị, tìm kiếm sản phẩm
└── ValidationService.java   ← Kiểm tra dữ liệu
```

### File cần tạo tuần 2:
```
service/
├── OrderService.java        ← Tạo đơn hàng
├── CartService.java         ← Quản lý giỏ hàng
└── EmailService.java        ← Gửi email (optional)
```

---

## 🚨 LƯU Ý QUAN TRỌNG

### 1. localStorage Format hiện tại (từ giohang.js):
```javascript
// Format trong localStorage:
[
  {
    "name": "iPhone 15 Pro",
    "price": "29,990,000 VNĐ", 
    "quantity": 2,
    "image": "/img/iphone.jpg"
  }
]
```

### 2. Sync Strategy:
- Parse localStorage JSON
- Match products theo tên (fuzzy matching nếu cần)
- Validate stock availability  
- Merge với database cart
- Return result cho frontend

### 3. Error Handling:
- Tất cả method phải có try-catch
- Log errors chi tiết
- Return user-friendly messages
- Rollback transactions khi có lỗi

### 4. Transaction Management:
- Dùng @Transactional cho methods modify data
- Rollback khi có exception
- Isolate concurrent cart updates

---

## 🔧 DEBUG & TESTING

### Test localStorage sync:
```java
// Test data
String testLocalStorage = """
[
  {"name":"iPhone 15 Pro","price":"29,990,000 VNĐ","quantity":2},
  {"name":"Samsung Galaxy S24","price":"31,990,000 VNĐ","quantity":1}
]
""";

// Test sync
Map<String, Object> result = cartService.syncFromLocalStorage("test-session", testLocalStorage);
```

### Monitor SQL queries:
- Check logs có show SQL statements
- Verify N+1 query problems
- Optimize with @EntityGraph nếu cần

---

## ✅ DEFINITION OF DONE

- [ ] Tất cả ProductService methods implemented
- [ ] Tất cả CartService methods implemented  
- [ ] **syncFromLocalStorage() hoạt động với giohang.js**
- [ ] Error handling đầy đủ
- [ ] Transaction management đúng
- [ ] Unit tests pass
- [ ] Integration với Bạn A's entities works
- [ ] JSON parsing/generation works
- [ ] Logging adequate

**Estimated Time**: 2-3 tuần

**Dependencies**: Cần Bạn A hoàn thành entities trước
