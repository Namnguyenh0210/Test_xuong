package com.example.projectend.service;

import com.example.projectend.entity.CartItem;
import com.example.projectend.entity.Product;
import com.example.projectend.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * CART SERVICE - Bạn B hoàn thiện
 * Nhiệm vụ: Đồng bộ giữa localStorage (Frontend) và Database
 * TODO:
 * 1. Implement sync với localStorage của giohang.js
 * 2. Thêm validation và error handling  
 * 3. Thêm transaction management
 * 4. Write comprehensive tests
 */
@Service
@Transactional
public class CartService {
    
    @Autowired
    private CartItemRepository cartItemRepository;
    
    @Autowired
    private ProductService productService;
    
    // TODO: Implement lấy cart theo session
    public List<CartItem> getCartBySession(String sessionId) {
        // TODO: Validate sessionId not null/empty
        // TODO: return cartItemRepository.findBySessionId(sessionId);
        return null; // placeholder
    }
    
    // TODO: Implement thêm item vào cart (sync từ localStorage)
    public CartItem addToCart(String sessionId, Long productId, Integer quantity) {
        // TODO: Validate inputs
        // TODO: Check product exists và đủ stock
        // TODO: Check item đã có trong cart chưa -> merge hoặc tạo mới
        // TODO: Save và return result
        return null; // placeholder
    }
    
    // TODO: Implement cập nhật số lượng
    public CartItem updateQuantity(Long cartItemId, Integer newQuantity) {
        // TODO: Tìm cart item
        // TODO: Validate quantity > 0
        // TODO: Check product stock
        // TODO: Update và save
        return null; // placeholder
    }
    
    // TODO: Implement xóa item khỏi cart
    public boolean removeFromCart(Long cartItemId) {
        // TODO: Check item exists
        // TODO: Delete item
        // TODO: return success status
        return false; // placeholder
    }
    
    // TODO: Implement xóa toàn bộ cart
    public void clearCart(String sessionId) {
        // TODO: cartItemRepository.deleteBySessionId(sessionId);
    }
    
    // TODO: Implement tính tổng tiền cart
    public BigDecimal getCartTotal(String sessionId) {
        // TODO: Use repository method getTotalAmountBySession
        // TODO: Handle null case
        return BigDecimal.ZERO; // placeholder
    }
    
    // TODO: Implement đếm số items trong cart
    public Long getCartItemCount(String sessionId) {
        // TODO: return cartItemRepository.countBySessionId(sessionId);
        return 0L; // placeholder
    }
    
    // TODO: **QUAN TRỌNG** - Sync với localStorage từ Frontend
    public void syncFromLocalStorage(String sessionId, String localStorageJson) {
        // TODO: Parse JSON từ giohang.js localStorage
        // TODO: Loop qua từng item trong localStorage
        // TODO: Validate products tồn tại trong DB
        // TODO: Merge với cart hiện tại trong DB
        // TODO: Return sync result cho Frontend
    }
    
    // TODO: **QUAN TRỌNG** - Trả data cho Frontend
    public String getCartAsJson(String sessionId) {
        // TODO: Lấy cart từ DB
        // TODO: Convert sang format giống localStorage
        // TODO: Return JSON string cho giohang.js sử dụng
        return "[]"; // placeholder
    }
    
    // TODO: Thêm method validate cart trước checkout
    public boolean validateCartForCheckout(String sessionId) {
        // TODO: Check tất cả items có đủ stock
        // TODO: Check prices không thay đổi
        // TODO: Return validation result
        return false; // placeholder
    }
}
