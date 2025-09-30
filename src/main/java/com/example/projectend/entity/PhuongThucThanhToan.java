package com.example.projectend.entity;

import jakarta.persistence.*;

/**
 * ENTITY PHUONG THUC THANH TOAN
 * Người 1 - Database Design & Backend Core
 * Mapping với bảng PhuongThucThanhToan trong database WebBanHangTet
 */
@Entity
@Table(name = "PhuongThucThanhToan")
public class PhuongThucThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPTTT")
    private Integer maPTTT;

    @Column(name = "TenPTTT", nullable = false, unique = true, length = 100)
    private String tenPTTT;

    // Constructors
    public PhuongThucThanhToan() {}

    public PhuongThucThanhToan(String tenPTTT) {
        this.tenPTTT = tenPTTT;
    }

    // Getters and Setters
    public Integer getMaPTTT() {
        return maPTTT;
    }

    public void setMaPTTT(Integer maPTTT) {
        this.maPTTT = maPTTT;
    }

    public String getTenPTTT() {
        return tenPTTT;
    }

    public void setTenPTTT(String tenPTTT) {
        this.tenPTTT = tenPTTT;
    }
}
