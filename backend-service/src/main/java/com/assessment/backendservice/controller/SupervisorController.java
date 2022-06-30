package com.assessment.backendservice.controller;

import com.assessment.backendservice.service.SupervisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Supervisors Controller
 * @version 1.0
 * @author Md. Josim Uddin Roni
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supervisors")
@CrossOrigin
public class SupervisorController {

    private final SupervisorService supervisorService;

    /**
     * Return all supervisors
     * @return list of String
     */
    @GetMapping
    public List<String> findAll() {
        return supervisorService.findAll();
    }
}
