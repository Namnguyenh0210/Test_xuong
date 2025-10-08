package com.example.projectend.repository;

import com.example.projectend.entity.ThongKe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * THONG KE REPOSITORY
 * Người 1 - Database Core (Bổ sung 03/10/2025)
 */
@Repository
public interface ThongKeRepository extends JpaRepository<ThongKe, Integer> {

    // ========================================
    // TODO: NGƯỜI 5 - Reports & Analytics
    // ========================================
    // TODO: NGƯỜI 5 - Lấy báo cáo theo khoảng ngày (dashboard filter)
    // List<ThongKe> findByNgayBaoCaoBetween(LocalDate start, LocalDate end);

    // TODO: NGƯỜI 5 - Lấy 1 record theo ngày (để upsert)
    // Optional<ThongKe> findByNgayBaoCao(LocalDate day);
}

