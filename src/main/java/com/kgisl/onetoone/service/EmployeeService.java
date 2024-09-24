package com.kgisl.onetoone.service;

import com.kgisl.onetoone.entity.Employee;
import com.kgisl.onetoone.repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(int id, Employee employee) {
        Employee emp = employeeRepository.findById(id).orElse(null);

        if (emp != null) {
            employeeRepository.save(employee);
        }
        return null;
    }

    public List<Employee> getEmployeesByCity(String city) {
        return employeeRepository.findByAddressCity(city);
    }

}
