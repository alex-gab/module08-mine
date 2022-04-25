package com.spring.professional.exam.tutorial.module08.question01.service;

import com.spring.professional.exam.tutorial.module08.question01.ApplicationConfig;
import com.spring.professional.exam.tutorial.module08.question01.aspect.PaymentServiceLoggingAspect;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AopTestUtils;

import java.lang.reflect.Proxy;
import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
class CappedPaymentServiceTest {

    @Autowired
    private PaymentService cappedPaymentService;

    @Autowired
    private PaymentServiceLoggingAspect paymentServiceLoggingAspect;

    @Test
    void payTest() {
        System.out.println(cappedPaymentService);
        System.out.println("is proxy: " + Proxy.isProxyClass(cappedPaymentService.getClass()));

        System.out.println("is aop proxy: " + AopUtils.isAopProxy(cappedPaymentService));
        System.out.println("is jdk dynamic proxy proxy: " + AopUtils.isJdkDynamicProxy(cappedPaymentService));
        System.out.println("is CGLIB dynamic proxy proxy: " + AopUtils.isCglibProxy(cappedPaymentService));

        System.out.println("target object: " + AopTestUtils.getTargetObject(cappedPaymentService).getClass());
        System.out.println("ultimate target object: " + AopTestUtils.getUltimateTargetObject(cappedPaymentService).getClass());

        System.out.println("paymentServiceLoggingAspect instanceof Advisor? : " + (paymentServiceLoggingAspect instanceof Advisor));
        System.out.println("cappedPaymentService instanceof AdvisedSupport? : " + (cappedPaymentService instanceof AdvisedSupport));
        System.out.println("singleton target for cappedPaymentService: " + AopProxyUtils.getSingletonTarget(cappedPaymentService));
        System.out.println("proxiedUserInterfaces for cappedPaymentService: " + Arrays.toString(AopProxyUtils.proxiedUserInterfaces(cappedPaymentService)));
        System.out.println("ultimateTargetClass for cappedPaymentService: " + AopProxyUtils.ultimateTargetClass(cappedPaymentService));

    }
}