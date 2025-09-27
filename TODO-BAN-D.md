# 🅳 CÔNG VIỆC CỦA BẠN D - FRONTEND & CONTROLLERS

## 🎯 NHIỆM VỤ: Hoàn thiện Controllers và kết nối HTML với Backend

### ✅ DANH SÁCH VIỆC CẦN LÀM:

#### 📋 Tuần 1:
- [ ] Hoàn thiện `HomeController.java`
- [ ] Hoàn thiện `SanPhamController.java`
- [ ] Test hiển thị sản phẩm từ database
- [ ] Kết nối search function

#### 📋 Tuần 2:
- [ ] Hoàn thiện `GioHangController.java`
- [ ] Kết nối giỏ hàng với backend
- [ ] Test tất cả chức năng
- [ ] Fix bug và optimize

---

## 📖 HƯỚNG DẪN CHI TIẾT

### 1. Hoàn thiện HomeController.java:
```java
// File: src/main/java/com/example/projectend/controller/HomeController.java
@Controller
public class HomeController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/")
    public String home(Model model) {
        // Lấy sản phẩm từ database thay vì hardcode
        List<Product> products = productService.getAllProducts();
        
        model.addAttribute("products", products);
        model.addAttribute("pageTitle", "Trang chủ - Mona Trung Thu");
        
        return "home";
    }
    
    @GetMapping("/home")
    public String homePage(Model model) {
        return home(model);
    }
}
```

### 2. Hoàn thiện SanPhamController.java:
```java
// File: src/main/java/com/example/projectend/controller/SanPhamController.java
@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
    
    @Autowired
    private ProductService productService;
    
    // Hiển thị trang sản phẩm
    @GetMapping("")
    public String sanPham(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("pageTitle", "Sản phẩm");
        return "sanpham";
    }
    
    // Tìm kiếm sản phẩm
    @GetMapping("/search")
    public String search(@RequestParam("q") String keyword, Model model) {
        List<Product> products = productService.searchByName(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageTitle", "Kết quả tìm kiếm: " + keyword);
        return "sanpham";
    }
    
    // Xem chi tiết sản phẩm
    @GetMapping("/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/sanpham";
        }
        model.addAttribute("product", product);
        model.addAttribute("pageTitle", product.getName());
        return "product-detail"; // Cần tạo template này
    }
}
```

### 3. Hoàn thiện GioHangController.java:
```java
// File: src/main/java/com/example/projectend/controller/GioHangController.java
@Controller
@RequestMapping("/giohang")
public class GioHangController {
    
    @Autowired
    private CartService cartService;
    
    // Hiển thị giỏ hàng
    @GetMapping("")
    public String gioHang(HttpSession session, Model model) {
        String sessionId = session.getId();
        // Lấy giỏ hàng từ database hoặc localStorage
        List<CartItem> cartItems = cartService.getCartItems(sessionId);
        
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalAmount", cartService.getTotalAmount(sessionId));
        model.addAttribute("pageTitle", "Giỏ hàng");
        
        return "giohang";
    }
    
    // API thêm sản phẩm vào giỏ
    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> addToCart(@RequestBody Map<String, Object> request,
                                        HttpSession session) {
        try {
            Long productId = Long.valueOf(request.get("productId").toString());
            Integer quantity = Integer.valueOf(request.get("quantity").toString());
            
            cartService.addToCart(session.getId(), productId, quantity);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Thêm vào giỏ hàng thành công!");
            response.put("cartCount", cartService.getCartItemCount(session.getId()));
            
            return response;
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Có lỗi xảy ra: " + e.getMessage());
            return response;
        }
    }
    
    // API cập nhật số lượng
    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> updateCart(@RequestBody Map<String, Object> request,
                                         HttpSession session) {
        try {
            Long productId = Long.valueOf(request.get("productId").toString());
            Integer quantity = Integer.valueOf(request.get("quantity").toString());
            
            cartService.updateCartItem(session.getId(), productId, quantity);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("totalAmount", cartService.getTotalAmount(session.getId()));
            
            return response;
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Có lỗi xảy ra: " + e.getMessage());
            return response;
        }
    }
}
```

---

## 🎯 MỤC TIÊU CỦA TỪNG TUẦN

### Tuần 1 - Controllers cơ bản:
- Home page hiển thị sản phẩm từ database
- Product page có search function
- Basic routing hoạt động
- HTML templates kết nối được với data

### Tuần 2 - API và giỏ hàng:
- Cart APIs hoạt động
- JavaScript tích hợp với backend
- LocalStorage sync với database
- Test end-to-end user flow

---

## 📋 CÁC CONTROLLER CẦN HOÀN THIỆN

### Controllers đã có skeleton:
```
controller/
├── HomeController.java          ← Hiển thị trang chủ
├── SanPhamController.java       ← Hiển thị sản phẩm, search
├── GioHangController.java       ← Giỏ hàng, APIs
├── GioiThieuController.java     ← Trang giới thiệu (đơn giản)
├── KienThucController.java      ← Trang kiến thức
├── LienHeController.java        ← Trang liên hệ
└── ProfileController.java       ← Trang profile user
```

### Controllers c��n tạo thêm:
```
controller/
└── MainController.java          ← Xử lý global errors, 404
```

---

## 🎨 TÍCH HỢP VỚI HTML/JS

### HTML Templates đã có:
- `home.html` - Trang chủ
- `sanpham.html` - Trang sản phẩm  
- `giohang.html` - Giỏ hàng
- `login1.html` - Đăng nhập
- `profile.html` - Profile user

### JavaScript files cần kết nối:
- `home.js` - Logic trang chủ
- `sanpham.js` - Logic sản phẩm, search
- `giohang.js` - Logic giỏ hàng (localStorage)
- `user.js` - Logic user profile

### Ví dụ kết nối JavaScript:
```javascript
// Trong sanpham.js - Thêm sản phẩm vào giỏ
function addToCart(productId, quantity) {
    fetch('/giohang/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            productId: productId,
            quantity: quantity
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert(data.message);
            updateCartCount(data.cartCount);
        } else {
            alert('Lỗi: ' + data.message);
        }
    });
}
```

---

## 🆘 KHI GẶP KHÓ KHĂN

### Lỗi Thymeleaf:
1. Kiểm tra syntax `th:` attributes
2. Đảm bảo model attributes đúng tên
3. Kiểm tra template engine config

### JavaScript không hoạt động:
1. Kiểm tra browser console để xem lỗi
2. Đảm bảo API endpoints trả đúng JSON
3. Test API bằng Postman trước

### Model không hiển thị:
1. Debug trong Controller bằng `System.out.println()`
2. Kiểm tra Service methods
3. Verify database connection

---

## 🔄 WORKFLOW KẾT HỢP

### Với Bạn A (Database):
1. Đợi Entity classes hoàn thành
2. Test với Repository methods
3. Ensure data structure matches HTML

### Với Bạn B (Service):
1. Sử dụng Service methods trong Controllers
2. Handle exceptions from Service layer
3. Coordinate on API response formats

### Với Bạn C (Security):
1. Test protected routes
2. Handle authentication in JavaScript
3. Ensure login/logout flow works

---

## 📞 HỖ TRỢ

- **Thymeleaf**: https://www.thymeleaf.org/doc/
- **Spring MVC**: Spring Boot controller tutorials
- **JavaScript**: MDN Web Docs
- **Testing**: Use browser developer tools

## ✨ LƯU Ý

- Test trên browser sau mỗi thay đổi
- Sử dụng developer tools để debug JavaScript
- Đảm bảo responsive design hoạt động
- Handle errors gracefully cho user experience
- Comment code để team hiểu được
