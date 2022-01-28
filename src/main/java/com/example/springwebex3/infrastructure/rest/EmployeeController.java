package com.example.springwebex3.infrastructure.rest;

import com.example.springwebex3.domain.Employee;
import com.example.springwebex3.infrastructure.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Set<Employee> listEmployees(@RequestParam(required = false) Integer limit) {
        return employeeService.createEmployeeList(limit);

//        or if you prefer to use Java 8 Streams:
//        return employees
//                .stream()
//                .limit(Optional.ofNullable(limit).orElse(employees.size()))
//                .collect(Collectors.toUnmodifiableSet());
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Employee selectEmployee(@PathVariable String id) {
        return employeeService.findEmployee(id);

//        or if you prefer to use Java 8 Streams:
//        return employees
//                .stream()
//                .filter(employee -> employee.getId().equals(id))
//                .findFirst()
//                .orElseThrow();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployee(@PathVariable String id) {
        employeeService.removeEmployee(id);

//        or if you prefer to use Java 8 Streams:
//        employees.removeIf(employee -> employee.getId().equals(id));
    }
}
