package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class CustomerService implements ServiceInterface {
    private final CustomerRepo customerRepository;
    private final AdressRepo addressRepository;

    public CustomerService(CustomerRepo customerRepository, AdressRepo addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }


    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }


    public Customer updateCustomer(Long id, Customer updatedCustomer) throws NoSuchElementException {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());

        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setDateOfBirth(updatedCustomer.getDateOfBirth());



        return customerRepository.save(existingCustomer);
    }
    public List<Customer> allCustomer() {
        return customerRepository.findAll();
    }


    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }


    public Address updateAddress(Long id, Address updatedAddress) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Address not found"));

        existingAddress.setCity(updatedAddress.getCity());
        existingAddress.setPostalCode(updatedAddress.getPostalCode());
        existingAddress.setStreet(updatedAddress.getStreet());
        existingAddress.setNumber(updatedAddress.getNumber());
        existingAddress.setCountry(updatedAddress.getCountry());

        return addressRepository.save(existingAddress);
    }


    public Address getAddress(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("address not found"));
    }



    @Override
    public List<Address> allAddress() {
       return addressRepository.findAll();
    }


}









