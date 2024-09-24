package com.kgisl.onetoone.controller;

import com.kgisl.onetoone.entity.Employee;
import com.kgisl.onetoone.entity.Otp;
import com.kgisl.onetoone.repository.OtpRepository;
// import com.kgisl.onetoone.service.EmailService;
import com.kgisl.onetoone.service.EmployeeService;
import com.kgisl.onetoone.util.OTPGenerator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // @Autowired
    // private EmailService emailService;

    @Autowired
    private OtpRepository otpRepository;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @PostMapping
    // public ResponseEntity<Employee> createEmployee(@RequestBody Employee
    // employee) {
    // Employee savedEmployee = employeeService.saveEmployee(employee);
    // return new ResponseEntity<>(savedEmployee,HttpStatus.OK);
    // }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);

        String otp = OTPGenerator.generateOTP(6);

        // emailService.sendOTP(employee.getEmail(), otp);

        Otp otpEntity = new Otp();
        otpEntity.setEmployeeId(savedEmployee.getId());
        otpEntity.setOtp(otp);

        otpRepository.save(otpEntity);

        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        if (employeeService.getEmployeeById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Employee e = employeeService.updateEmployee(id, updatedEmployee);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Employee>> getByCity(@PathVariable String city) {
        List<Employee> employees = employeeService.getEmployeesByCity(city);

        if (employees != null) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
