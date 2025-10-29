package com.spring.boot.job.tracker.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.job.tracker.app.dtos.UserRequestDto;
import com.spring.boot.job.tracker.app.dtos.UserResponseDto;
import com.spring.boot.job.tracker.app.dtos.user.UserRegistrationDto;
import com.spring.boot.job.tracker.app.entity.User;
import com.spring.boot.job.tracker.app.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
    }

    public UserResponseDto getUserDetails(UserRequestDto requestDto) {

        Optional<User> userOptional = userRepository.findByUsername(requestDto.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserResponseDto response = new UserResponseDto();
            response.setUsername(user.getUsername());
            response.setFullName(user.getFullName());
            response.setEmail(user.getEmail());
            return response;
        } else {
            log.warn("User not found with ID: {}", requestDto.getUserId());
            return null;
        }
    }

    public void registerUser(UserRegistrationDto userDto) {

        log.info("Registering user {}", userDto);
        User userEntity = User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .fullName(userDto.getFullName())
                .phoneNumber(userDto.getPhoneNumber())
                .address(userDto.getAddress())
                .age(userDto.getAge())
                .gender(userDto.getGender())
                // Default / Required Fields
                .failedAttempts(0)
                .accountLocked(false)
                .isActive(true)
                .lastLoginAt(null) // optional, will be updated later
                .profileImageUrl(null) // optional, can be updated later
                .build();

        User savedUser = userRepository.save(userEntity);
        log.info("User registered successfully with ID: {}", savedUser.getUserId());

        // Registration logic goes here
        // For example, save the user to the database
    }

}
