package com.spring.boot.job.tracker.app.service;

import org.springframework.stereotype.Service;

import com.spring.boot.job.tracker.app.dtos.UserRequestDto;
import com.spring.boot.job.tracker.app.dtos.UserResponseDto;



@Service
public class UserService {


    public UserResponseDto getUserDetails(UserRequestDto requestDto) {
        // Dummy implementation for demonstration purposes
        // User user = new User();
        // user.setUsername("john_doe");
        // user.setFullName("John Doe");
        // user.setEmail("john.doe@example.com");

        UserResponseDto response = new UserResponseDto();
        response.setUsername("john_doe");
        response.setFullName("John Doe");
        response.setEmail("john.doe@example.com");
        return response;
    }

}
