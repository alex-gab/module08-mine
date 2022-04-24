package com.spring.professional.exam.tutorial.module08.question01.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.spring.professional.exam.tutorial.module08.question01.service.PaymentResult.Status.OK;
import static com.spring.professional.exam.tutorial.module08.question01.service.PaymentResult.Status.PARTIAL;
import static com.spring.professional.exam.tutorial.module08.question01.service.PaymentResult.success;

@Service
class CappedPaymentService implements PaymentService {
    private final int amountCap;

    public CappedPaymentService(@Value("100") int amountCap) {
        this.amountCap = amountCap;
    }

    @Override
    public PaymentResult pay(int amount) {
        final PaymentResult result;
        if (amount <= amountCap) {
            result = success(amount, OK);
        } else {
            result = success(amountCap, PARTIAL);
        }
        return result;
    }
}
