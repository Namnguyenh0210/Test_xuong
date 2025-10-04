# 📘 PHÂN CHIA CÔNG VIỆC & BACKLOG DỰ ÁN

> Dự án: **Website Bán Đồ Tết Nguyên Đán**  
> Tech stack: Spring Boot 3.2.x · Thymeleaf · JPA (SQL Server) · Spring Security · (H2 Dev)  
> Ngày cập nhật: 03/10/2025  
> Lưu ý: **KHÔNG XOÁ các TODO trong code. Chỉ bổ sung / thực hiện rồi đánh dấu ở file này.**
nam
---
## 1. 🌟 MỤC TIÊU CHÍNH
| Mục tiêu | Trạng thái | Ghi chú |
|----------|------------|--------|
| Nền tảng (DB + Entity + Repository + Controllers khung) | ✅ Done | Người 1 hoàn thành |
| Authentication (Login/Register/Role) | ⏳ Pending | Người 2 |
| Customer Site (Sản phẩm + Giỏ hàng + Checkout) | ⏳ Pending | Người 3 |
| Admin Panel (CRUD + Quản lý) | ⏳ Pending | Người 4 |
| Báo cáo & Analytics | ⏳ Pending | Người 5 |
| Tối ưu UI/UX + Responsive + Clean CSS | ⏳ Partial | Người 3 phối hợp |
| Hoàn thiện tài liệu & test | ⏳ Pending | All |

---
## 2. 👥 PHÂN CÔNG CHÍNH THEO THÀNH VIÊN

### 👤 Người 1 – Database & Core Backend (HOÀN THÀNH)
Giữ vai trò hỗ trợ kỹ thuật, review merge.
- ✅ DB schema 12 bảng + dữ liệu mẫu
- ✅ 13 Entity mapping chuẩn JPA
- ✅ 6 Repository interface + TODO gợi ý
- ✅ Controller khung + TODO phân vai
- ✅ Cấu hình `application.properties`
- ✅ Cấu hình bảo mật cơ bản (SecurityConfig skeleton)
- 🔄 Hỗ trợ các thành viên khác khi cần

### 👤 Người 2 – Authentication & Authorization
**TODO bắt buộc:**
1. [ ] Hoàn thiện `SecurityConfig.java`
   - [ ] Thêm `UserDetailsService` custom
   - [ ] Áp dụng phân quyền URL theo vai trò
   - [ ] Cấu hình Remember-Me (simple token / persistent)
   - [ ] Session timeout + concurrent session (optional)
2. [ ] Tạo `UserDetailsServiceImpl`
   - [ ] Load user theo email
   - [ ] Map VaiTro -> GrantedAuthority
3. [ ] Xử lý Login / Register
   - [ ] `POST /login` dùng plain text (theo yêu cầu bài) – (GHI CHÚ: Production phải mã hoá)
   - [ ] `GET/POST /register` + validate email trùng
   - [ ] Thêm flash message (success/error)
4. [ ] Hoàn thiện `ProfileController`
   - [ ] Trang profile (thông tin + vai trò)
   - [ ] Đổi mật khẩu (plain text)
   - [ ] Lịch sử đơn hàng (gọi DonHangRepository)
5. [ ] Repository methods (TaiKhoanRepository):
```java
Optional<TaiKhoan> findByEmail(String email);
boolean existsByEmail(String email);
Optional<TaiKhoan> findByEmailAndMatKhau(String email, String matKhau);
```
6. [ ] Thêm interceptor / utility: lấy user hiện tại (model attribute toàn cục) -> hiển thị tên ở header.
7. [ ] Unit test cơ bản cho login sai / đúng.

### 👤 Người 3 – Frontend & Customer Journey
**TODO bắt buộc:**
1. Service Layer (tạo package `service` + impl):
   - [ ] `SanPhamService` (list, detail, search, filter, newest, featured)
   - [ ] `LoaiSanPhamService` (list danh mục)
   - [ ] `GioHangService` (thêm / sửa số lượng / xoá / tổng tiền)
   - [ ] `DonHangService` (checkout đơn hàng)
2. Controllers:
   - [ ] `HomeController`: thay placeholder bằng dữ liệu thật (featuredProducts, newProducts, categories)
   - [ ] `SanPhamController`: phân trang + lọc theo loại + tìm kiếm
   - [ ] `GioHangController`: AJAX thao tác (JSON response) + hiển thị tổng tiền
   - [ ] `LienHeController`: chuyển form liên hệ sang POST xử lý (lưu tạm DB hoặc gửi log)
   - [ ] `KienThucController`: (Có thể giản lược: mẫu 3–5 bài viết static trước)
3. Thymeleaf Templates:
   - [ ] Chuẩn hoá tất cả dùng fragment `fragments/layout.html`
   - [ ] Đổi các header cũ (head/navbar2/...) sang header chung (ĐÃ làm 1 phần)
   - [ ] Thêm hiển thị động năm Tết: dùng `${tetYear}` (Home OK)
4. CSS / UI:
   - [ ] Loại bỏ class cũ không dùng (`head`, `head1`, `navbar2`, `spnoibat`, `newkm`, v.v.)
   - [ ] Gom gọn animation thừa
   - [ ] Tạo `lienhe.css` tối giản (nếu cần) – (ĐÃ include file placeholder)
5. UX Enhancements:
   - [ ] Nút scroll to top (đã có style – kiểm tra hoạt động)
   - [ ] Loading overlay (optional)
   - [ ] Toast notification khi thêm giỏ hàng
6. SEO:
   - [ ] Meta description tuỳ trang (dùng model attribute `pageTitle` + custom desc)
   - [ ] Thêm alt cho tất cả `<img>`
7. Performance:
   - [ ] Thêm `?v=` version cho toàn bộ CSS chính (ĐÃ làm 1 phần: common/home)

### 👤 Người 4 – Admin Panel
**TODO bắt buộc:**
1. Tạo module admin: `/controller/admin/*`
   - [ ] `AdminHomeController` (dashboard tĩnh trước)
   - [ ] `AdminSanPhamController` (CRUD sản phẩm + upload image path lưu DB)
   - [ ] `AdminDonHangController` (list + đổi trạng thái)
   - [ ] `AdminTaiKhoanController` (list user, phân quyền)
   - [ ] `AdminThongKeController` (gọi service thống kê đơn giản)
2. View templates `/templates/admin/`:
   - [ ] Layout riêng `admin/layout.html` (có sidebar)
   - [ ] Trang bảng: sử dụng table basic + paginated query
3. Chức năng phụ:
   - [ ] Soft delete sản phẩm (flag trạng thái) (optional)
   - [ ] Export CSV sản phẩm (optional)
4. Validation:
   - [ ] Kiểm tra dữ liệu đầu vào (giá > 0, số lượng >= 0...)

### 👤 Người 5 – Reports & Analytics
**TODO bắt buộc:**
1. Repository mở rộng:
```java
// DonHangRepository
@Query("SELECT SUM(dh.tongTien) FROM DonHang dh WHERE dh.ngayDat BETWEEN :start AND :end")
BigDecimal sumRevenueByDateRange(LocalDateTime start, LocalDateTime end);
```
2. Service Thống kê:
   - [ ] Doanh thu hôm nay / tuần / tháng
   - [ ] Top N sản phẩm bán chạy
   - [ ] Đếm đơn hàng theo trạng thái
3. Controllers `/controller/reports/`:
   - [ ] `RevenueController`
   - [ ] `ProductAnalyticsController`
4. UI đơn giản (line chart, bar chart) dùng Chart.js (CDN) – optional nếu đủ thời gian.
5. Export:
   - [ ] Export Excel doanh thu (Apache POI) (optional)
   - [ ] Export PDF (iText / OpenPDF) (optional cuối cùng)

---
## 3. 📂 CẤU TRÚC THƯ MỤC (HIỆN TẠI + ĐỊNH HƯỚNG)
```
src/main/java/com/example/projectend/
 ├─ controller/
 │   ├─ admin/                (Người 4 sẽ tạo)
 │   ├─ reports/              (Người 5 sẽ tạo)
 │   └─ *Controller.java      (đã có khung)
 ├─ entity/                   (đủ 13 entity)
 ├─ repository/               (6 repo + TODO mở rộng)
 ├─ service/                  (Người 2/3/4/5 bổ sung)
 │   ├─ impl/                 (Triển khai)
 └─ config/                   (Security, etc.)

resources/
 ├─ templates/
 │   ├─ fragments/layout.html
 │   ├─ *.html (pages)
 │   └─ admin/ (sẽ thêm)
 ├─ static/
 │   ├─ css/common.css
 │   ├─ css/home.css
 │   └─ img/, js/
 └─ application.properties
```

---
## 4. 🔄 QUY TRÌNH LÀM VIỆC (FLOW ĐỀ XUẤT)
1. Pull main mới nhất
2. Tạo branch: `feature/<ten-nguoi>-<mo-ta>` (vd: `feature/nguoi3-giohang`)
3. Code + test cục bộ
4. Commit ngắn gọn: `feat(cart): them chuc nang xoa item`
5. Push & tạo Pull Request → Gắn reviewer (Người 1)
6. Merge khi đã approve

---
## 5. ✅ CLEAN CODE GUIDELINES (GIẢN DỊ - DỄ HIỂU)
| Nguyên tắc | Mô tả ngắn |
|------------|-----------|
| Đặt tên rõ | `findAllActiveProducts()` > `get1()` |
| Không nhét logic vào Controller | Di chuyển vào Service |
| DTO sau | Tạm thời dùng Entity, khi cần thì thêm DTO |
| Không bắt try/catch rỗng | Log tối thiểu hoặc rethrow |
| Comment TODO rõ người + mục tiêu | `// TODO (Người 3): load sản phẩm nổi bật` |
| Tránh copy/paste template | Dùng fragment layout |
| CSS: gom biến, tránh lặp màu | Dùng biến trong `:root` |
| Áp dụng từng bước | Không tối ưu sớm quá mức |

---
## 6. 🧩 BACKLOG TỔNG HỢP (THEO ƯU TIÊN)
### P1 (Bắt buộc sớm)
- [ ] Auth (login/register)
- [ ] Sản phẩm: list + chi tiết + tìm kiếm
- [ ] Giỏ hàng cơ bản + thanh toán tĩnh
- [ ] Profile xem thông tin

### P2
- [ ] Phân quyền Admin Panel
- [ ] CRUD sản phẩm (admin)
- [ ] Thống kê doanh thu tổng hợp
- [ ] Cải thiện giao diện mobile

### P3
- [ ] Export báo cáo
- [ ] Filter nâng cao (giá / loại / text)
- [ ] Blog / Kiến thức
- [ ] Tối ưu hiệu năng (cache, lazy load)

### P4 (Nice to have)
- [ ] Email xác nhận đơn hàng
- [ ] Email đăng ký tài khoản
- [ ] Countdown Tết (dùng tetYear)
- [ ] Gợi ý sản phẩm liên quan

---
## 7. 🕒 DYNAMIC TẾT YEAR LOGIC
Hiện đã thêm trong `HomeController`:
```java
int tetYear = LocalDate.now().getMonthValue() >= 9 ? currentYear + 1 : currentYear;
model.addAttribute("tetYear", tetYear);
```
**TODO (Người 3):** Có thể tạo `DateService` để tái dùng cho countdown hoặc banner.

---
## 8. 🧪 TEST GỢI Ý BAN ĐẦU
| Test | Mô tả |
|------|-------|
| Auth Login OK | Đăng nhập đúng tài khoản mẫu |
| Auth Login Fail | Sai mật khẩu -> thông báo lỗi |
| Load Home | Trang chủ render không lỗi, hiển thị hero dynamic |
| Add to Cart | (Sau khi làm) thêm 1 sản phẩm -> số lượng tăng |
| Change Role Access | User thường 403 khi vào `/admin` |

---
## 9. 🚀 CHẠY DỰ ÁN (NHẮC LẠI)
```bash
# Dev nhanh (SQL Server phải sẵn sàng)
mvn spring-boot:run

# Hoặc build jar
mvn clean package
java -jar target/projectend-0.0.1-SNAPSHOT.jar
```

---
## 10. 📌 KHÔNG XOÁ – CHỈ THÊM / ĐÁNH DẤU
Các dòng `TODO (Người X)` trong code là **bắt buộc phải giữ** để người vào sau nhìn thấy.
- Khi xong: cập nhật file này (không cần xoá TODO trong code nếu giáo viên cần đối chiếu)
- Nếu thay đổi hướng: thêm dòng `NOTE:` ngay bên dưới TODO gốc.

---
## 11. 🛡️ RỦI RO & GIẢI PHÁP NHANH
| Rủi ro | Giải pháp gợi ý |
|--------|------------------|
| Trễ auth ảnh hưởng toàn bộ | Người 2 ưu tiên tối đa tuần 1 |
| UI không đồng nhất | Dùng chung fragment + common.css |
| CSS chồng chéo | Xoá dần class cũ sau khi confirm không dùng |
| Xung đột merge | Nhánh nhỏ, pull thường xuyên |
| DB thật không có | Dùng H2 profile dev tạm test UI |

---
## 12. 🔄 DANH SÁCH TODO BỔ SUNG (MỚI THÊM HÔM NAY)
- [ ] Thêm `PHAN-CHIA-CONG-VIEC.md` (file này) ✅ ĐÃ TẠO
- [ ] Refactor `lienhe.html` dùng fragment ✅ ĐÃ LÀM
- [ ] Thêm dynamic hero năm Tết ✅ ĐÃ LÀM
- [ ] Dọn home.css – remove legacy header classes (Người 3)
- [ ] Tạo `SanPhamService` skeleton (Người 3)
- [ ] Thêm `UserDetailsServiceImpl` (Người 2)
- [ ] Tạo package `controller/admin` (Người 4)
- [ ] Thêm `ThongKeRepository` methods (Người 5)

---
## 13. ✅ KẾT LUẬN
Nền tảng đã đủ vững: **Team có thể phát triển song song**. Ưu tiên hoàn thiện Authentication → Sau đó trải nghiệm khách hàng (giỏ hàng + sản phẩm) → Admin → Báo cáo.

> Cần hỗ trợ thêm: ping Người 1.  
> Hãy cập nhật file này khi hoàn thành mỗi milestone.

---
**Keep it simple – Build it solid – Deliver on time.** 🚀

---
## 14. 📎 BỔ SUNG NGÀY 03/10/2025 (Không xoá TODO cũ)
Các file core đã được thêm để đồng bộ đủ 13 entity + repository theo schema mô tả ban đầu. Tất cả method vẫn để TODO cho từng người tự implement.

### 14.1 Entity mới tạo (Skeleton)
- `DiaChi.java` (Địa chỉ giao hàng)
- `TrangThaiDonHang.java`
- `PhuongThucThanhToan.java`
- `NhapKho.java`
- `DonHang.java`
- `DonHangChiTiet.java`
- `ThongKe.java`
- `GioHangId.java` (Composite key)
- `GioHang.java`
- (ĐÃ XOÁ) `TrangThaiSanPham.java` theo yêu cầu ngày 04/10/2025 – database không có bảng này.

### 14.2 Repository mới tạo
- `DiaChiRepository.java`
- `DonHangRepository.java`
- `DonHangChiTietRepository.java`
- `GioHangRepository.java`
- `NhapKhoRepository.java`
- `PhuongThucThanhToanRepository.java`
- `TrangThaiDonHangRepository.java`
- `ThongKeRepository.java`
- (ĐÃ VÔ HIỆU/ XOÁ NỘI DUNG) `TrangThaiSanPhamRepository.java`

Tất cả đã chèn TODO phân vai:
- Người 2: Profile / địa chỉ user.
- Người 3: Giỏ hàng, lịch sử đơn hàng, search/filter sản phẩm.
- Người 4: Admin CRUD + nhập kho + trạng thái đơn hàng.
- Người 5: Báo cáo doanh thu, top sản phẩm, thống kê.

### 14.3 Service & Config tiện ích
- `DateService` + `DateServiceImpl` (logic năm hiện tại & năm Tết) → tránh lặp lại.
- `GlobalModelAdvice` thêm global model attributes: `currentYear`, `tetYear`.
  - TODO (Người 2): Thêm `currentUser` sau khi build auth.
  - TODO (Người 3): Preload danh mục nếu toàn site cần.
  - TODO (Người 5): Mini dashboard header (optional).

### 14.4 Ghi chú quan trọng về Schema
- ĐÃ CẬP NHẬT: Bỏ hoàn toàn trạng thái sản phẩm (TrangThaiSanPham) khỏi code để trùng khớp script DB hiện tại. Nếu muốn phục hồi, cần:
  1. Thêm bảng `TrangThaiSanPham` + cột `MaTTSP` trong bảng `SanPham`.
  2. Thêm lại field và quan hệ trong entity `SanPham` + restore repository.

### 14.5 Next Steps Gợi ý Sau Bổ Sung
| Ưu tiên | Hành động | Người |
|---------|-----------|-------|
| Cao | Implement Auth (UserDetailsService, login) | 2 |
| Cao | SanPhamService + render trang chủ thật | 3 |
| Trung | AdminSanPhamController skeleton | 4 |
| Trung | Báo cáo doanh thu cơ bản (sumRevenueByDateRange) | 5 |
| Thấp | Countdown Tết (DateService mở rộng) | 3 |

### 14.6 Nguyên tắc vẫn giữ
- KHÔNG xoá TODO gốc trong code (dùng để trace trách nhiệm).
- Khi hoàn thành 1 TODO: đánh dấu ở PHAN-CHIA-CONG-VIEC.md (không cần xoá code comment).

(End of Section 14)

---
## 15. 🧭 MAPPING DB -> SERVICE LAYER & KẾ HOẠCH +20% (BỔ SUNG 03/10/2025)
Mục tiêu: Chuẩn hoá kiến trúc ở mức “vượt yêu cầu ASM ~ +20%” nhưng vẫn dễ hiểu cho sinh viên.

### 15.1 Bảng -> Entity -> Service tương ứng
| Bảng DB | Entity | Service chính | Mục đích chính |
|---------|--------|---------------|----------------|
| VaiTro | VaiTro | (dùng thẳng) | Phân quyền (Role) |
| TaiKhoan | TaiKhoan | AccountService, AuthService | Quản lý tài khoản & đăng nhập |
| DiaChi | DiaChi | AddressService | Địa chỉ giao hàng + mặc định |
| LoaiSanPham | LoaiSanPham | CategoryService | Danh mục hiển thị và CRUD admin |
| SanPham | SanPham | ProductService, InventoryService (stock) | Sản phẩm + tồn kho |
| NhapKho | NhapKho | InventoryService | Lịch sử nhập + điều chỉnh |
| GioHang | GioHang | CartService | Giỏ hàng người dùng đăng nhập |
| TrangThaiDonHang | TrangThaiDonHang | (dùng thẳng) | Quy trình xử lý đơn |
| PhuongThucThanhToan | PhuongThucThanhToan | PaymentMethodService | Chọn PTTT khi checkout |
| DonHang | DonHang | OrderService | Quản lý đơn hàng tổng |
| DonHangChiTiet | DonHangChiTiet | OrderDetailService | Chi tiết từng sản phẩm trong đơn |
| ThongKe | ThongKe | ReportService | Tổng hợp doanh thu / KPI |
| (Không dùng) TrangThaiSanPham | (ĐÃ XOÁ) | (n/a) | Bỏ để khớp DB |

### 15.2 Service tiện ích / mở rộng
| Service | Trạng thái | Dùng ở đâu |
|---------|-----------|-----------|
| DateService | ✅ | Hero năm Tết / countdown sau |
| MailService | Skeleton | Kích hoạt / reset pass (optional) |
| FileStorageService | Skeleton | Upload ảnh sản phẩm / avatar |
| CookieService | Skeleton | Giỏ hàng tạm trước login |
| AuthService | Skeleton | Login/register có logic riêng (nếu không dùng hoàn toàn formLogin) |

### 15.3 Mức nâng cấp vượt chuẩn (+20%) đề xuất
| Nhóm | Nâng cấp | Lợi ích |
|------|----------|---------|
| Auth | Thêm khoá tài khoản sau N lần sai | Tăng tính thực tế bảo mật |
| Sản phẩm | Thêm featured / bestseller logic (dựa đơn hàng) | Trang chủ sinh động |
| Giỏ hàng | Đồng bộ cookie -> DB sau login | Trải nghiệm người dùng tốt hơn |
| Đơn hàng | Thêm log trạng thái (timeline) | Admin dễ theo dõi |
| Báo cáo | Top 10 khách VIP + revenue by category | Đúng yêu cầu thống kê nâng cao |
| UI/UX | Countdown Tết + Lazy load image | Tối ưu cảm nhận & performance |
| Storage | Upload ảnh sản phẩm (tạo folder /uploads) | Đáp ứng thực tế quản lý nội dung |

### 15.4 Thứ tự triển khai đề xuất (Tuần 1 → 3)
1. Auth cơ bản (login/register/plain) + AccountService (Người 2)
2. ProductService + CategoryService + trang list/detail (Người 3)
3. CartService + Checkout OrderService (Người 3)
4. Admin CRUD (Category/Product/Order/Account) (Người 4)
5. ReportService (revenueToday, revenueBetween, topProducts) (Người 5)
6. Nâng cấp +20%: đồng bộ giỏ hàng cookie + upload ảnh + topCustomers (All hỗ trợ)

### 15.5 Quy ước triển khai Service Impl
- Package gợi ý: `service.impl.*`
- Tên chuẩn: `ProductServiceImpl implements ProductService`
- Không nhét logic vào Controller → Controller chỉ gọi service.
- Exception nhẹ nhàng (IllegalArgumentException) đủ cho ASM; có thể nâng cấp thành CustomException nếu dư thời gian.

### 15.6 TODO checklist Service mới tạo
| Service | Người chính | Trạng thái | Ghi chú |
|---------|-------------|-----------|--------|
| ProductService | Người 3 | ⏳ | List/filter/search/newest/featured |
| CategoryService | Người 3 | ⏳ | CRUD + list menu |
| CartService | Người 3 | ⏳ | add/update/remove/total |
| OrderService | Người 3/4 | ⏳ | placeOrder + status update |
| OrderDetailService | Người 3 | ⏳ | Lịch sử đơn hàng chi tiết |
| InventoryService | Người 4 | ⏳ | recordImport/adjustStock |
| PaymentMethodService | Người 4 | ⏳ | CRUD + active list |
| AccountService | Người 2 | ⏳ | register/changePassword/profile |
| AuthService | Người 2 | ⏳ | loginPlain + reset password |
| AddressService | Người 2/3 | ⏳ | manage + set default |
| ReportService | Người 5 | ⏳ | revenue/topProducts/topCustomers |
| MailService | Người 2/5 | ⏳ | mock console/email real optional |
| FileStorageService | Người 4 | ⏳ | local upload product images |
| CookieService | Người 2/3 | ⏳ | pre-login cart/remember email |

### 15.7 Lưu ý đồng bộ DB vs Entity
Hiện DB script CHƯA có cột MaTTSP trong SanPham nhưng entity đã có `trangThaiSanPham`. Trước khi viết service sản phẩm cần:
- OPTION A (khuyến nghị): Thêm cột MaTTSP INT NOT NULL DEFAULT 1.
- OPTION B: Tạm bỏ quan hệ trong entity (chưa dùng ở UI).

### 15.8 Kết luận
Service layer đã đầy đủ skeleton → Team có thể phân việc rõ ràng, mỗi người làm phần mình mà không đụng nhau. Khi implement nên tạo test nhỏ (JUnit) cho các hàm tính toán đơn giản (ví dụ: Cart total, Report revenue). Giữ mọi TODO để GV thấy quá trình làm việc bài bản.

(End of Section 15)
