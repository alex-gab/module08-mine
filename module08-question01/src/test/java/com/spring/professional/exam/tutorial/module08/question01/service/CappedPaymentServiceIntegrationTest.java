package com.spring.professional.exam.tutorial.module08.question01.service;

import com.spring.professional.exam.tutorial.module08.question01.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AopTestUtils;

import java.lang.reflect.Proxy;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
class CappedPaymentServiceIntegrationTest {
    @Autowired
    private PaymentService cappedPaymentService;

    @Test
    void payTest() {
        System.out.println(cappedPaymentService);
        System.out.println("is proxy: " + Proxy.isProxyClass(cappedPaymentService.getClass()));
        System.out.println("is aop proxy: " + AopUtils.isAopProxy(cappedPaymentService));
        System.out.println("is jdk dynamic proxy proxy: " + AopUtils.isJdkDynamicProxy(cappedPaymentService));
        System.out.println("is CGLIB dynamic proxy proxy: " + AopUtils.isCglibProxy(cappedPaymentService));
        System.out.println("target object: " + AopTestUtils.getTargetObject(cappedPaymentService).getClass());
        System.out.println("ultimate target object: " + AopTestUtils.getUltimateTargetObject(cappedPaymentService).getClass());
    }
}
