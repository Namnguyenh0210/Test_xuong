package com.example.projectend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ENTITY PRODUCT - Bạn A hoàn thiện
 * TODO:
 * 1. Thêm validation annotations
 * 2. Thêm relationship với Category (nếu cần)
 * 3. Thêm constructor đầy đủ
 * 4. Test với database
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Thêm @NotBlank, @Size validation
    private String name;

    // TODO: Thêm @Column(length = 1000)
    private String description;

    // TODO: Thêm @NotNull, @DecimalMin validation
    private BigDecimal price;

    private String imageUrl;

    // TODO: Thêm @NotNull, @Min validation
    private Integer stock; // số lượng trong kho

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // TODO: Thêm @PrePersist, @PreUpdate methods

    // Constructors - Bạn A tự thêm
    public Product() {}

    // TODO: Thêm constructor với tham số

    // Getters and Setters - Bạn A tự generate
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // TODO: Generate remaining getters/setters

    // Business methods - Bạn A có thể thêm
    public boolean isInStock() {
        return stock != null && stock > 0;
    }

    public String getFormattedPrice() {
        if (price == null) return "0 VNĐ";
        return String.format("%,.0f VNĐ", price.doubleValue());
    }
}
