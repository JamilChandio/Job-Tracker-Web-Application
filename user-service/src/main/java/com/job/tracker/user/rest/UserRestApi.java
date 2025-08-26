package com.job.tracker.user.rest;


import com.job.tracker.user.dtos.Response;
import com.job.tracker.user.model.User;
import com.job.tracker.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserRestApi {

    private final UserService userService;

    @Autowired
    public UserRestApi(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register" , consumes = "application/json")
    public Response registerUser(@RequestBody User user) {
        log.info("Received request to register user {}", user);
        return userService.registerUser(user);
    }
}