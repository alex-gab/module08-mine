package com.spring.professional.exam.tutorial.module08.question06.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    private final String name;

    public ApplicationService(@Value("${app.service.name}") String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Running app service with name: " + name);
        System.out.println("Finished running service: " + name);
    }

    public String getName() {
        return name;
    }
}
