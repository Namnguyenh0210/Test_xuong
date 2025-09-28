package com.example.projectend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * ENTITY LOAI SAN PHAM (Category)
 * TODO: Người 1 - Database & Entities
 * TODO: Người 4 - Admin Panel (CRUD categories)
 * Mô tả: Danh mục sản phẩm (Bánh kẹo, Giỏ quà, Đồ trang trí...)
 */
@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLoai")
    private Integer maLoai;

    @NotBlank(message = "Tên loại sản phẩm không được để trống")
    @Size(max = 100, message = "Tên loại không được quá 100 ký tự")
    @Column(name = "TenLoai", length = 100, nullable = false, unique = true)
    private String tenLoai;

    // Constructors
    public LoaiSanPham() {}

    public LoaiSanPham(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    // Getters and Setters
    public Integer getMaLoai() { return maLoai; }
    public void setMaLoai(Integer maLoai) { this.maLoai = maLoai; }

    public String getTenLoai() { return tenLoai; }
    public void setTenLoai(String tenLoai) { this.tenLoai = tenLoai; }
}
