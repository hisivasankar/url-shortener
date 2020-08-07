package com.sivasankr.dbservice.rest;

import com.sivasankr.dbservice.models.HealthModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/db-service")
public class HealthService {

    @GetMapping("/health")
    public HealthModel health() {
        return new HealthModel("Okay");
    }
}
