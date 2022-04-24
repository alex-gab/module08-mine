package com.spring.professional.exam.tutorial.module08.question01.postprocessing;

import com.spring.professional.exam.tutorial.module08.question01.ApplicationConfig;
import com.spring.professional.exam.tutorial.module08.question01.service.PaymentService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import java.lang.reflect.Proxy;

public class ValidationPaymentServiceBeanPostProcessor implements BeanPostProcessor, Ordered {
    private int order = LOWEST_PRECEDENCE - 1;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PaymentService) {
            bean = newValidationPaymentServiceProxy((PaymentService) bean);
        }
        return bean;
    }

    private PaymentService newValidationPaymentServiceProxy(PaymentService paymentService) {
        return (PaymentService) Proxy.newProxyInstance(
                ApplicationConfig.class.getClassLoader(),
                new Class[]{PaymentService.class},
                new PaymentValidationInvocationHandler(paymentService));
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }
}
