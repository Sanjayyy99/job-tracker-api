package com.jobtracker.service;

import com.jobtracker.dto.ApplicationDTO;
import com.jobtracker.entity.*;
import com.jobtracker.exception.ResourceNotFoundException;
import com.jobtracker.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository repo;

    public ApplicationService(ApplicationRepository repo) {
        this.repo = repo;
    }

    public Application create(ApplicationDTO dto) {
        Application app = new Application();
        app.setCompanyName(dto.getCompanyName());
        app.setRole(dto.getRole());
        app.setStatus(Status.valueOf(dto.getStatus()));
        app.setAppliedDate(dto.getAppliedDate());
        app.setNotes(dto.getNotes());

        return repo.save(app);
    }

    public List<Application> getAll() {
        return repo.findAll();
    }

    public Application getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    public List<Application> getByStatus(String status) {
        return repo.findByStatus(Status.valueOf(status));
    }

    public Application update(Long id, ApplicationDTO dto) {
        Application app = getById(id);

        app.setCompanyName(dto.getCompanyName());
        app.setRole(dto.getRole());
        app.setStatus(Status.valueOf(dto.getStatus()));
        app.setAppliedDate(dto.getAppliedDate());
        app.setNotes(dto.getNotes());

        return repo.save(app);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}