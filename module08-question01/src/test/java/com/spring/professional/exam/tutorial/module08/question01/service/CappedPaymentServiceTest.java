package com.spring.professional.exam.tutorial.module08.question01.service;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;

class CappedPaymentServiceTest {

    @Test
    void payTest() throws ReflectiveOperationException {
        Constructor<CappedPaymentService> constructor = ReflectionUtils.accessibleConstructor(CappedPaymentService.class, int.class);
        CappedPaymentService cappedPaymentService = constructor.newInstance(10);

        ReflectionTestUtils.setField(cappedPaymentService, "amountCap", 20);

        System.out.println(cappedPaymentService);
    }
}