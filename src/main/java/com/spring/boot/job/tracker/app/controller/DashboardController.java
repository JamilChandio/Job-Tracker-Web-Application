package com.spring.boot.job.tracker.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.job.tracker.app.dtos.JobApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashboard(@RequestParam(value = "username", required = true) String username, Model model) {
        log.info("Loading dashboard for {}", username);

        // ✅ Example data — later this comes from the service
        model.addAttribute("username", username);
        model.addAttribute("totalApplications", 10);
        model.addAttribute("pendingCount", 3);
        model.addAttribute("interviewedCount", 2);
        model.addAttribute("acceptedCount", 1);
        model.addAttribute("title", "Dashboard - " + username);
        model.addAttribute("applications", List.of(
                new JobApplication("Google", "Backend Engineer", "Pending", "2025-10-25", null, null, "2025-11-05",
                        username),
                new JobApplication("Microsoft", "SDE", "Interviewed", "2025-10-15", null, null, "2025-11-01", username),
                new JobApplication("Amazon", "Software Developer", "Accepted", "2025-09-30", null, null, "2025-10-10",
                        username),
                new JobApplication("Netflix", "Full Stack Engineer", "Rejected", "2025-08-20", null, null, null,
                        username)));

        return "dashboard";
    }

}
