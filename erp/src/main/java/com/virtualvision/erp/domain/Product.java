package com.virtualvision.erp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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

    private String image;

    @Transient
    private int stockAvailable;

    @Override
    public String toString() {
        return name+"\n"+description;
    }

}
