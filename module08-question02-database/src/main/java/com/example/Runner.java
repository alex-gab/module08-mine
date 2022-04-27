package com.example;

import com.example.entities.Employee;
import com.example.repositories.EmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.Month;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConf.class);
        applicationContext.registerShutdownHook();

        Employee johnDoe = new Employee();
        johnDoe.setFirstName("John");
        johnDoe.setLastName("Doe");
        johnDoe.setEmail("john.doe@company.com");
        johnDoe.setHireDate(LocalDate.of(1999, Month.AUGUST, 22));
        johnDoe.setSalary(12.44f);
        johnDoe.setPhoneNumber("12345678");

        Employee markSteward = new Employee();
        markSteward.setFirstName("Mark");
        markSteward.setLastName("Steward");
        markSteward.setEmail("mark.steward@company.com");
        markSteward.setHireDate(LocalDate.of(2001, Month.SEPTEMBER, 5));
        markSteward.setSalary(14.17f);
        markSteward.setPhoneNumber("87654321");

        EmployeeRepository employeeRepository = applicationContext.getBean(EmployeeRepository.class);
        employeeRepository.insertEmployee(johnDoe);
        employeeRepository.insertEmployee(markSteward);

        System.out.println("All employees: " + employeeRepository.getAllEmployees());

        System.out.println("Employee emails are: " + employeeRepository.findEmployeeEmails());
    }
}
