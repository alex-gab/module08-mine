package com.spring.professional.exam.tutorial.module08.question01.service;

public class PaymentResult {
    private final int amount;
    private final Status status;

    private PaymentResult(int amount, Status status) {
        if (status == Status.KO && amount > 0) {
            throw new IllegalArgumentException("Payments resulted in KO status cannot have a positive amount." +
                    " Current amount is: " + amount);
        }
        this.amount = amount;
        this.status = status;
    }

    public static PaymentResult success(int amount, Status status) {
        return new PaymentResult(amount, status);
    }

    public static PaymentResult failed() {
        return new PaymentResult(0, Status.KO);
    }

    public int getAmount() {
        return amount;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PaymentResult{" +
                "amount=" + amount +
                ", status=" + status +
                '}';
    }

    public enum Status {
        OK, KO, PARTIAL
    }
}
