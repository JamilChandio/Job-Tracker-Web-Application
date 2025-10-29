package com.spring.boot.job.tracker.app.dtos.user;

import lombok.Data;

@Data
public class User {

    private  String username;
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
