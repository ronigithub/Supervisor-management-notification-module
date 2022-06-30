package com.assessment.backendservice.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Supervisor {
    private Long id;
    private String phone;
    private String jurisdiction;
    private String identificationNumber;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return jurisdiction + " - " + lastName + ", " + firstName;
    }
}
