package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;
import com.example.demo.domain.CustomerDto;
import com.example.demo.domain.Product;

import java.util.List;

public interface ServiceInterface {
    public CustomerDto createCustomer(Customer customer);
    public CustomerDto updateCustomer (Long id ,Customer customer);
    public CustomerDto getCustomer(Long id);
    public void deleteCustomer(Long id);
    public List<CustomerDto> allCustomer();
    public Address createAddress(Address address);
    public Address updateAddress(Long id, Address address);
    public Address getAddress(Long id);

    public List<Address> allAddress();
    public Product buyProduct(Long id, Product product);



}
