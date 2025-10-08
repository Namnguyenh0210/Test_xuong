package com.example.projectend.entity;

import jakarta.persistence.*;

/**
 * ENTITY VAI TRO
 * Người 1 - Database Design & Backend Core
 * Mapping với bảng VaiTro trong database WebBanHangTet
 */
@Entity
@Table(name = "VaiTro")
public class VaiTro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaVT")
    private Integer maVT;

    @Column(name = "TenVT", nullable = false, unique = true, length = 50)
    private String tenVT;

    // Constructors
    public VaiTro() {
    }

    public VaiTro(String tenVT) {
        this.tenVT = tenVT;
    }

    // Getters and Setters
    public Integer getMaVT() {
        return maVT;
    }

    public void setMaVT(Integer maVT) {
        this.maVT = maVT;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }
}
