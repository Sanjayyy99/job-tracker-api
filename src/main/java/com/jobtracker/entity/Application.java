package com.jobtracker.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String role;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate appliedDate;
    private String notes;

    // getters & setters
}
