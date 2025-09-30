package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * LIEN HE CONTROLLER - Trang liên hệ
 * Người 1 - Database Design & Backend Core (ĐÃ HOÀN THÀNH - Cấu trúc cơ bản)
 * TODO: Người 3 - Frontend & Customer Website (Hoàn thiện tính năng)
 */
@Controller
public class LienHeController {

    // ========================================
    // TODO: NGƯỜI 3 - Frontend & Customer Website
    // ========================================

    // TODO: NGƯỜI 3 - Tạo LienHeService để xử lý form liên hệ
    // @Autowired private LienHeService lienHeService;
    // @Autowired private EmailService emailService;

    @GetMapping("/lienhe")
    public String lienHe(Model model) {
        // TODO: NGƯỜI 3 - Thêm thông tin liên hệ cửa hàng
        // model.addAttribute("shopAddress", "123 Đường ABC, Quận XYZ, TP.HCM");
        // model.addAttribute("shopPhone", "0909 123 456");
        // model.addAttribute("shopEmail", "contact@tetshop.com");
        // model.addAttribute("shopHours", "8:00 - 22:00 (Thứ 2 - Chủ nhật)");

        // TODO: NGƯỜI 3 - Thêm form object cho contact form
        // model.addAttribute("contactForm", new ContactForm());

        // TODO: NGƯỜI 3 - Thêm Google Maps embed (optional)
        // model.addAttribute("mapEmbedUrl", "https://maps.google.com/...");

        model.addAttribute("pageTitle", "Liên hệ - Cửa hàng đồ Tết");
        return "lienhe";
    }

    // TODO: NGƯỜI 3 - Xử lý form liên hệ
    // @PostMapping("/lienhe")
    // public String xuLyLienHe(@Valid @ModelAttribute ContactForm contactForm,
    //                          BindingResult result, Model model,
    //                          RedirectAttributes redirectAttributes) {
    //     if (result.hasErrors()) {
    //         // Thêm lại thông tin liên hệ khi có lỗi
    //         return "lienhe";
    //     }
    //
    //     try {
    //         // Lưu thông tin liên hệ vào database
    //         lienHeService.saveContact(contactForm);
    //
    //         // Gửi email thông báo cho admin
    //         emailService.sendContactNotification(contactForm);
    //
    //         // Gửi email xác nhận cho khách hàng
    //         emailService.sendContactConfirmation(contactForm.getEmail(), contactForm.getHoTen());
    //
    //         redirectAttributes.addFlashAttribute("success",
    //             "Cảm ơn bạn đã liên hệ! Chúng tôi sẽ phản hồi trong thời gian sớm nhất.");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("error",
    //             "Có lỗi xảy ra khi gửi liên hệ. Vui lòng thử lại sau.");
    //     }
    //
    //     return "redirect:/lienhe";
    // }

    // TODO: NGƯỜI 3 - Trang FAQ (optional)
    // @GetMapping("/faq")
    // public String faq(Model model) {
    //     // Lấy danh sách câu hỏi thường gặp
    //     model.addAttribute("pageTitle", "Câu hỏi thường gặp");
    //     return "faq";
    // }
}
