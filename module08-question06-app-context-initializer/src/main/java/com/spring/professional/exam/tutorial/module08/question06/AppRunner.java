package com.spring.professional.exam.tutorial.module08.question06;

import com.spring.professional.exam.tutorial.module08.question06.service.ApplicationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.registerShutdownHook();

        ApplicationService applicationService = applicationContext.getBean(ApplicationService.class);
        applicationService.run();
    }
}
