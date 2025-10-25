package com.spring.boot.job.tracker.app.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto {
    private String username;
    private String password;
    private String email;
    private String role;
    private String fullName;
    private String phoneNumber;
    private String address;
    private int age;
    private String userId;
    private String gender;
}
