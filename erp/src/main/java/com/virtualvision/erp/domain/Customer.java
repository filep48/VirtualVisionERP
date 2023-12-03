package com.virtualvision.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Customer {

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

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String surname;

    @NotBlank(message = "username is required")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "password is required")
    @Column(nullable = false)
    @ToString.Exclude
    private String password;

    @Column(name = "dni_nif", unique = true)
    private String dniNif;

    @Column(nullable = true)
    private String phone;

    @NotBlank(message = "email is required")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String address;

    @Column(nullable = false)
    private String role = "user";

}
