package com.job.tracker.user.model;

import lombok.Data;

@Data
public class User {

    private String username;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String gender;
    private int age;

}