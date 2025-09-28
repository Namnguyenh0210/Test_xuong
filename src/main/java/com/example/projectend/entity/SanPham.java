package com.example.projectend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ENTITY SAN PHAM (Product)
 * TODO: Người 1 - Database & Entities
 * TODO: Người 3 - Frontend (hiển thị sản phẩm)
 * TODO: Người 4 - Admin Panel (CRUD products)
 * Mô tả: Sản phẩm đồ Tết
 */
@Entity
@Table(name = "SanPham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSP")
    private Integer maSP;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(max = 200, message = "Tên sản phẩm không được quá 200 ký tự")
    @Column(name = "TenSP", length = 200, nullable = false)
    private String tenSP;

    @Column(name = "MoTa", columnDefinition = "NVARCHAR(MAX)")
    private String moTa;

    @NotNull(message = "Giá sản phẩm không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá sản phẩm phải lớn hơn 0")
    @Column(name = "Gia", precision = 18, scale = 2, nullable = false)
    private BigDecimal gia;

    @NotNull(message = "Số lượng không được để trống")
    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaLoai", nullable = false)
    private LoaiSanPham loaiSanPham;

    // TODO: Người 1 - Thêm trạng thái sản phẩm
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "MaTTSP", nullable = false)
    // private TrangThaiSanPham trangThaiSanPham;

    // TODO: Người 4 - Thêm trường hình ảnh cho admin upload
    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;

    // Constructors
    public SanPham() {
        this.ngayTao = LocalDateTime.now();
        this.ngayCapNhat = LocalDateTime.now();
    }

    public SanPham(String tenSP, String moTa, BigDecimal gia, Integer soLuong, LoaiSanPham loaiSanPham) {
        this();
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.gia = gia;
        this.soLuong = soLuong;
        this.loaiSanPham = loaiSanPham;
    }

    @PreUpdate
    public void preUpdate() {
        this.ngayCapNhat = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getMaSP() { return maSP; }
    public void setMaSP(Integer maSP) { this.maSP = maSP; }

    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public BigDecimal getGia() { return gia; }
    public void setGia(BigDecimal gia) { this.gia = gia; }

    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }

    public LoaiSanPham getLoaiSanPham() { return loaiSanPham; }
    public void setLoaiSanPham(LoaiSanPham loaiSanPham) { this.loaiSanPham = loaiSanPham; }

    public String getHinhAnh() { return hinhAnh; }
    public void setHinhAnh(String hinhAnh) { this.hinhAnh = hinhAnh; }

    public LocalDateTime getNgayTao() { return ngayTao; }
    public void setNgayTao(LocalDateTime ngayTao) { this.ngayTao = ngayTao; }

    public LocalDateTime getNgayCapNhat() { return ngayCapNhat; }
    public void setNgayCapNhat(LocalDateTime ngayCapNhat) { this.ngayCapNhat = ngayCapNhat; }
}
