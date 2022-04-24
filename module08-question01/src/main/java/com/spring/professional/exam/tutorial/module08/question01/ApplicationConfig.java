package com.spring.professional.exam.tutorial.module08.question01;

import com.spring.professional.exam.tutorial.module08.question01.postprocessing.BatchPaymentServiceBeanPostProcessor;
import com.spring.professional.exam.tutorial.module08.question01.postprocessing.ValidationPaymentServiceBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.core.Ordered.LOWEST_PRECEDENCE;

@ComponentScan
public class ApplicationConfig {
    @Bean
    public BeanPostProcessor validationPaymentServiceBeanPostProcessor() {
        ValidationPaymentServiceBeanPostProcessor postProcessor = new ValidationPaymentServiceBeanPostProcessor();
        postProcessor.setOrder(LOWEST_PRECEDENCE - 1);
        return postProcessor;
    }

    @Bean
    public BeanPostProcessor batchPaymentServiceBeanPostProcessor() {
        BatchPaymentServiceBeanPostProcessor postProcessor = new BatchPaymentServiceBeanPostProcessor();
        postProcessor.setOrder(LOWEST_PRECEDENCE - 2);
        return postProcessor;
    }
}
