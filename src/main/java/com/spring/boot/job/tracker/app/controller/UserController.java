package com.spring.boot.job.tracker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.spring.boot.job.tracker.app.dtos.user.UserRegistrationDto;
import com.spring.boot.job.tracker.app.service.UserService;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {

        log.info("RENDERING REGISTER FORM TO REGISTER THE USER");
        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.setUsername("test_123");
        userDto.setFullName("TESTING");
        userDto.setAddress("KARACHI");
        userDto.setEmail("test@example.com");
        userDto.setPassword("password");
        userDto.setPhoneNumber("1234567890");
        userDto.setAge(30);
        userDto.setGender("MALE");
        userDto.setRole("USER");
        userDto.setPassword("test@123");

        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserRegistrationDto userDto, RedirectAttributes redirectAttributes) throws MessagingException {
        log.info("User Registration Request Dto: {}", userDto);
        userService.registerUser(userDto);
        redirectAttributes.addFlashAttribute("registrationSuccess", true);
        return "redirect:/register";
    }


}
