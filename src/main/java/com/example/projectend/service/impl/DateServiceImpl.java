package com.example.projectend.service.impl;

import com.example.projectend.service.DateService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;

/**
 * DATE SERVICE IMPLEMENTATION
 * Người 1 - Core Utility (Bổ sung 03/10/2025)
 * Logic đơn giản, tách riêng để các controller khác tái sử dụng.
 */
@Service
public class DateServiceImpl implements DateService {
    @Override
    public int getCurrentYear() {
        return Year.now().getValue();
    }

    @Override
    public int getTetYear() {
        int currentYear = getCurrentYear();
        // Quy ước: từ tháng 9 trở đi chuẩn bị năm Tết tiếp theo
        return LocalDate.now().getMonthValue() >= 9 ? currentYear + 1 : currentYear;
    }
}

