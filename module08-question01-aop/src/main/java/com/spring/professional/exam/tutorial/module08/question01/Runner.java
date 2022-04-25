package com.spring.professional.exam.tutorial.module08.question01;

import com.spring.professional.exam.tutorial.module08.question01.service.PaymentResult;
import com.spring.professional.exam.tutorial.module08.question01.service.PaymentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        applicationContext.registerShutdownHook();

        PaymentService paymentService = applicationContext.getBean(PaymentService.class);
        PaymentResult paymentResult = paymentService.pay(-100);
        System.out.println(paymentResult.getAmount());
        System.out.println(paymentResult.getStatus());
    }
}
