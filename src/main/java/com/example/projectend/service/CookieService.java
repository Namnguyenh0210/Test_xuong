package com.example.projectend.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Optional;

/**
 * COOKIE SERVICE (Tiện ích đơn giản) - hỗ trợ giỏ hàng tạm trước login hoặc remember lựa chọn.
 *
 * TODO (Người 2): Dùng cho remember email / pre-fill login (nếu GV cho phép).
 * TODO (Người 3): Lưu giỏ hàng tạm (JSON) khi khách chưa đăng nhập.
 */
public interface CookieService {
    void add(HttpServletResponse resp, String name, String value, int maxAgeSeconds, boolean httpOnly);
    Optional<Cookie> get(HttpServletRequest req, String name);
    void remove(HttpServletResponse resp, String name);
}

