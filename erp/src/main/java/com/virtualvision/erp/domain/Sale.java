package com.virtualvision.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sales")
@Data
public class Sale implements Serializable {

    // Relación con Customer
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    // Relación muchos a muchos con Employee
    @ManyToMany
    @JoinTable(name = "sales_employees", joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employees = new HashSet<>();

    // Relación muchos a muchos con Product, se hace esta relacion n-n ya que si más adelante se implementa 
    // comision individual para los empleados será más fácil escalar el código.
    @ManyToMany
    @JoinTable(name = "sale_product", joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private BigDecimal taxValue;

    private LocalDateTime saleDate;

    @Column(name = "online_sale")
    private boolean onlineSale;

    @Column(name = "employee_id")
    private Long employeeId;

}
