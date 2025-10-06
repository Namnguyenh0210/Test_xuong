package com.example.projectend.service;

import com.example.projectend.entity.SanPham;
import com.example.projectend.entity.LoaiSanPham;
import com.example.projectend.repository.SanPhamRepository;
import com.example.projectend.repository.LoaiSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * SAN PHAM SERVICE - Xử lý logic nghiệp vụ cho sản phẩm
 * TODO NGƯỜI 3 - CẦN HOÀN THIỆN
 *
 * ========================================
 * TODO NGƯỜI 3 - DANH SÁCH CHI TIẾT:
 * ========================================
 *
 * BƯỚC 1: Uncomment tất cả code đã comment
 * BƯỚC 2: Implement các method tìm kiếm, lọc sản phẩm
 * BƯỚC 3: Thêm method tính toán giá, khuyến mãi
 * BƯỚC 4: Optimize performance với caching
 */
@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    // TODO NGƯỜI 3: Lấy sản phẩm nổi bật cho trang chủ
    public List<SanPham> getFeaturedProducts(int limit) {
        // TODO: Implement logic lấy sản phẩm nổi bật
        // return sanPhamRepository.findTop4ByOrderByNgayTaoDesc();
        return List.of(); // Placeholder
    }

    // TODO NGƯỜI 3: Tìm kiếm sản phẩm với filter
    public Page<SanPham> findWithFilters(String search, Integer loaiId,
                                        BigDecimal minPrice, BigDecimal maxPrice,
                                        String sort, Pageable pageable) {
        // TODO: Implement logic tìm kiếm và lọc
        // if (search != null && !search.isEmpty()) {
        //     return sanPhamRepository.findByTenSPContainingIgnoreCase(search, pageable);
        // }
        return sanPhamRepository.findAll(pageable); // Placeholder
    }

    // TODO NGƯỜI 3: Lấy sản phẩm liên quan
    public List<SanPham> findRelatedProducts(Integer loaiId, Integer excludeId, int limit) {
        // TODO: Implement logic lấy sản phẩm cùng danh mục
        return List.of(); // Placeholder
    }

    // TODO NGƯỜI 3: Tìm kiếm nhanh (AJAX)
    public List<SanPham> searchByKeyword(String keyword, int limit) {
        // TODO: Implement quick search
        return List.of(); // Placeholder
    }

    // Các method cơ bản đã có
    public Page<SanPham> getAllSanPham(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    public Optional<SanPham> findById(Integer id) {
        return sanPhamRepository.findById(id);
    }

    public SanPham save(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    public void deleteById(Integer id) {
        sanPhamRepository.deleteById(id);
    }

    public long countAll() {
        return sanPhamRepository.count();
    }

    // TODO NGƯỜI 3: Lấy tất cả danh mục
    public List<LoaiSanPham> getAllCategories() {
        return loaiSanPhamRepository.findAll();
    }
}
