package com.example.projectend.service;

import com.example.projectend.entity.Product;
import com.example.projectend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * PRODUCT SERVICE - Bạn B hoàn thiện
 * TODO:
 * 1. Implement tất cả methods với business logic
 * 2. Thêm error handling và validation
 * 3. Thêm logging cho debugging
 * 4. Write unit tests
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // TODO: Implement method lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        // TODO: return productRepository.findAll();
        return null; // placeholder
    }

    // TODO: Implement method lấy sản phẩm có sẵn
    public List<Product> getAvailableProducts() {
        // TODO: return productRepository.findAvailableProducts();
        return null; // placeholder
    }

    // TODO: Implement method tìm sản phẩm theo ID
    public Optional<Product> getProductById(Long id) {
        // TODO: Thêm validation cho id != null
        // TODO: return productRepository.findById(id);
        return Optional.empty(); // placeholder
    }

    // TODO: Implement method tìm kiếm sản phẩm
    public List<Product> searchProducts(String keyword) {
        // TODO: Validate keyword không empty
        // TODO: return productRepository.findByNameContainingIgnoreCase(keyword);
        return null; // placeholder
    }

    // TODO: Implement method save sản phẩm
    public Product saveProduct(Product product) {
        // TODO: Validate product data
        // TODO: Set createdAt, updatedAt
        // TODO: return productRepository.save(product);
        return null; // placeholder
    }

    // TODO: Implement method kiểm tra sản phẩm có đủ số lượng
    public boolean isProductAvailable(Long productId, Integer requestedQuantity) {
        // TODO: Tìm product theo ID
        // TODO: Kiểm tra stock >= requestedQuantity
        // TODO: return boolean result
        return false; // placeholder
    }

    // TODO: Implement method cập nhật số lượng sản phẩm
    public void updateProductStock(Long productId, Integer soldQuantity) {
        // TODO: Tìm product
        // TODO: Giảm stock
        // TODO: Save lại
        // TODO: Throw exception nếu không đủ hàng
    }

    // TODO: Thêm method để đồng bộ với localStorage của Frontend
    public void syncWithLocalStorage(String localStorageData) {
        // TODO: Parse JSON từ localStorage
        // TODO: Validate products tồn tại trong DB
        // TODO: Check stock availability
        // TODO: Return validation results
    }
}
