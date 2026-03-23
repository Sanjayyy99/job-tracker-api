package com.jobtracker.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public class ApplicationDTO {

    @NotBlank
    private String companyName;

    @NotBlank
    private String role;

    private String status;
    private LocalDate appliedDate;
    private String notes;

    // getters & setters
}