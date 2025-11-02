package com.spring.boot.job.tracker.app.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {

        String id;
        String companyName;
        String position;
        String status;// e.g., "Pending", "Interviewed", "Accepted", "Rejected"
        LocalDate appliedDate;
        LocalDate followUpDate;
        String notes;
        String username; // which user this application belongs to
}
