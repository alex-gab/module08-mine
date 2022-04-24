package com.spring.professional.exam.tutorial.module08.question01.postprocessing;

import com.spring.professional.exam.tutorial.module08.question01.ApplicationConfig;
import com.spring.professional.exam.tutorial.module08.question01.service.PaymentService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import java.lang.reflect.Proxy;

public class BatchPaymentServiceBeanPostProcessor implements BeanPostProcessor, Ordered {
    private int order = LOWEST_PRECEDENCE - 2;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PaymentService) {
            bean = newBatchPaymentServiceProxy((PaymentService) bean);
        }
        return bean;
    }

    private PaymentService newBatchPaymentServiceProxy(PaymentService paymentService) {
        return (PaymentService) Proxy.newProxyInstance(
                ApplicationConfig.class.getClassLoader(),
                new Class[]{PaymentService.class},
                new PaymentBatchInvocationHandler(paymentService));
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }
}
