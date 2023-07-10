package com.example.demo.controller;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/")
public class Controller {
    private final CustomerService customerService;

    @Autowired
    public Controller(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable long id, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
    }


    @GetMapping("/customers")
    public List<Customer> allCustomer() {
        return customerService.allCustomer();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerService.getCustomer(id);
    }






    @PostMapping("/addresses")
    public Address createAddress(@RequestBody Address address) {
        return customerService.createAddress(address);
    }

    @PutMapping("/addresses/{id}")
    public Address updateAddress(@PathVariable long id, @RequestBody Address updatedAddress) {
        return customerService.updateAddress(id, updatedAddress);
    }




    @GetMapping("/addresses")
    public List<Address>allAddress() {
        return customerService.allAddress();
    }

    @GetMapping("/addresses/{id}")
    public Address getAddress(@PathVariable long id) {
        return customerService.getAddress(id);
    }

}
