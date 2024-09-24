package com.kgisl.onetoone.repository;

import com.kgisl.onetoone.entity.Address;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByCity(String city);
    List<Address> findAddressesByCity(String city);

}
