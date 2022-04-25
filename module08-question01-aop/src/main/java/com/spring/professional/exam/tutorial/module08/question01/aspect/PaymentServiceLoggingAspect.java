package com.spring.professional.exam.tutorial.module08.question01.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class PaymentServiceLoggingAspect {

    @Around("execution(* com.spring.professional.exam.tutorial.module08.question01.service.PaymentService.pay(..)) && args(amount)")
    public Object paymentLogging(ProceedingJoinPoint joinPoint, int amount) throws Throwable {
        System.out.println("PaymentService.pay was called with amount: " + amount);
        Object ret = joinPoint.proceed(new Object[]{amount});
        System.out.println("PaymentService.pay finished result is: " + ret);
        return ret;
    }
}
