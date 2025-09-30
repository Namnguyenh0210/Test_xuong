package com.example.projectend.entity;

import jakarta.persistence.*;

/**
 * ENTITY DIA CHI
 * Người 1 - Database Design & Backend Core
 * Mapping với bảng DiaChi trong database WebBanHangTet
 */
@Entity
@Table(name = "DiaChi")
public class DiaChi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDC")
    private Integer maDC;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTK", nullable = false)
    private TaiKhoan taiKhoan;

    @Column(name = "DiaChiChiTiet", nullable = false, length = 255)
    private String diaChiChiTiet;

    @Column(name = "MacDinh")
    private Boolean macDinh = false;

    // Constructors
    public DiaChi() {}

    public DiaChi(TaiKhoan taiKhoan, String diaChiChiTiet) {
        this.taiKhoan = taiKhoan;
        this.diaChiChiTiet = diaChiChiTiet;
    }

    // Getters and Setters
    public Integer getMaDC() {
        return maDC;
    }

    public void setMaDC(Integer maDC) {
        this.maDC = maDC;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getDiaChiChiTiet() {
        return diaChiChiTiet;
    }

    public void setDiaChiChiTiet(String diaChiChiTiet) {
        this.diaChiChiTiet = diaChiChiTiet;
    }

    public Boolean getMacDinh() {
        return macDinh;
    }

    public void setMacDinh(Boolean macDinh) {
        this.macDinh = macDinh;
    }
}
