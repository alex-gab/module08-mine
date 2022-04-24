package com.spring.professional.exam.tutorial.module08.question01.postprocessing;

import com.spring.professional.exam.tutorial.module08.question01.service.PaymentResult;
import com.spring.professional.exam.tutorial.module08.question01.service.PaymentService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

import static com.spring.professional.exam.tutorial.module08.question01.service.PaymentResult.Status.OK;
import static com.spring.professional.exam.tutorial.module08.question01.service.PaymentResult.Status.PARTIAL;

public class PaymentBatchInvocationHandler implements InvocationHandler {
    private final PaymentService paymentService;

    public PaymentBatchInvocationHandler(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws ReflectiveOperationException {
        if (Objects.equals(method.getName(), "pay")) {
            int initial = (Integer) args[0];
            PaymentResult result = (PaymentResult) method.invoke(paymentService, args);
            if (Objects.equals(result.getStatus(), PARTIAL)) {
                completePayment(method, initial - result.getAmount());
                return PaymentResult.success(initial, OK);
            } else {
                return result;
            }
        } else {
            return method.invoke(paymentService, args);
        }
    }

    private void completePayment(Method method, int remaining) throws ReflectiveOperationException {
        while (remaining > 0) {
            PaymentResult result = (PaymentResult) method.invoke(paymentService, new Object[]{remaining});
            remaining = remaining - result.getAmount();
        }
    }
}
