package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KienThucController {

    @GetMapping("/kienthuc")
    public String kienThuc() {
        return "kienthuc";
    }

}
