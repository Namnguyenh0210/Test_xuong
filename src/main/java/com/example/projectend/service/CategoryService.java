package com.example.projectend.service;

import com.example.projectend.entity.LoaiSanPham;
import java.util.List;
import java.util.Optional;

/**
 * CATEGORY SERVICE (LoaiSanPham)
 * Quản lý danh mục sản phẩm.
 * TODO (Người 3): Implement các phương thức cơ bản cho frontend menu.
 * TODO (Người 4): Thêm CRUD trong admin.
 */
public interface CategoryService {
    List<LoaiSanPham> findAll();
    Optional<LoaiSanPham> findById(Integer id);
    LoaiSanPham create(LoaiSanPham loai);
    LoaiSanPham update(LoaiSanPham loai);
    void delete(Integer id); // TODO (Người 4): cân nhắc soft delete nếu có sản phẩm đang dùng
}

