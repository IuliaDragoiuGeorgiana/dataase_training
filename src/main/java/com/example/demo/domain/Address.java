package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="city")
    private String city;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="street")
    private String street;

    @Column(name = "number")
    private Integer number;

    @Column
    private String country;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Customer customer;
}
