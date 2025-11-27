package com.spring.boot.job.tracker.app.service;

import com.spring.boot.job.tracker.app.dtos.OtpResponseDto;
import com.spring.boot.job.tracker.app.dtos.UserResponseDto;
import com.spring.boot.job.tracker.app.entity.OTP;
import com.spring.boot.job.tracker.app.entity.UserEntity;
import com.spring.boot.job.tracker.app.repository.RepositoryOTP;
import com.spring.boot.job.tracker.app.utils.Utilities;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OTPService {

    @Autowired
    private final RepositoryOTP otpRepository;

    @Autowired
    private final UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private Utilities utils;

    private static final int OTP_VALID_MINUTES = 5;

    public OtpResponseDto sendOtp(String email) throws MessagingException {

        UserEntity userEntity = userService.getUserEntityByEmail(email);

        int generatedOtp = utils.generateOTP();
        OTP otp = new OTP();
        otp.setUser(userEntity);
        otp.setOtpCode(generatedOtp);
        otp.setCreatedAt(LocalDateTime.now());
        otp.setExpiresAt(LocalDateTime.now().plusMinutes(OTP_VALID_MINUTES));
        otp.setAttempts(0);
        otp.setUsed(false);
        
        otp = otpRepository.save(otp);

        OtpResponseDto response = new OtpResponseDto();
        response.setMaximumAttempts(otp.getMaximumAttempts());
        response.setAttempts(otp.getAttempts());
        response.setOtp(otp.getOtpCode());

        log.info("OTP Saved: {}", otp);
        log.info("Maximum Attempts Allowed: {}", otp.getMaximumAttempts());
        emailService.sendEmailOTP(userEntity.getEmail(), userEntity.getFullName(), response);
        return response;
    }

    public OtpResponseDto verifyOtp(int otp, String email) {
        
        UserEntity userEntity = userService.getUserEntityByEmail(email);
        Optional<OTP> otpOptional = otpRepository.findValidOtp(userEntity.getUserId(), otp);
        OtpResponseDto responseDto = new OtpResponseDto();

        if (otpOptional.isPresent()) {
            OTP otpEntity = otpOptional.get();
            otpEntity.setUsed(true);
            otpRepository.save(otpEntity);
            responseDto.setOtpVerified(true);
        } else {
            incrementLatestOtpAttempts(userEntity);
            responseDto.setAttempts(otpOptional.get().getAttempts()+1);
            responseDto.setMaximumAttempts(otpOptional.get().getMaximumAttempts());
            responseDto.setOtpVerified(false);
        }
        log.info("OTP Response Dto: {}",responseDto);
        return responseDto;
    }

    private void incrementLatestOtpAttempts(UserEntity user) {
        otpRepository.findTopByUserOrderByCreatedAtDesc(user)
                .ifPresent(latestOtp -> {
                    latestOtp.setAttempts(latestOtp.getAttempts() + 1);
                    otpRepository.save(latestOtp);
                });
    }
}
