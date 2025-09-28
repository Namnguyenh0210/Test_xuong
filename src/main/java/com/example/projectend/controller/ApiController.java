package com.example.projectend.controller;

import com.example.projectend.entity.SanPham;
import com.example.projectend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST API CONTROLLER - Chuẩn thực tế công ty
 * Pattern: Tách riêng API endpoints cho AJAX calls
 * Đây là cách 90% công ty VN đang làm
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ProductService productService;

    // ===== CART API (Chuẩn thực tế) =====

    @PostMapping("/cart/add")
    public ResponseEntity<Map<String, Object>> addToCart(
            @RequestParam Integer productId,
            @RequestParam Integer quantity) {

        Map<String, Object> response = new HashMap<>();

        try {
            // Business logic
            cartService.addToCart(productId, quantity);

            // Response chuẩn công ty
            response.put("success", true);
            response.put("message", "Đã thêm vào giỏ hàng");
            response.put("cartCount", cartService.getCartItemCount());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Có lỗi xảy ra: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/cart/remove/{itemId}")
    public ResponseEntity<Map<String, Object>> removeFromCart(@PathVariable Integer itemId) {
        Map<String, Object> response = new HashMap<>();

        try {
            cartService.removeFromCart(itemId);

            response.put("success", true);
            response.put("cartCount", cartService.getCartItemCount());
            response.put("newTotal", cartService.getCartTotal());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/cart/update")
    public ResponseEntity<Map<String, Object>> updateCartQuantity(
            @RequestParam Integer cartItemId,
            @RequestParam Integer quantity) {

        Map<String, Object> response = new HashMap<>();

        try {
            CartItem updatedItem = cartService.updateQuantity(cartItemId, quantity);

            response.put("success", true);
            response.put("itemTotal", updatedItem.getSubTotal());
            response.put("cartTotal", cartService.getCartTotal());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // ===== PRODUCT API =====

    @GetMapping("/products/search")
    public ResponseEntity<List<SanPham>> searchProducts(@RequestParam String q) {
        List<SanPham> products = productService.searchProducts(q);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<List<SanPham>> getProductsByCategory(@PathVariable Integer categoryId) {
        List<SanPham> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }

    // ===== ADMIN API =====

    @DeleteMapping("/admin/product/{id}")
    public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        try {
            productService.deleteProduct(id);
            response.put("success", true);
            response.put("message", "Đã xóa sản phẩm");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/admin/product/{id}/toggle-status")
    public ResponseEntity<Map<String, Object>> toggleProductStatus(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        try {
            productService.toggleStatus(id);
            response.put("success", true);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
