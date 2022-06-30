package com.assessment.backendservice.service;

import com.assessment.backendservice.controller.request.NotificationRequest;
import org.springframework.stereotype.Service;

/**
 * Notification service
 */
@Service
public class NotificationService {

    /**
     * Accepts notification request data
     *
     * @param notificationRequest params
     */
    public void requestSubmit(NotificationRequest notificationRequest) {
        String firstName = notificationRequest.getFirstName();
        String lastName = notificationRequest.getLastName();
        String email = notificationRequest.getEmail();
        String phoneNumber = notificationRequest.getPhoneNumber();
        String supervisor = notificationRequest.getSupervisor();

        // request is successful and printed on console
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Supervisor: " + supervisor);
    }

}
