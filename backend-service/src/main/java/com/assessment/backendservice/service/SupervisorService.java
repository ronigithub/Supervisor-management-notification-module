package com.assessment.backendservice.service;

import com.assessment.backendservice.dao.Supervisor;
import com.assessment.backendservice.util.ExternalURL;
import lombok.RequiredArgsConstructor;
//import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Supervisor service
 */
@Service
@RequiredArgsConstructor
public class SupervisorService {

    /**
     * External Request Client
     */
    private final RestTemplate restTemplate;

    /**
     * Return all supervisors
     * Format “<jurisdiction> - <lastName>, <firstName>”
     * @return list of String (Supervisors information)
     */
    public List<String> findAll() {
        ResponseEntity<Supervisor[]> response = restTemplate.getForEntity(ExternalURL.managersApi, Supervisor[].class);

        Supervisor[] supervisors = response.getBody();

        // If response is null
        if (supervisors == null) {
            return new ArrayList<>();
        }

        // Array to list
        List<Supervisor> supervisorList = Arrays.asList(supervisors);

        // response of all sorted(jurisdiction, lastname, firstname) supervisors
        return supervisorList.stream().filter(supervisor -> !StringUtils.isNumericSpace(supervisor.getJurisdiction())).map(Supervisor::toString).sorted().collect(Collectors.toList());
    }
}
