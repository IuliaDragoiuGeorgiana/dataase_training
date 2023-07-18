package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name_product")
    String nameProduct;

    @Column(name="price_product")
    Integer priceProduct;

    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;




}
