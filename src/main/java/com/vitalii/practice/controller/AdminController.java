package com.vitalii.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/schedule")
    public String getSchedulePage() {
        return "schedule";
    }

    @GetMapping
    public String getAdminPage() {
        return "admin";
    }

    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, Model model) {
        if ("admin".equals(login) && "password".equals(password)) {
            model.addAttribute("message", "Login successful");
            return "admin";
        }
        model.addAttribute("message", "Invalid credentials");
        return "admin";
    }

    @PostMapping("/roadworks")
    public String addOrUpdateRoadworks(@RequestParam String name, @RequestParam String description) {
        return "redirect:/admin";
    }

    @DeleteMapping("/roadworks")
    public String deleteRoadworks(@RequestParam Long id) {
        return "redirect:/admin";
    }
}
