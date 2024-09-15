package com.example.demo;

import com.example.demo.EmployeeNotFoundException;
import com.example.demo.EmployeeStorageIsFullException;
import com.example.demo.EmployeeAlreadyAddedException;
import com.example.demo.Employee;
import com.example.demo.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;