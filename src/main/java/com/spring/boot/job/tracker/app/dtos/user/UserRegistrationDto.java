package com.spring.boot.job.tracker.app.dtos.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationDto {
    private  String username;
    private String password;
    private String email;
    private String role;
    private String fullName;
    private String phoneNumber;
    private String address;
    private int age;
    private String gender;
}
