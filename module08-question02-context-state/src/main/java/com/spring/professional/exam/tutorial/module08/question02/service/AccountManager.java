package com.spring.professional.exam.tutorial.module08.question02.service;

import org.springframework.stereotype.Service;

import static com.spring.professional.exam.tutorial.module08.question02.service.PaymentResult.Status.OK;

@Service
public class AccountManager {
    private final PaymentService paymentService;
    private int balance;

    public AccountManager(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void transfer(int amount) {
        PaymentResult paymentResult = paymentService.pay(amount);
        if (paymentResult.getStatus() == OK) {
            balance -= paymentResult.getAmount();
        } else {
            throw new AccountException("Amount: " + amount + " could not be transferred.");
        }
    }

    public int checkBalance() {
        return balance;
    }
}
