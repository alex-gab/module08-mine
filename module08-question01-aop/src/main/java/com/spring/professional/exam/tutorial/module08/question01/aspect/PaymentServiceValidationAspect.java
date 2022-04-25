package com.spring.professional.exam.tutorial.module08.question01.aspect;

import com.spring.professional.exam.tutorial.module08.question01.service.PaymentResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class PaymentServiceValidationAspect {

    @Around("execution(* com.spring.professional.exam.tutorial.module08.question01.service.PaymentService.pay(..)) && args(amount)")
    public Object paymentValidation(ProceedingJoinPoint joinPoint, int amount) throws Throwable {
        if (amount > 0) {
            return joinPoint.proceed(new Object[]{amount});
        } else {
            return PaymentResult.failed();
        }
    }

}
