package com.example.projectend.service;

import com.example.projectend.entity.BaiViet;
import com.example.projectend.entity.TaiKhoan;
import com.example.projectend.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * SERVICE BÀI VIẾT - ASM Web Bán Hàng Tết
 * Xử lý logic nghiệp vụ cho bài viết
 */
@Service
public class BaiVietService {

    @Autowired
    private BaiVietRepository baiVietRepository;

    // Lấy tất cả bài viết với phân trang
    public Page<BaiViet> getAllBaiViet(Pageable pageable) {
        return baiVietRepository.findByTrangThaiOrderByNgayDangDesc("Hiển thị", pageable);
    }

    // Tìm bài viết theo ID
    public Optional<BaiViet> findById(Integer id) {
        return baiVietRepository.findById(id);
    }

    // Lưu bài viết mới hoặc cập nhật
    public BaiViet save(BaiViet baiViet) {
        return baiVietRepository.save(baiViet);
    }

    // Xóa bài viết
    public void deleteById(Integer id) {
        baiVietRepository.deleteById(id);
    }

    // Tìm kiếm bài viết theo tiêu đề
    public Page<BaiViet> searchByTitle(String keyword, Pageable pageable) {
        return baiVietRepository.findByTieuDeContainingIgnoreCaseAndTrangThaiOrderByNgayDangDesc(
                keyword, "Hiển thị", pageable);
    }

    // Lấy bài viết nổi bật (3 bài mới nhất)
    public List<BaiViet> getFeaturedPosts(int limit) {
        return baiVietRepository.findTop3ByTrangThaiOrderByNgayDangDesc("Hiển thị");
    }

    // Lấy bài viết theo tác giả
    public Page<BaiViet> getBaiVietByAuthor(TaiKhoan taiKhoan, Pageable pageable) {
        return baiVietRepository.findByTaiKhoanAndTrangThaiOrderByNgayDangDesc(
                taiKhoan, "Hiển thị", pageable);
    }

    // Đếm tổng số bài viết đang hiển thị
    public long countActivePosts() {
        return baiVietRepository.countByTrangThai("Hiển thị");
    }

    // Ẩn/Hiện bài viết
    public void toggleStatus(Integer id) {
        Optional<BaiViet> baiVietOpt = baiVietRepository.findById(id);
        if (baiVietOpt.isPresent()) {
            BaiViet baiViet = baiVietOpt.get();
            String newStatus = "Hiển thị".equals(baiViet.getTrangThai()) ? "Ẩn" : "Hiển thị";
            baiViet.setTrangThai(newStatus);
            baiVietRepository.save(baiViet);
        }
    }
}
