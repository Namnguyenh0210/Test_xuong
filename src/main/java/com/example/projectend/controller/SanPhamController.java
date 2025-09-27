package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SanPhamController {

    @GetMapping("/sanpham")
    public String sanPham() {
        return "sanpham";
    }

}
