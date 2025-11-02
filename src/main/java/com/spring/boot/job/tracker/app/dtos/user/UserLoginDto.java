package com.spring.boot.job.tracker.app.dtos.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginDto {
    private String username;
    private String password;
}
