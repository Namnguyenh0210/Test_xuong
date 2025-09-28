package com.example.projectend.service;

import com.example.projectend.entity.SanPham;
import java.util.List;
import java.util.Optional;

/**
 * PRODUCT SERVICE INTERFACE
 * TODO: Người 1 - Tạo implementation class
 * TODO: Người 3 - Sử dụng các method này trong controller
 * TODO: Người 4 - Sử dụng CRUD methods trong admin panel
 */
public interface ProductService {

    // TODO: Người 3 - Methods cho trang chủ
    List<SanPham> getFeaturedProducts(int limit);
    List<SanPham> getNewestProducts(int limit);
    List<SanPham> getDiscountProducts(int limit);

    // TODO: Người 3 - Methods cho hiển thị sản phẩm
    List<SanPham> getAllProducts();
    List<SanPham> getProductsByCategory(Integer categoryId);
    Optional<SanPham> getProductById(Integer id);
    List<SanPham> searchProducts(String keyword);

    // TODO: Người 4 - Methods cho admin panel
    SanPham saveProduct(SanPham sanPham);
    void deleteProduct(Integer id);
    List<SanPham> getProductsWithPaging(int page, int size);

    // TODO: Người 1 - Method kiểm tra tồn kho
    boolean isInStock(Integer productId, Integer quantity);
    void updateStock(Integer productId, Integer quantity);
}
