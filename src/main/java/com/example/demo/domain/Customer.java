package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.example.demo.domain.Address;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="customer")

public class Customer {
    @Id
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



}
