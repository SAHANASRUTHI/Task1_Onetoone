package com.kgisl.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.onetoone.entity.Address;
import com.kgisl.onetoone.entity.Employee;
import com.kgisl.onetoone.repository.AddressRepository;
import com.kgisl.onetoone.repository.EmployeeRepository;

@Service
public class AddressService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findEmployeesById(id);
    }

    public Address getAllEmployeesByCity(String city) {
        Address address = addressRepository.findByCity(city);

        System.out.println("Addres id" + address.getId());

        if (address != null)
            return address;
        return null;
    }

    // Method to get all addresses by city
    public List<Address> getAllAddressesByCity(String city) {
        return addressRepository.findAddressesByCity(city);
    }

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}
