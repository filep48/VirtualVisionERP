package com.virtualvision.erp.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Employee {
    //relacion muchos a muchos con la entidad Sale
    @ManyToMany(mappedBy = "employees")
    private Set<Sale> sales;


    // relacion muchos a muchos con la entidad Customer
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Payroll> payrolls = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    @Column(nullable = false)
    private String name;

    
    private String surname;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    @ToString.Exclude
    private String password;

    @Column(name = "dni_nif")
    private String dniNif;

    
    private String phone;

    private String email;

    private String address;

    private String role = "employee";

    private String position;

    private String numSS;
    
    private double salary;

}
