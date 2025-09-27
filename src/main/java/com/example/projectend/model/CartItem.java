package com.example.projectend.model;

public class CartItem {
    private Long id;
    private Product product;
    private Integer quantity;

    // Constructors
    public CartItem() {}

    public CartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Long id, Product product, Integer quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    // Business methods
    public Double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public String getFormattedTotalPrice() {
        return String.format("%,.0f VNĐ", getTotalPrice());
    }
}
