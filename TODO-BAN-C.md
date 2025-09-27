# TODO - BẠN C: SECURITY LAYER

## 📋 MỤC TIÊU
Implement authentication, authorization và session management

## 🎯 NHIỆM VỤ CHÍNH
1. Cấu hình Spring Security
2. Tạo login/register functionality
3. Session management
4. Protect routes theo roles

---

## 🅲 CÔNG VIỆC CỦA BẠN C - BẢO MẬT & ĐĂNG NHẬP

## 🎯 NHIỆM VỤ: Cấu hình Spring Security và làm chức năng đăng nhập

### ✅ DANH SÁCH VIỆC CẦN LÀM:

#### 📋 Tuần 1:
- [ ] Tìm hiểu Spring Security cơ bản
- [ ] Cấu hình SecurityConfig.java
- [ ] Tạo trang đăng nhập đơn giản
- [ ] Test đăng nhập cơ bản

#### 📋 Tuần 2:
- [ ] Làm chức năng đăng ký
- [ ] Mã hóa password
- [ ] Phân quyền Admin/User
- [ ] Tích hợp với HTML có sẵn

---

## 📂 FILE 1: `config/SecurityConfig.java`

### ✅ ĐÃ CÓ:
- Khung SecurityConfig với @EnableWebSecurity
- Basic filterChain setup
- PasswordEncoder bean

### 📝 CẦN LÀM:

#### 1. Hoàn thiện Security Filter Chain:
```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authz -> authz
            // Public pages - không cần login
            .requestMatchers("/", "/home", "/sanpham/**", "/gioithieu", "/kienthuc", "/lienhe").permitAll()
            .requestMatchers("/css/**", "/js/**", "/img/**", "/favicon.ico").permitAll()
            .requestMatchers("/login", "/register", "/api/auth/status").permitAll()
            
            // Protected pages - cần login
            .requestMatchers("/giohang/**", "/profile/**", "/checkout/**").authenticated()
            .requestMatchers("/api/cart/**").authenticated()
            
            // Admin only
            .requestMatchers("/admin/**").hasRole("ADMIN")
            
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/perform_login")
            .defaultSuccessUrl("/", true)
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/?logout=true")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .clearAuthentication(true)
            .permitAll()
        )
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .maximumSessions(1)
            .maxSessionsPreventsLogin(false)
            .sessionRegistry(sessionRegistry())
        )
        .rememberMe(remember -> remember
            .key("projectend-remember-me")
            .tokenValiditySeconds(86400) // 24 hours
            .userDetailsService(userDetailsService())
        )
        // Tạm disable CSRF cho development - ENABLE cho production
        .csrf(csrf -> csrf.disable());
        
    return http.build();
}
```

#### 2. Thêm SessionRegistry bean:
```java
@Bean
public SessionRegistry sessionRegistry() {
    return new SessionRegistryImpl();
}
```

#### 3. Cấu hình UserDetailsService (khi có User entity):
```java
@Bean
public UserDetailsService userDetailsService() {
    // TODO: Return custom UserDetailsService implementation
    // For now, use in-memory user for testing
    UserDetails admin = User.builder()
        .username("admin")
        .password(passwordEncoder().encode("admin123"))
        .roles("ADMIN")
        .build();
        
    UserDetails user = User.builder()
        .username("user")
        .password(passwordEncoder().encode("user123"))
        .roles("USER")
        .build();
        
    return new InMemoryUserDetailsManager(admin, user);
}
```

---

## 📂 FILE 2: `controller/AuthController.java`

### ✅ ĐÃ CÓ:
- Khung controller với basic mappings
- Method signatures với TODO

### 📝 CẦN LÀM:

#### 1. Hoàn thiện loginPage():
```java
@GetMapping("/login")
public String loginPage(@RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "logout", required = false) String logout,
                       @RequestParam(value = "redirect", required = false) String redirect,
                       Model model,
                       HttpServletRequest request) {
    
    // Handle error messages
    if (error != null) {
        model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng!");
        model.addAttribute("alertType", "danger");
    }
    
    // Handle logout message
    if (logout != null) {
        model.addAttribute("successMessage", "Đăng xuất thành công!");
        model.addAttribute("alertType", "success");
    }
    
    // Handle redirect after login
    if (redirect != null) {
        model.addAttribute("redirectUrl", redirect);
    }
    
    // Check if already logged in
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
        return "redirect:/";
    }
    
    model.addAttribute("pageTitle", "Đăng nhập");
    return "login1"; // Sử dụng template có sẵn
}
```

#### 2. Implement registerPage():
```java
@GetMapping("/register")
public String registerPage(Model model) {
    model.addAttribute("pageTitle", "Đăng ký tài khoản");
    return "register";
}
```

#### 3. Implement handleRegister():
```java
@PostMapping("/register")
public String handleRegister(@RequestParam String username,
                            @RequestParam String email,
                            @RequestParam String password,
                            @RequestParam String confirmPassword,
                            @RequestParam String fullName,
                            RedirectAttributes redirectAttributes,
                            Model model) {
    
    // Validation
    List<String> errors = new ArrayList<>();
    
    if (username == null || username.trim().length() < 3) {
        errors.add("Tên đăng nhập phải có ít nhất 3 ký tự");
    }
    
    if (email == null || !email.contains("@")) {
        errors.add("Email không hợp lệ");
    }
    
    if (password == null || password.length() < 6) {
        errors.add("Mật khẩu phải có ít nhất 6 ký tự");
    }
    
    if (!password.equals(confirmPassword)) {
        errors.add("Mật khẩu xác nhận không khớp");
    }
    
    // TODO: Check username/email already exists
    // if (userService.existsByUsername(username)) {
    //     errors.add("Tên đăng nhập đã tồn tại");
    // }
    
    if (!errors.isEmpty()) {
        model.addAttribute("errors", errors);
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("fullName", fullName);
        return "register";
    }
    
    try {
        // TODO: Create user with UserService
        // User newUser = userService.createUser(username, email, password, fullName);
        
        redirectAttributes.addFlashAttribute("successMessage", 
            "Đăng ký thành công! Vui lòng đăng nhập.");
        redirectAttributes.addFlashAttribute("alertType", "success");
        return "redirect:/login";
        
    } catch (Exception e) {
        model.addAttribute("errorMessage", "Có lỗi xảy ra khi đăng ký: " + e.getMessage());
        model.addAttribute("alertType", "danger");
        return "register";
    }
}
```

#### 4. Implement getAuthStatus() cho JavaScript:
```java
@GetMapping("/api/auth/status")
@ResponseBody
public Map<String, Object> getAuthStatus(HttpServletRequest request, 
                                        HttpSession session) {
    Map<String, Object> response = new HashMap<>();
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    boolean isAuthenticated = auth != null && 
                             auth.isAuthenticated() && 
                             !(auth instanceof AnonymousAuthenticationToken);
    
    response.put("isAuthenticated", isAuthenticated);
    
    if (isAuthenticated) {
        response.put("username", auth.getName());
        response.put("roles", auth.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList()));
        response.put("sessionId", session.getId());
    }
    
    return response;
}
```

#### 5. Thêm success handler tùy chỉnh:
```java
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
                                      HttpServletResponse response,
                                      Authentication authentication) throws IOException {
        
        // Log successful login
        String username = authentication.getName();
        String sessionId = request.getSession().getId();
        log.info("User {} logged in with session {}", username, sessionId);
        
        // TODO: Merge localStorage cart với database cart
        // cartService.mergeCartOnLogin(sessionId, username);
        
        // Redirect based on role
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        
        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/admin");
        } else {
            // Check if there was a redirect URL
            String redirectUrl = request.getParameter("redirect");
            if (redirectUrl != null && !redirectUrl.isEmpty()) {
                response.sendRedirect("/" + redirectUrl);
            } else {
                response.sendRedirect("/");
            }
        }
    }
}
```

---

## 📂 FILE 3: `templates/register.html` (TẠO MỚI)

### 📝 CẦN TẠO template register.html:

```html
<!DOCTYPE html>
<html lang="vi" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title th:text="${pageTitle}">Đăng ký</title>
    <link rel="stylesheet" th:href="@{/css/login1.css}">
</head>
<body>
    <div class="login-container">
        <div class="login-form">
            <h2>Đăng ký tài khoản</h2>
            
            <!-- Error Messages -->
            <div th:if="${errors}" class="alert alert-danger">
                <ul>
                    <li th:each="error : ${errors}" th:text="${error}"></li>
                </ul>
            </div>
            
            <!-- Success Message -->
            <div th:if="${errorMessage}" class="alert alert-danger" th:text="${errorMessage}"></div>
            
            <form th:action="@{/register}" method="post">
                <div class="form-group">
                    <label for="username">Tên đăng nhập:</label>
                    <input type="text" id="username" name="username" 
                           th:value="${username}" required minlength="3">
                </div>
                
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" 
                           th:value="${email}" required>
                </div>
                
                <div class="form-group">
                    <label for="fullName">Họ tên:</label>
                    <input type="text" id="fullName" name="fullName" 
                           th:value="${fullName}" required>
                </div>
                
                <div class="form-group">
                    <label for="password">Mật khẩu:</label>
                    <input type="password" id="password" name="password" 
                           required minlength="6">
                </div>
                
                <div class="form-group">
                    <label for="confirmPassword">Xác nhận mật khẩu:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" 
                           required minlength="6">
                </div>
                
                <button type="submit" class="btn-primary">Đăng ký</button>
            </form>
            
            <div class="form-footer">
                <p>Đã có tài khoản? <a th:href="@{/login}">Đăng nhập ngay</a></p>
            </div>
        </div>
    </div>
</body>
</html>
```

---

## 📂 FILE 4: Cập nhật `templates/login1.html`

### 📝 CẦN SỬA:

#### 1. Thêm form action đúng:
```html
<form th:action="@{/perform_login}" method="post">
    <!-- existing form fields -->
    <input type="hidden" th:if="${redirectUrl}" name="redirect" th:value="${redirectUrl}">
</form>
```

#### 2. Thêm error/success messages:
```html
<!-- Thêm vào đầu form -->
<div th:if="${errorMessage}" class="alert alert-danger" th:text="${errorMessage}"></div>
<div th:if="${successMessage}" class="alert alert-success" th:text="${successMessage}"></div>
```

#### 3. Thêm link đăng ký:
```html
<div class="form-footer">
    <p>Chưa có tài khoản? <a th:href="@{/register}">Đăng ký ngay</a></p>
</div>
```

---

## 🧪 TESTING CHECKLIST

### Security Configuration:
- [ ] Public pages accessible without login
- [ ] Protected pages redirect to login
- [ ] Admin pages require ADMIN role
- [ ] Static resources (CSS/JS) accessible

### Authentication:
- [ ] Login với valid credentials thành công
- [ ] Login với invalid credentials fail
- [ ] Logout clear session và redirect
- [ ] Remember-me hoạt động

### Registration:
- [ ] Register form validation hoạt động
- [ ] Duplicate username/email được detect
- [ ] Password confirmation works
- [ ] Successful registration redirect to login

### Session Management:
- [ ] Session timeout hoạt động
- [ ] Multiple login sessions handled
- [ ] Session fixation protection
- [ ] Cart data preserved across login

### API Endpoints:
- [ ] /api/auth/status trả đúng authentication status
- [ ] Protected API require authentication
- [ ] CSRF protection (khi enable)

---

## 🚨 LƯU Ý QUAN TRỌNG

### 1. Security Best Practices:
- **NEVER** store plain text passwords
- Use BCrypt với proper salt rounds
- Implement proper session timeout
- Enable CSRF cho production
- Validate all user inputs

### 2. Integration với Cart:
```java
// Khi user login, merge localStorage cart với database cart
@EventListener
public void handleLoginSuccess(AuthenticationSuccessEvent event) {
    String username = event.getAuthentication().getName();
    // TODO: Merge cart data
}
```

### 3. Password Policy:
- Minimum 6 characters
- Consider requiring special characters
- Implement password strength meter
- Password reset functionality (future)

### 4. Session Security:
- HttpOnly cookies
- Secure cookies cho HTTPS
- Session timeout reasonable
- Concurrent session control

---

## 🔧 DEBUG & TESTING

### Test Authentication:
```bash
# Test login
curl -X POST http://localhost:8080/perform_login \
  -d "username=admin&password=admin123" \
  -c cookies.txt

# Test protected endpoint
curl -X GET http://localhost:8080/giohang \
  -b cookies.txt
```

### Monitor Security Events:
```properties
# Add to application.properties
logging.level.org.springframework.security=DEBUG
```

---

## ✅ DEFINITION OF DONE

- [ ] SecurityConfig hoàn chỉnh và test
- [ ] Login/Register forms hoạt động
- [ ] Session management đúng
- [ ] Protected routes work
- [ ] Authentication API endpoints
- [ ] Error handling adequate  
- [ ] Integration với existing templates
- [ ] Security testing pass
- [ ] Documentation complete

**Estimated Time**: 1-2 tuần

**Dependencies**: Có thể làm song song với Bạn B
