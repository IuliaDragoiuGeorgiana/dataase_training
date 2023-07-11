package com.example.demo.service;
import com.example.demo.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository <Product, Long>{
}
