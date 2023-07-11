package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;
import com.example.demo.domain.CustomerDto;
import com.example.demo.domain.Product;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
@Service
@Log4j2
public class CustomerService implements ServiceInterface {
    private final CustomerRepo customerRepository;
    private final AdressRepo addressRepository;
    private final ProductRepo productRepo;

    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepo customerRepository, AdressRepo addressRepository, ProductRepo productRepo,ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.productRepo= productRepo;
        this.modelMapper=modelMapper;
    }


    public CustomerDto getCustomer(Long customerId) {
        return modelMapper.map(customerRepository.findById(customerId).orElseThrow(() -> new NoSuchElementException("Customer not found")),CustomerDto.class);

    }
    public CustomerDto createCustomer(Customer customer) {
        return modelMapper.map(customerRepository.save(customer), CustomerDto.class);
    }

    public List<CustomerDto> allCustomer() {
       return  Arrays.asList(modelMapper.map(customerRepository.findAll(),CustomerDto[].class));
    }
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }


    public CustomerDto updateCustomer(Long id, Customer updatedCustomer) throws NoSuchElementException {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());

        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setProducts(updatedCustomer.getProducts());

        return modelMapper.map(customerRepository.save(existingCustomer),CustomerDto.class);
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


    public Product buyProduct(Long id, Product product) {

        customerRepository.findById(id).get().getProducts().add(product);
        product.setCustomer(customerRepository.findById(id).get());
        return productRepo.save(product);

    }






}











