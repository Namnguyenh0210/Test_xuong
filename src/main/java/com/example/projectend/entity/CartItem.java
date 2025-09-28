package com.example.projectend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ENTITY CARTITEM - Bạn A hoàn thiện
 * TODO:
 * 1. Thêm validation cho quantity
 * 2. Thêm relationship với User (khi có Security)
 * 3. Test CRUD operations
 * 4. Thêm method tính total price
 */
@Entity
@Table(name = "cart_items")
public class CartItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // TODO: Thêm relationship với User entity (sau khi có Security)
    private String sessionId; // Tạm thời dùng sessionId thay user
    
    // TODO: Thêm @ManyToOne relationship với Product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    // TODO: Thêm @Min(1) validation
    private Integer quantity;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Constructors - Bạn A tự thêm
    public CartItem() {}
    
    // TODO: Thêm constructor với parameters
    
    // Getters and Setters - Bạn A generate
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    
    // TODO: Generate remaining getters/setters
    
    // Business methods - Bạn A implement
    public BigDecimal getTotalPrice() {
        // TODO: return product.getPrice() * quantity
        return BigDecimal.ZERO; // placeholder
    }
    
    public String getFormattedTotalPrice() {
        // TODO: Format total price to VND
        return "0 VNĐ"; // placeholder
    }
}
