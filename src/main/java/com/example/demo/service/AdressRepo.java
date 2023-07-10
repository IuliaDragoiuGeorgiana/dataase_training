package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;

import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdressRepo extends CrudRepository<Address, Long> {
    List<Address> findAll();

}
