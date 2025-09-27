package com.example.projectend.controller;

import com.example.projectend.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        // Tạo danh sách sản phẩm mẫu
        List<Product> products = Arrays.asList(
            new Product(1L, "iPhone 15 Pro", "iPhone 15 Pro 128GB - Titan Tự Nhiên", 29990000.0, "/img/iphone15pro.jpg", 50),
            new Product(2L, "Samsung Galaxy S24", "Samsung Galaxy S24 Ultra 256GB", 31990000.0, "/img/galaxys24.jpg", 30),
            new Product(3L, "MacBook Air M2", "MacBook Air M2 13 inch 256GB", 32990000.0, "/img/macbookair.jpg", 20),
            new Product(4L, "iPad Pro", "iPad Pro 11 inch M2 128GB WiFi", 22990000.0, "/img/ipadpro.jpg", 25),
            new Product(5L, "AirPods Pro", "Apple AirPods Pro (2nd generation)", 6990000.0, "/img/airpodspro.jpg", 100),
            new Product(6L, "Samsung Buds2 Pro", "Samsung Galaxy Buds2 Pro", 4990000.0, "/img/buds2pro.jpg", 80)
        );

        model.addAttribute("products", products);
        model.addAttribute("pageTitle", "Trang chủ - Cửa hàng điện tử");
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return index(model); // Redirect về trang chủ
    }
}
