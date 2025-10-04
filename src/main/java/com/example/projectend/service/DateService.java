package com.example.projectend.service;

/**
 * DATE SERVICE
 * Người 1 - Core Utility (Bổ sung 03/10/2025)
 * Cung cấp logic năm hiện tại và năm Tết (tetYear) dùng chung cho nhiều nơi.
 *
 * TODO (Người 3): Có thể mở rộng thêm hàm tính số ngày còn lại đến Tết để hiển thị countdown.
 * TODO (Người 5): Có thể dùng cho thống kê theo mùa vụ (seasonal reporting Xuân vs Q1).
 */
public interface DateService {
    int getCurrentYear();
    int getTetYear();
}

