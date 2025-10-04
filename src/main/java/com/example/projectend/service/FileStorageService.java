package com.example.projectend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Optional;

/**
 * FILE STORAGE SERVICE (Optional nâng cấp +20%)
 * Lưu trữ hình ảnh sản phẩm / avatar người dùng.
 * Có thể bắt đầu bằng lưu trong thư mục local: /uploads
 *
 * TODO (Người 4): Dùng cho upload ảnh sản phẩm trong Admin.
 * TODO (Người 2): Có thể dùng cho avatar user (optional).
 */
public interface FileStorageService {
    String store(MultipartFile file); // trả về tên file đã lưu hoặc path
    Optional<InputStream> load(String filename);
    boolean delete(String filename);
}

