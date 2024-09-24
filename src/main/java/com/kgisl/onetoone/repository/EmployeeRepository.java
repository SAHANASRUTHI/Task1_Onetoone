package com.kgisl.onetoone.repository;

import com.kgisl.onetoone.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByAddressCity(String city);

    Employee findEmployeesById(int id);
}
