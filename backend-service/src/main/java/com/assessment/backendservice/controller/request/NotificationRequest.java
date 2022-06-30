package com.assessment.backendservice.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationRequest {

    @NotBlank(message = "Firstname is mandatory")
    @Pattern(regexp = "^[a-zA-Z ]+", message = "Only accept letters and space")
    private String firstName;

    @NotBlank(message = "Lastname is mandatory")
    @Pattern(regexp = "^[a-zA-Z ]+", message = "Only accept letters and space")
    private String lastName;

    @Email(regexp = "(^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}){0,1}$", message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^([\\+]{0,1}[0-9]{5,12}){0,1}$", message = "Invalid phone format. Only accept digits(min 5 character - max 12 character) with or without plus(+)")
    private String phoneNumber;

    @NotBlank(message = "Supervisor is mandatory")
    private String supervisor;
}
