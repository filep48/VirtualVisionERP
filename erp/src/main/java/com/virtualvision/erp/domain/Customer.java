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

    public Customer(Long id2, String name2, String surname2, String username2, String password2, String dniNif2,
            String phone2, String address2, String email2, String role2) {
        // Initialize all fields here
        this.role = role2;
    }

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @NotBlank(message = "username is required")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "password is required")
    @Column(nullable = false)
    @ToString.Exclude
    private String password;

    @Column(name = "dni_nif", nullable = false, unique = true)
    private String dniNif;

    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "email is required")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String role;
}
