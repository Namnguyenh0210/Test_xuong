package com.example.projectend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * ENTITY TAI KHOAN - ASM Web Bán Hàng Tết
 * Người 1 - Database Design & Backend Core
 *
 * THEO FILE SQL: asmfpt5 22.23.14.sql
 * CREATE TABLE TaiKhoan (
 *     MaTK INT PRIMARY KEY IDENTITY(1,1),
 *     HoTen NVARCHAR(100) NOT NULL,
 *     Email NVARCHAR(100) UNIQUE NOT NULL,
 *     MatKhau NVARCHAR(255) NOT NULL,
 *     SoDienThoai NVARCHAR(20) NULL,
 *     MaVT INT NOT NULL,
 *     TrangThai BIT DEFAULT 1,
 *     NgayTao DATETIME DEFAULT GETDATE()
 * )
 */
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTK")
    private Integer maTK;

    @Column(name = "HoTen", nullable = false, length = 100)
    private String hoTen;

    @Column(name = "Email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "MatKhau", nullable = false, length = 255)
    private String matKhau;

    @Column(name = "SoDienThoai", length = 20)
    private String soDienThoai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaVT", nullable = false)
    private VaiTro vaiTro;

    @Column(name = "TrangThai")
    private Boolean trangThai = true;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao = LocalDateTime.now();

    // Constructors
    public TaiKhoan() {}

    public TaiKhoan(String hoTen, String email, String matKhau, VaiTro vaiTro) {
        this.hoTen = hoTen;
        this.email = email;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    // Getters and Setters
    public Integer getMaTK() { return maTK; }
    public void setMaTK(Integer maTK) { this.maTK = maTK; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public VaiTro getVaiTro() { return vaiTro; }
    public void setVaiTro(VaiTro vaiTro) { this.vaiTro = vaiTro; }

    public Boolean getTrangThai() { return trangThai; }
    public void setTrangThai(Boolean trangThai) { this.trangThai = trangThai; }

    public LocalDateTime getNgayTao() { return ngayTao; }
    public void setNgayTao(LocalDateTime ngayTao) { this.ngayTao = ngayTao; }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "maTK=" + maTK +
                ", hoTen='" + hoTen + '\'' +
                ", email='" + email + '\'' +
                ", vaiTro=" + (vaiTro != null ? vaiTro.getTenVT() : null) +
                ", trangThai=" + trangThai +
                '}';
    }
}
