package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.example.demo.domain.Address;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column
    private String name;


    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name="email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonManagedReference
    private List<Product> products;

}
