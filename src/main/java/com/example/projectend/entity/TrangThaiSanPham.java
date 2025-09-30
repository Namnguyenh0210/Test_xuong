package com.example.projectend.entity;

import jakarta.persistence.*;

/**
 * ENTITY TRANG THAI SAN PHAM
 * Người 1 - Database Design & Backend Core
 * Mapping với bảng TrangThaiSanPham trong database WebBanHangTet
 */
@Entity
@Table(name = "TrangThaiSanPham")
public class TrangThaiSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTTSP")
    private Integer maTTSP;

    @Column(name = "TenTTSP", nullable = false, length = 50)
    private String tenTTSP;

    // Constructors
    public TrangThaiSanPham() {}

    public TrangThaiSanPham(String tenTTSP) {
        this.tenTTSP = tenTTSP;
    }

    // Getters and Setters
    public Integer getMaTTSP() {
        return maTTSP;
    }

    public void setMaTTSP(Integer maTTSP) {
        this.maTTSP = maTTSP;
    }

    public String getTenTTSP() {
        return tenTTSP;
    }

    public void setTenTTSP(String tenTTSP) {
        this.tenTTSP = tenTTSP;
    }
}
