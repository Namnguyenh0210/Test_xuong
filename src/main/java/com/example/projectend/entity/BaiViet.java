package com.example.projectend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * ENTITY BÀI VIẾT - ASM Web Bán Hàng Tết
 * Quản lý bài viết kiến thức cho website
 */
@Entity
@Table(name = "BaiViet")
public class BaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaBV")
    private Integer maBV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTK", nullable = false)
    private TaiKhoan taiKhoan; // Người đăng (Admin/Nhân viên)

    @Column(name = "TieuDe", nullable = false, length = 200)
    private String tieuDe;

    @Column(name = "NoiDung", nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String noiDung;

    @Column(name = "NgayDang")
    private LocalDateTime ngayDang = LocalDateTime.now();

    @Column(name = "HinhAnh", length = 255)
    private String hinhAnh;

    @Column(name = "TrangThai", length = 20)
    private String trangThai = "Hiển thị";

    // Constructors
    public BaiViet() {}

    public BaiViet(TaiKhoan taiKhoan, String tieuDe, String noiDung, String hinhAnh) {
        this.taiKhoan = taiKhoan;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.hinhAnh = hinhAnh;
    }

    // Getters and Setters
    public Integer getMaBV() {
        return maBV;
    }

    public void setMaBV(Integer maBV) {
        this.maBV = maBV;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LocalDateTime getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(LocalDateTime ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "BaiViet{" +
                "maBV=" + maBV +
                ", tieuDe='" + tieuDe + '\'' +
                ", ngayDang=" + ngayDang +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
