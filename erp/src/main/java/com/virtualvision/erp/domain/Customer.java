package com.virtualvision.erp.domain;

import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;
import java.util.Set;


@Entity
@Data
public class Customer {

    // relacion muchos a muchos con la entidad Employee
    @ManyToMany
    @JoinTable(
        name = "customer_employee",
        joinColumns = @JoinColumn(name = "customer_id"),
        inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> employees = new HashSet<>();

    public Customer() {
    }

    // crea un contructor completo
    public Customer(String name, String surname, String username, String password, String dniNif, String phone,
            String email, String address, String role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.dniNif = dniNif;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public Customer(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
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

    @Column(nullable = true)
    private String phone;

    
    @Column(name = "email")
    private String email;

    @Column(nullable = true)
    private String address;

    @Column(nullable = false)
    private String role = "user";

}
