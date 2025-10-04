package com.example.projectend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * EMBEDDABLE KEY GIO HANG (MaTK, MaSP)
 * Người 1 - Database Design & Backend Core (Bổ sung 03/10/2025)
 */
@Embeddable
public class GioHangId implements Serializable {

    @Column(name = "MaTK")
    private Integer taiKhoanId;

    @Column(name = "MaSP")
    private Integer sanPhamId;

    public GioHangId() {}

    public GioHangId(Integer taiKhoanId, Integer sanPhamId) {
        this.taiKhoanId = taiKhoanId;
        this.sanPhamId = sanPhamId;
    }

    public Integer getTaiKhoanId() { return taiKhoanId; }
    public void setTaiKhoanId(Integer taiKhoanId) { this.taiKhoanId = taiKhoanId; }
    public Integer getSanPhamId() { return sanPhamId; }
    public void setSanPhamId(Integer sanPhamId) { this.sanPhamId = sanPhamId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GioHangId gioHangId = (GioHangId) o;
        return Objects.equals(taiKhoanId, gioHangId.taiKhoanId) && Objects.equals(sanPhamId, gioHangId.sanPhamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taiKhoanId, sanPhamId);
    }
}

