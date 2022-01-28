package com.example.springwebex3.infrastructure.repository;

import com.example.springwebex3.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

@Repository
public class EmployeeRepository {
    private final Set<Employee> employees = new HashSet<>();

    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Employee findEmployeeById(String id) {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        throw new NoSuchElementException("No employee present with given id: " + id);
    }

    public void removeEmployeeById(String id) {
        final Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
            }
        }
    }
}
