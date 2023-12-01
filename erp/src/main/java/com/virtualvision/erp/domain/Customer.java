package com.virtualvision.erp.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Customer {

    // Relación uno a muchos con Evento
    // cascade = CascadeType.ALL: Especifica que las operaciones de persistencia,
    // como guardar y eliminar, deben propagarse a las entidades relacionadas.
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)/////////// repasar esta relacion y convertirla muchos a muchos??
    private List<Event> events;

    // Relación uno a muchos con Venta
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sale> sales;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    @ToString.Exclude
    private String password;

    @Column(name = "dni_nif", nullable = false, unique = true)
    private String dniNif;

    @Column(nullable = false)
    private String phone;

    @NotEmpty
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String rol = "user";

}
