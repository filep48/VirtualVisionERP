package com.virtualvision.erp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable {

    // relacion oneToMany con supplier
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // relacion manyToMany con sale
    @ManyToMany(mappedBy = "products")
    private Set<Sale> sales = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    private int quantity;

    private Double price;
    
    @Transient
    private int stockAvailable;

}
