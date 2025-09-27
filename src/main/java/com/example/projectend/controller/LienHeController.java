package com.example.projectend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LienHeController {

    @GetMapping("/lienhe")
    public String lienHe() {
        return "lienhe";
    }

}
