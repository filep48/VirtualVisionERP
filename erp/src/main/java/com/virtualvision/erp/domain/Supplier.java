package com.virtualvision.erp.domain;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "supplier")
public class Supplier {

    //un Proveedor puede suministrar varios Productos, pero cada Producto solo tiene un Proveedor 
    @OneToMany(mappedBy = "supplier")
    private Set<Product> products = new HashSet<>();


    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String address;
    
    private String phone;
    
    private String email;
    
    private String contact;
    
    private String description;
    
    private String web;
    
    private String accountNumber;
    
    private String bankName;

}
