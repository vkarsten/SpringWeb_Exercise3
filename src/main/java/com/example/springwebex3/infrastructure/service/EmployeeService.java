package com.example.springwebex3.infrastructure.service;

import com.example.springwebex3.domain.Employee;
import com.example.springwebex3.infrastructure.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean isEmployeeValid(Employee employee) {
        if (employee.getFirstName().startsWith("A")) {
            throw new UnsupportedOperationException();
        }

        return true;
    }

    public Set<Employee> createEmployeeList(Integer limit) {
        final Set<Employee> employees = employeeRepository.getEmployees();

        if (limit == null) {
            return employees;
        }

        final Set<Employee> limitedEmployeesList = new HashSet<>();
        final Iterator<Employee> iterator = employees.iterator();
        int i = 0;
        while (i <= limit && iterator.hasNext()) {
            limitedEmployeesList.add(iterator.next());
            i++;
        }

        return limitedEmployeesList;
    }

    public Employee findEmployee(String id) {
        return employeeRepository.findEmployeeById(id);
    }

    public void removeEmployee(String id) {
        employeeRepository.removeEmployeeById(id);
    }

    public Employee addEmployee(Employee employee) {
        if (isEmployeeValid(employee)) {
           employeeRepository.add(employee);
        }
        return employee;
    }
}
