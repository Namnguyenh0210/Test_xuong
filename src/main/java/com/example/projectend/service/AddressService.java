package com.example.projectend.service;

import com.example.projectend.entity.DiaChi;
import com.example.projectend.entity.TaiKhoan;

import java.util.List;
import java.util.Optional;

/**
 * ADDRESS SERVICE (DiaChi)
 * Quản lý địa chỉ giao hàng của tài khoản.
 * TODO (Người 2): Cho phép CRUD địa chỉ trong trang profile.
 * TODO (Người 3): Chọn địa chỉ khi checkout.
 */
public interface AddressService {
    List<DiaChi> findByUser(TaiKhoan user);
    Optional<DiaChi> findById(Integer id);
    DiaChi addAddress(TaiKhoan user, DiaChi dc);
    DiaChi updateAddress(DiaChi dc);
    void deleteAddress(Integer id); // Cân nhắc không xoá nếu đang dùng trong đơn hàng lịch sử
    Optional<DiaChi> getDefault(TaiKhoan user);
    void setDefault(Integer addressId, TaiKhoan user);
}

