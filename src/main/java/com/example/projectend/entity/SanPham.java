package com.example.projectend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ENTITY SAN PHAM
 * Người 1 - Database Design & Backend Core
 * Mapping với bảng SanPham trong database WebBanHangTet
 */
@Entity
@Table(name = "SanPham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSP")
    private Integer maSP;

    @Column(name = "TenSP", nullable = false, length = 200)
    private String tenSP;

    @Column(name = "MoTa", columnDefinition = "NVARCHAR(MAX)")
    private String moTa;

    @Column(name = "Gia", nullable = false, precision = 18, scale = 2)
    private BigDecimal gia;

    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong = 0;

    @Column(name = "HinhAnh", length = 255)
    private String hinhAnh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaLoai", nullable = false)
    private LoaiSanPham loaiSanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTTSP", nullable = false)
    private TrangThaiSanPham trangThaiSanPham;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao = LocalDateTime.now();

    // Constructors
    public SanPham() {}

    public SanPham(String tenSP, BigDecimal gia, LoaiSanPham loaiSanPham, TrangThaiSanPham trangThaiSanPham) {
        this.tenSP = tenSP;
        this.gia = gia;
        this.loaiSanPham = loaiSanPham;
        this.trangThaiSanPham = trangThaiSanPham;
    }

    // Getters and Setters
    public Integer getMaSP() {
        return maSP;
    }

    public void setMaSP(Integer maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public TrangThaiSanPham getTrangThaiSanPham() {
        return trangThaiSanPham;
    }

    public void setTrangThaiSanPham(TrangThaiSanPham trangThaiSanPham) {
        this.trangThaiSanPham = trangThaiSanPham;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }
}
