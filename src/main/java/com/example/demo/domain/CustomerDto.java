package com.example.demo.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CustomerDto {

   private   String name;
   private  String email;
   private  List<ProductDto> products;
}


