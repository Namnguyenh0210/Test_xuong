package com.example.projectend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * ENTITY VAI TRO (Role)
 * TODO: Người 1 - Database & Entities
 * Mô tả: Quản lý vai trò người dùng (Admin, Nhân viên, Khách hàng)
 */
@Entity
@Table(name = "VaiTro")
public class VaiTro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaVT")
    private Integer maVT;

    @NotBlank(message = "Tên vai trò không được để trống")
    @Size(max = 50, message = "Tên vai trò không được quá 50 ký tự")
    @Column(name = "TenVT", length = 50, nullable = false)
    private String tenVT;

    // Constructors
    public VaiTro() {}

    public VaiTro(String tenVT) {
        this.tenVT = tenVT;
    }

    // Getters and Setters
    public Integer getMaVT() { return maVT; }
    public void setMaVT(Integer maVT) { this.maVT = maVT; }

    public String getTenVT() { return tenVT; }
    public void setTenVT(String tenVT) { this.tenVT = tenVT; }
}
