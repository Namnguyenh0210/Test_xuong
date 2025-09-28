package com.example.projectend.service;

import com.example.projectend.entity.LoaiSanPham;
import java.util.List;
import java.util.Optional;

/**
 * CATEGORY SERVICE INTERFACE
 * TODO: Người 1 - Tạo implementation class
 * TODO: Người 3 - Sử dụng để hiển thị menu danh mục
 * TODO: Người 4 - Sử dụng CRUD trong admin panel
 */
public interface CategoryService {

    // TODO: Người 3 - Methods cho frontend
    List<LoaiSanPham> getAllCategories();
    Optional<LoaiSanPham> getCategoryById(Integer id);

    // TODO: Người 4 - Methods cho admin panel
    LoaiSanPham saveCategory(LoaiSanPham loaiSanPham);
    void deleteCategory(Integer id);
    List<LoaiSanPham> searchCategories(String keyword);
}
