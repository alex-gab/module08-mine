package com.example.repositories;

import com.example.entities.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    public List<String> findEmployeeEmails() {
        //noinspection unchecked
        return (List<String>) entityManager.createNativeQuery("select email from employee").getResultList();
    }
}
