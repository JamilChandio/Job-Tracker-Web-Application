package com.spring.boot.job.tracker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import com.spring.boot.job.tracker.app.dtos.UserRequestDto;
import com.spring.boot.job.tracker.app.dtos.UserResponseDto;
import com.spring.boot.job.tracker.app.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RestController
@RequestMapping("api/users")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/getUser")
    public ResponseEntity<UserResponseDto> getUserDetails(@ModelAttribute UserRequestDto requestDto) {
        log.info("Received request to get user details: {}", requestDto);
        UserResponseDto response = userService.getUserDetails(requestDto);
        return ResponseEntity.ok(response);
    }

}
