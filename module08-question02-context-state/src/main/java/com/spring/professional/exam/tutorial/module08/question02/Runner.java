package com.spring.professional.exam.tutorial.module08.question02;

import com.spring.professional.exam.tutorial.module08.question02.service.AccountManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        applicationContext.registerShutdownHook();

        AccountManager accountManager = applicationContext.getBean(AccountManager.class);
        accountManager.deposit(50);
        accountManager.withdraw(20);
        accountManager.transfer(10);
        System.out.println(accountManager.checkBalance());
    }
}
