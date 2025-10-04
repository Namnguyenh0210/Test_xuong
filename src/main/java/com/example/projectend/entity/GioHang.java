package com.example.projectend.entity;

import jakarta.persistence.*;

/**
 * ENTITY GIO HANG (Composite Key MaTK + MaSP)
 * Người 1 - Database Design & Backend Core (Bổ sung 03/10/2025)
 */
@Entity
@Table(name = "GioHang")
public class GioHang {

    @EmbeddedId
    private GioHangId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("taiKhoanId")
    @JoinColumn(name = "MaTK")
    private TaiKhoan taiKhoan;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sanPhamId")
    @JoinColumn(name = "MaSP")
    private SanPham sanPham;

    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;

    public GioHang() {}

    public GioHang(TaiKhoan taiKhoan, SanPham sanPham, Integer soLuong) {
        this.taiKhoan = taiKhoan;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.id = new GioHangId(taiKhoan.getMaTK(), sanPham.getMaSP());
    }

    public GioHangId getId() { return id; }
    public void setId(GioHangId id) { this.id = id; }
    public TaiKhoan getTaiKhoan() { return taiKhoan; }
    public void setTaiKhoan(TaiKhoan taiKhoan) { this.taiKhoan = taiKhoan; }
    public SanPham getSanPham() { return sanPham; }
    public void setSanPham(SanPham sanPham) { this.sanPham = sanPham; }
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
}

