package com.example.projectend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ENTITY DON HANG
 * Người 1 - Database Design & Backend Core
 * Mapping với bảng DonHang trong database WebBanHangTet
 */
@Entity
@Table(name = "DonHang")
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDH")
    private Integer maDH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTK", nullable = false)
    private TaiKhoan taiKhoan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDC", nullable = false)
    private DiaChi diaChi;

    @Column(name = "NgayDat")
    private LocalDateTime ngayDat = LocalDateTime.now();

    @Column(name = "TongTien", nullable = false, precision = 18, scale = 2)
    private BigDecimal tongTien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTTDH")
    private TrangThaiDonHang trangThaiDonHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPTTT", nullable = false)
    private PhuongThucThanhToan phuongThucThanhToan;

    // Constructors
    public DonHang() {}

    public DonHang(TaiKhoan taiKhoan, DiaChi diaChi, BigDecimal tongTien, PhuongThucThanhToan phuongThucThanhToan) {
        this.taiKhoan = taiKhoan;
        this.diaChi = diaChi;
        this.tongTien = tongTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    // Getters and Setters
    public Integer getMaDH() {
        return maDH;
    }

    public void setMaDH(Integer maDH) {
        this.maDH = maDH;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public LocalDateTime getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDateTime ngayDat) {
        this.ngayDat = ngayDat;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public TrangThaiDonHang getTrangThaiDonHang() {
        return trangThaiDonHang;
    }

    public void setTrangThaiDonHang(TrangThaiDonHang trangThaiDonHang) {
        this.trangThaiDonHang = trangThaiDonHang;
    }

    public PhuongThucThanhToan getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(PhuongThucThanhToan phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }
}
