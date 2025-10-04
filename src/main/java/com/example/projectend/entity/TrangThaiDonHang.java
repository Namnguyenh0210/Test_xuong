package com.example.projectend.entity;

import jakarta.persistence.*;

/**
 * ENTITY TRANG THAI DON HANG
 * Người 1 - Database Design & Backend Core (Bổ sung 03/10/2025)
 */
@Entity
@Table(name = "TrangThaiDonHang")
public class TrangThaiDonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTTDH")
    private Integer maTTDH;

    @Column(name = "TenTTDH", nullable = false, length = 50)
    private String tenTTDH;

    public TrangThaiDonHang() {}

    public TrangThaiDonHang(String tenTTDH) { this.tenTTDH = tenTTDH; }

    public Integer getMaTTDH() { return maTTDH; }
    public void setMaTTDH(Integer maTTDH) { this.maTTDH = maTTDH; }
    public String getTenTTDH() { return tenTTDH; }
    public void setTenTTDH(String tenTTDH) { this.tenTTDH = tenTTDH; }
}

