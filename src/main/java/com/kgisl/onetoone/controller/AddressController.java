package com.kgisl.onetoone.controller;

import com.kgisl.onetoone.entity.Address;
import com.kgisl.onetoone.entity.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.onetoone.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeByAddressId(@PathVariable int id) {
        Employee e = addressService.getEmployee(id);

        if (e != null) {
            return new ResponseEntity<>(e, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/city/{city}") // this will return one employee with provided city if many employees error
    public ResponseEntity<Employee> getEmployeesByCity(@PathVariable String city) {

        Address address = addressService.getAllEmployeesByCity(city);

        if (address != null) {
            Employee employee = address.getEmployee();
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cities/{city}") // this will return all employees with same city
    public ResponseEntity<List<Employee>> getAllEmployeesByCity(@PathVariable String city) {
        List<Address> addresses = addressService.getAllAddressesByCity(city);
        List<Employee> employees = new ArrayList<>();

        if (addresses != null && !addresses.isEmpty()) {
            for (Address address : addresses) {
                Employee employee = address.getEmployee();
                if (employee != null) {
                    employees.add(employee);
                }
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress() {
        List<Address> address = addressService.getAllAddress();

        if (address != null) {
            return new ResponseEntity<>(address, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
