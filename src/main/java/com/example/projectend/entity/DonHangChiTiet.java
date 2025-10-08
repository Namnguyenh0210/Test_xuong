package com.example.projectend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * ENTITY DON HANG CHI TIET
 * Người 1 - Database Design & Backend Core (Bổ sung 03/10/2025)
 */
@Entity
@Table(name = "DonHangChiTiet")
public class DonHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDHCT")
    private Integer maDHCT;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDH", nullable = false)
    private DonHang donHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;

    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;

    @Column(name = "DonGia", nullable = false, precision = 18, scale = 2)
    private BigDecimal donGia;

    public DonHangChiTiet() {
    }

    public DonHangChiTiet(DonHang donHang, SanPham sanPham, Integer soLuong, BigDecimal donGia) {
        this.donHang = donHang;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public Integer getMaDHCT() {
        return maDHCT;
    }

    public void setMaDHCT(Integer maDHCT) {
        this.maDHCT = maDHCT;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    // Tính thành tiền (soLuong * donGia)
    public BigDecimal getThanhTien() {
        return donGia != null && soLuong != null ? donGia.multiply(BigDecimal.valueOf(soLuong)) : BigDecimal.ZERO;
    }
}

