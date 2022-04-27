package com.example.repositories;

import com.example.AppConf;
import com.example.entities.Employee;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@SpringJUnitConfig(AppConf.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeRepositoryTest {

    private final EmployeeRepository employeeRepository;

    @Autowired
    EmployeeRepositoryTest(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Test
    @Order(1)
    @Transactional
    void insertEmployee1() {
        Employee employee = getEmployee("John", "Doe", "john.doe@company.com");
        employeeRepository.insertEmployee(employee);
        List<String> employeeEmails = employeeRepository.findEmployeeEmails();
        assertThat(employeeEmails, is(List.of("john.doe@company.com")));
    }

    @Test
    @Order(2)
    @Transactional
    void insertEmployee2() {
        Employee employee = getEmployee("Kevin", "Parker", "kevin.parker@company.com");
        employeeRepository.insertEmployee(employee);
        List<String> employeeEmails = employeeRepository.findEmployeeEmails();
        assertThat(employeeEmails, is(List.of("kevin.parker@company.com")));
    }

    @Test
    @Order(3)
    @Transactional
    void commitEmployees() {
        List<String> employeeEmails = employeeRepository.findEmployeeEmails();
        assertIterableEquals(employeeEmails, Collections.emptyList());

        Employee employee1 = getEmployee("Martin", "King", "martin.king@company.com");
        Employee employee2 = getEmployee("Victor", "Lord", "victor.lord@company.com");
        employeeRepository.insertEmployee(employee1);
        employeeRepository.insertEmployee(employee2);

        // changes to the database will be committed!
        TestTransaction.flagForCommit();
        TestTransaction.end();
        assertFalse(TestTransaction.isActive());
        employeeEmails = employeeRepository.findEmployeeEmails();
        assertThat(employeeEmails, is(List.of("martin.king@company.com", "victor.lord@company.com")));

        TestTransaction.start();
        Employee employee = getEmployee("Ben", "Wilson", "ben.wilson@company.com");
        employeeRepository.insertEmployee(employee);
        employeeEmails = employeeRepository.findEmployeeEmails();
        assertThat(employeeEmails, is(List.of("martin.king@company.com", "victor.lord@company.com", "ben.wilson@company.com")));
    }

    @Test
    @Order(4)
    @Transactional
    void checkEmails() {
        List<String> employeeEmails = employeeRepository.findEmployeeEmails();
        assertThat(employeeEmails, Matchers.allOf(hasSize(2), is(List.of("martin.king@company.com", "victor.lord@company.com"))));
    }

    private static Employee getEmployee(String firstName, String lastName, String email) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setHireDate(LocalDate.of(1999, Month.AUGUST, 22));
        employee.setSalary(12.44f);
        employee.setPhoneNumber("12345678");
        return employee;
    }
}