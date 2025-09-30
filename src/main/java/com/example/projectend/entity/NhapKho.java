package com.example.projectend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * ENTITY NHAP KHO
 * Người 1 - Database Design & Backend Core
 * Mapping với bảng NhapKho trong database WebBanHangTet
 */
@Entity
@Table(name = "NhapKho")
public class NhapKho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNK")
    private Integer maNK;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;

    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;

    @Column(name = "NgayNhap")
    private LocalDateTime ngayNhap = LocalDateTime.now();

    // Constructors
    public NhapKho() {}

    public NhapKho(SanPham sanPham, Integer soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    // Getters and Setters
    public Integer getMaNK() {
        return maNK;
    }

    public void setMaNK(Integer maNK) {
        this.maNK = maNK;
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

    public LocalDateTime getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDateTime ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
