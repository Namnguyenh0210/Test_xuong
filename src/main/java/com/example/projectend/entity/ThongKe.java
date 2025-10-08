package com.example.projectend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * ENTITY THONG KE
 * Người 1 - Database Design & Backend Core (Bổ sung 03/10/2025)
 */
@Entity
@Table(name = "ThongKe")
public class ThongKe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaThongKe")
    private Integer maThongKe;

    @Column(name = "NgayBaoCao", nullable = false, unique = true)
    private LocalDate ngayBaoCao;

    @Column(name = "TongDoanhThu", nullable = false, precision = 18, scale = 2)
    private BigDecimal tongDoanhThu;

    @Column(name = "TongDonHang", nullable = false)
    private Integer tongDonHang;

    @Column(name = "TongSanPhamBanRa", nullable = false)
    private Integer tongSanPhamBanRa;

    public ThongKe() {
    }

    public ThongKe(LocalDate ngayBaoCao, BigDecimal tongDoanhThu, Integer tongDonHang, Integer tongSanPhamBanRa) {
        this.ngayBaoCao = ngayBaoCao;
        this.tongDoanhThu = tongDoanhThu;
        this.tongDonHang = tongDonHang;
        this.tongSanPhamBanRa = tongSanPhamBanRa;
    }

    public Integer getMaThongKe() {
        return maThongKe;
    }

    public void setMaThongKe(Integer maThongKe) {
        this.maThongKe = maThongKe;
    }

    public LocalDate getNgayBaoCao() {
        return ngayBaoCao;
    }

    public void setNgayBaoCao(LocalDate ngayBaoCao) {
        this.ngayBaoCao = ngayBaoCao;
    }

    public BigDecimal getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(BigDecimal tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public Integer getTongDonHang() {
        return tongDonHang;
    }

    public void setTongDonHang(Integer tongDonHang) {
        this.tongDonHang = tongDonHang;
    }

    public Integer getTongSanPhamBanRa() {
        return tongSanPhamBanRa;
    }

    public void setTongSanPhamBanRa(Integer tongSanPhamBanRa) {
        this.tongSanPhamBanRa = tongSanPhamBanRa;
    }
}

