package com.jobtracker.controller;

import com.jobtracker.dto.ApplicationDTO;
import com.jobtracker.entity.Application;
import com.jobtracker.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public Application create(@Valid @RequestBody ApplicationDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Application> getAll(@RequestParam(required = false) String status) {
        if (status != null) {
            return service.getByStatus(status);
        }
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Application getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Application update(@PathVariable Long id,
                              @RequestBody ApplicationDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}