package com.example.projectend.service.auth;

import com.example.projectend.entity.TaiKhoan;
import com.example.projectend.repository.TaiKhoanRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * USER DETAILS SERVICE IMPLEMENTATION (SKELETON)
 * Người 1 - Tạo skeleton (03/10/2025)
 *
 * Mục đích: Cung cấp dữ liệu người dùng cho Spring Security.
 * Hiện tại chỉ map 1 vai trò -> 1 GrantedAuthority dạng ROLE_<TenVT_viết_hoa_không_dấu>
 *
 * ===================== PHÂN CÔNG TODO =====================
 * TODO (Người 2 - Auth):
 *  - Thay logic plain text bằng password encoder nếu GV cho phép (BCrypt)
 *  - Thêm cache (nếu cần) cho user chiếm dụng nhiều request
 *  - Thêm xử lý account locked / disabled dựa trên field trangThai
 *  - Thêm logic ghi nhận lần đăng nhập gần nhất (lastLogin) (cần cột DB nếu mở rộng)
 *
 * TODO (Người 3 - Frontend):
 *  - Sử dụng model attribute currentUser (sẽ thêm ở GlobalModelAdvice) để hiển thị tên trên header
 *  - Thêm avatar / initials (khi có cột avatar)
 *
 * TODO (Người 4 - Admin):
 *  - Mở rộng: nạp thêm quyền phụ (ví dụ: STAFF_MANAGE_ORDER) nếu bổ sung bảng quyền chi tiết
 *
 * TODO (Người 5 - Analytics):
 *  - Hook vào đây (sau khi login thành công) để log hoạt động hoặc thu thập số liệu truy cập
 * ==========================================================
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final TaiKhoanRepository taiKhoanRepository;

    public UserDetailsServiceImpl(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Ở đây username = email
        TaiKhoan tk = taiKhoanRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản: " + username));

        // Map vai trò -> authority (ví dụ: ROLE_ADMIN / ROLE_STAFF / ROLE_CUSTOMER)
        Collection<? extends GrantedAuthority> authorities = mapAuthorities(tk);

        // Plain text password theo yêu cầu bài (KHÔNG dùng trong production)
        // TODO (Người 2): Khi GV đồng ý, thay bằng passwordEncoder (BCrypt) và mã hoá dữ liệu mẫu.
        return User.withUsername(tk.getEmail())
                .password(tk.getMatKhau())
                .authorities(authorities)
                .disabled(Boolean.FALSE.equals(tk.getTrangThai())) // nếu trangThai = false -> disabled
                .accountLocked(false) // TODO (Người 2): Bật logic khoá tài khoản nếu vượt số lần login sai
                .build();
    }

    private Collection<? extends GrantedAuthority> mapAuthorities(TaiKhoan tk) {
        if (tk.getVaiTro() == null) {
            return List.of();
        }
        // Chuẩn hoá tên vai trò: bỏ dấu / khoảng trắng đơn giản -> viết hoa + prefix ROLE_
        String raw = tk.getVaiTro().getTenVT();
        String normalized = raw
                .toUpperCase()
                .replace('Đ','D')
                .replace('Â','A').replace('Ê','E').replace('Ô','O') // tối giản vài ký tự thường gặp
                .replaceAll("[^A-Z0-9]", "_");
        String roleName = "ROLE_" + normalized;
        return List.of(new SimpleGrantedAuthority(roleName));
    }

    // ==============================================
    // TODO (Người 2): Thêm hàm hỗ trợ login thủ công (nếu không dùng formLogin mặc định)
    // public Optional<TaiKhoan> authenticatePlainText(String email, String password) {...}
    // ==============================================
}

