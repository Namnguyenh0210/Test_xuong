package com.example.projectend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * ENTITY TAI KHOAN (Account)
 * TODO: Người 1 - Database & Entities
 * TODO: Người 2 - Authentication & Security (sử dụng entity này cho login)
 * Mô tả: Quản lý thông tin tài khoản người dùng
 */
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTK")
    private Integer maTK;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(max = 100, message = "Họ tên không được quá 100 ký tự")
    @Column(name = "HoTen", length = 100, nullable = false)
    private String hoTen;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Size(max = 100, message = "Email không được quá 100 ký tự")
    @Column(name = "Email", length = 100, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(max = 255, message = "Mật khẩu không được quá 255 ký tự")
    @Column(name = "MatKhau", length = 255, nullable = false)
    private String matKhau;

    @Size(max = 20, message = "Số điện thoại không được quá 20 ký tự")
    @Column(name = "SoDienThoai", length = 20)
    private String soDienThoai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaVT", nullable = false)
    private VaiTro vaiTro;

    @Column(name = "TrangThai", nullable = false)
    private Boolean trangThai = true; // 1: Active, 0: Locked

    // TODO: Người 2 - Thêm các trường cho authentication
    // private String verificationToken;
    // private LocalDateTime tokenExpiry;
    // private Boolean emailVerified = false;

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
}
