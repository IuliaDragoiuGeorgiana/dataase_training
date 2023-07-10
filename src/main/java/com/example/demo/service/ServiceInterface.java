package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;

import java.util.List;

public interface ServiceInterface {
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer (Long id ,Customer customer);
    public Customer getCustomer(Long id);
    public void deleteCustomer(Long id);
    public List<Customer> allCustomer();
    public Address createAddress(Address address);
    public Address updateAddress(Long id, Address address);
    public Address getAddress(Long id);

    public List<Address> allAddress();
}
