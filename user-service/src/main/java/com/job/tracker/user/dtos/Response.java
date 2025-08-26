package com.job.tracker.user.dtos;

import com.job.tracker.user.model.User;
import lombok.Data;

@Data
public class Response {

    private User user;
}