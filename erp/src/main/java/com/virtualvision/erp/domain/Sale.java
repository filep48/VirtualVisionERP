package com.virtualvision.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;
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
    private Set<Employee> employees;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal taxValue;

    @Column(nullable = false)
    private LocalDateTime saleDate;

}
