package com.example.demo;

import com.example.demo.EmployeeAlreadyAddedException;
import com.example.demo.EmployeeNotFoundException;
import com.example.demo.EmployeeStorageIsFullException;
import com.example.demo.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private static final int MAX_EMPLOYEES = 100;

    public void addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Employee storage is full");
        }
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        }
        employees.add(newEmployee);
    }

    public void removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee);
    }

    public Employee findEmployee(String firstName, String lastName) {
        return employees.stream()
                .filter(employee -> employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
