package com.spring.professional.exam.tutorial.module08.question03.application;

import com.spring.professional.exam.tutorial.module08.question03.configuration.MockitoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig({ApplicationService.class, MockitoConfiguration.class})
class ApplicationServiceTest {
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    void applicationServiceTest() {
        System.out.println(applicationService);
        System.out.println("\nRegistered beans:");
        for (String bdn : applicationContext.getBeanDefinitionNames()) {
            System.out.println(bdn);
        }
    }
}