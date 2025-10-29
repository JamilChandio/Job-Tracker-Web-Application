package com.spring.boot.job.tracker.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping({ "/", "/home" })
    public String home(Model model) {
        model.addAttribute("title", "Welcome to Job Tracker");
        model.addAttribute("message", "Track your job applications efficiently!");
        return "home"; // resolves to templates/home.html
    }

}
