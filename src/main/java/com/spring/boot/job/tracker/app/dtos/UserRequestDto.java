package com.spring.boot.job.tracker.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRequestDto {

    @JsonProperty("username")
    private  String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    @JsonProperty("role")
    private String role;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("address")
    private String address;

    @JsonProperty("age")
    private int age;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("gender")
    private String gender;
}
