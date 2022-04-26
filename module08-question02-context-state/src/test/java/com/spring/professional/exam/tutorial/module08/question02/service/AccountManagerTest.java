package com.spring.professional.exam.tutorial.module08.question02.service;

import com.spring.professional.exam.tutorial.module08.question02.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
class AccountManagerTest {

    private final AccountManager accountManager;

    @Autowired
    AccountManagerTest(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Test
    void deposit() {
        System.out.println("Balance before deposit is: " + accountManager.checkBalance());
        accountManager.deposit(50);
    }

    @Test
    void withdraw() {
        System.out.println("Balance before withdrawal is: " + accountManager.checkBalance());
        accountManager.withdraw(40);
    }
}