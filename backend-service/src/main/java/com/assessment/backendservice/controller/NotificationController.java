package com.assessment.backendservice.controller;

import com.assessment.backendservice.controller.request.NotificationRequest;
import com.assessment.backendservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Notification Controller
 * @version 1.0
 * @author Md. Josim Uddin Roni
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/submit")
@CrossOrigin
public class NotificationController {

    private final NotificationService notificationService;

    /**
     * Notification request
     *
     * @param notificationRequest param
     */
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void requestSubmit(@RequestBody @Valid NotificationRequest notificationRequest) {
        notificationService.requestSubmit(notificationRequest);
    }
}
