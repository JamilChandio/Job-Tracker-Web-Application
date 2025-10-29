package com.spring.boot.job.tracker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.job.tracker.app.dtos.user.User;
import com.spring.boot.job.tracker.app.dtos.user.UserRegistrationDto;
import com.spring.boot.job.tracker.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AuthController {

    private static UserService userServiceObj;

    // @Autowired
    public AuthController(UserService userService) {
        userServiceObj = userService;
    }


    @GetMapping("/login")
    public String getMethodName(Model model) {
        model.addAttribute("user", new User());
        return "login"; // resolves to templates/login.html
    }

    @GetMapping("/register")
    public String register(Model model){

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
        return "register"; // resolves to templates/register.html
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegistrationDto userDto){
        log.info("User Registration Request Dto: {}", userDto);

        userServiceObj.registerUser(userDto);
        // Registration logic goes here
        return "redirect:/login";
    }
    

}
