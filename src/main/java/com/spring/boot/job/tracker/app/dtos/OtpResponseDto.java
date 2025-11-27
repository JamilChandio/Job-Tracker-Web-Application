package com.spring.boot.job.tracker.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpResponseDto {

    private int maximumAttempts;
    private int attempts;
    private int otp;
    private boolean otpVerified;
}
