package com.jobtracker.repository;

import com.jobtracker.entity.Application;
import com.jobtracker.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByStatus(Status status);
}