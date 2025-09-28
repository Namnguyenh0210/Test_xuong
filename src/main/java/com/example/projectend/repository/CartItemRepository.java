package com.example.projectend.repository;

import com.example.projectend.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * CARTITEM REPOSITORY - Bạn A hoàn thiện
 * TODO:
 * 1. Test tất cả methods với database
 * 2. Thêm method deleteBySessionId
 * 3. Viết integration tests
 * 4. Optimize queries nếu cần
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    
    // TODO: Test method tìm cart theo session
    List<CartItem> findBySessionId(String sessionId);
    
    // TODO: Test method tìm item cụ thể trong cart
    Optional<CartItem> findBySessionIdAndProductId(String sessionId, Long productId);
    
    // TODO: Implement method tính tổng tiền cart
    @Query("SELECT SUM(ci.quantity * ci.product.price) FROM CartItem ci WHERE ci.sessionId = :sessionId")
    Double getTotalAmountBySession(@Param("sessionId") String sessionId);
    
    // TODO: Method đếm số items trong cart
    @Query("SELECT COUNT(ci) FROM CartItem ci WHERE ci.sessionId = :sessionId")
    Long countBySessionId(@Param("sessionId") String sessionId);
    
    // TODO: Method xóa toàn bộ cart
    void deleteBySessionId(String sessionId);
    
    // TODO: Method tìm cart items cũ để cleanup
    // @Query("SELECT ci FROM CartItem ci WHERE ci.updatedAt < :cutoffDate")
    // List<CartItem> findOldCartItems(@Param("cutoffDate") LocalDateTime cutoffDate);
}
