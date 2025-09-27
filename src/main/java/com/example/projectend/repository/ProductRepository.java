package com.example.projectend.repository;

import com.example.projectend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * PRODUCT REPOSITORY - Bạn A hoàn thiện
 * TODO:
 * 1. Test các method này với database
 * 2. Thêm method findByCategory (nếu có Category)
 * 3. Thêm method findByPriceRange
 * 4. Write unit tests
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // TODO: Test method này
    List<Product> findByNameContainingIgnoreCase(String name);

    // TODO: Implement query để tìm sản phẩm còn hàng
    @Query("SELECT p FROM Product p WHERE p.stock > 0")
    List<Product> findAvailableProducts();

    // TODO: Thêm method tìm theo khoảng giá
    // List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // TODO: Thêm method tìm sản phẩm mới nhất
    // List<Product> findTop10ByOrderByCreatedAtDesc();

    // TODO: Custom query tìm sản phẩm bán chạy (nếu có Order entity)
    // @Query("SELECT p FROM Product p JOIN OrderItem oi ON p.id = oi.product.id GROUP BY p.id ORDER BY COUNT(oi) DESC")
    // List<Product> findBestSellingProducts();
}
