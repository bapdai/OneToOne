package com.example.onetoone.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Address {
    @Id
    @Column(name = "sonha")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sonha;

    @Column(name = "diachi")
    private String diachi;

    @OneToOne(mappedBy = "address")
    private Customer customer;
}
