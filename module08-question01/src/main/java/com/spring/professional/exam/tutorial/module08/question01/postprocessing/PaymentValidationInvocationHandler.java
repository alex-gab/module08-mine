package com.spring.professional.exam.tutorial.module08.question01.postprocessing;

import com.spring.professional.exam.tutorial.module08.question01.service.PaymentResult;
import com.spring.professional.exam.tutorial.module08.question01.service.PaymentService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

import static com.spring.professional.exam.tutorial.module08.question01.service.PaymentResult.failed;

public class PaymentValidationInvocationHandler implements InvocationHandler {
    private final PaymentService paymentService;

    public PaymentValidationInvocationHandler(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws ReflectiveOperationException {
        if (Objects.equals(method.getName(), "pay")) {
            int amount = (Integer) args[0];
            return amount > 0 ? (PaymentResult) method.invoke(paymentService, args) : failed();
        } else {
            return method.invoke(paymentService, args);
        }
    }
}
