package com.example.projectend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * ENTITY DON HANG CHI TIET
 * Người 1 - Database Design & Backend Core
 * Mapping với bảng DonHangChiTiet trong database WebBanHangTet
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

    // Constructors
    public DonHangChiTiet() {}

    public DonHangChiTiet(DonHang donHang, SanPham sanPham, Integer soLuong, BigDecimal donGia) {
        this.donHang = donHang;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    // Getters and Setters
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

    // Helper method to calculate total amount
    public BigDecimal getThanhTien() {
        if (soLuong != null && donGia != null) {
            return donGia.multiply(new BigDecimal(soLuong));
        }
        return BigDecimal.ZERO;
    }
}
