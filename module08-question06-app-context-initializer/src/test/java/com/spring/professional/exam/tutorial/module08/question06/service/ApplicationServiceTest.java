package com.spring.professional.exam.tutorial.module08.question06.service;

import com.spring.professional.exam.tutorial.module08.question06.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.lang.NonNull;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.TestPropertySourceUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class, initializers = ApplicationServiceTest.ApplicationServiceContextInitializer.class)
class ApplicationServiceTest {
    @Autowired
    private ApplicationService applicationService;

    @Test
    void runTest() {
        applicationService.run();
        assertEquals("AwesomeTestAppService", applicationService.getName());
    }

    static class ApplicationServiceContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(@NonNull ConfigurableApplicationContext applicationContext) {
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(applicationContext,
                    "app.service.name=AwesomeTestAppService");
        }
    }
}