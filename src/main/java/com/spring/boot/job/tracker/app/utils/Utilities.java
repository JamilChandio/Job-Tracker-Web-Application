package com.spring.boot.job.tracker.app.utils;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class Utilities {

    public int generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = random.nextInt(900000) + 100000;
        log.info("Generated OTP: {}" , otp);
        return otp;
    }

}
