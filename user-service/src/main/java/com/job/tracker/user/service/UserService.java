package com.job.tracker.user.service;


import com.job.tracker.user.dtos.Response;
import com.job.tracker.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {


    public Response registerUser(User user) {
        log.info("registering the user {}", user);
        return null;
    }
}