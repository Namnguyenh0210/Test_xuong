package com.example.projectend.entity;

import jakarta.persistence.*;

/**
 * ENTITY LOAI SAN PHAM
 * Người 1 - Database Design & Backend Core
 * Mapping với bảng LoaiSanPham trong database WebBanHangTet
 */
@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLoai")
    private Integer maLoai;

    @Column(name = "TenLoai", nullable = false, unique = true, length = 100)
    private String tenLoai;

    // Constructors
    public LoaiSanPham() {}

    public LoaiSanPham(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    // Getters and Setters
    public Integer getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Integer maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}
