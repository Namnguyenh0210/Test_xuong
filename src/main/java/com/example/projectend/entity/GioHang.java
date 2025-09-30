package com.example.projectend.entity;

import jakarta.persistence.*;

/**
 * ENTITY GIO HANG
 * Người 1 - Database Design & Backend Core
 * Mapping với bảng GioHang trong database WebBanHangTet
 */
@Entity
@Table(name = "GioHang", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"MaTK", "MaSP"})
})
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaGH")
    private Integer maGH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTK", nullable = false)
    private TaiKhoan taiKhoan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;

    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;

    // Constructors
    public GioHang() {}

    public GioHang(TaiKhoan taiKhoan, SanPham sanPham, Integer soLuong) {
        this.taiKhoan = taiKhoan;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    // Getters and Setters
    public Integer getMaGH() {
        return maGH;
    }

    public void setMaGH(Integer maGH) {
        this.maGH = maGH;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
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
}
