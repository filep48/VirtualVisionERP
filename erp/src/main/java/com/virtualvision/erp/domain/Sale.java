package com.virtualvision.erp.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

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

    // Relación muchos a muchos con Product, se hace esta relacion n-n ya que si más
    // adelante se implementa
    // comision individual para los empleados será más fácil escalar el código.
    @ManyToMany
    @JoinTable(name = "sale_product", joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    // relacion con CompanyEvent ManyToMany
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sale_event", joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<CompanyEvent> events = new HashSet<>();

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    @Column(name = "tax_value")
    private Double taxValue;
    @Column(name = "sale_date")
    private LocalDateTime saleDate;

    @Column(name = "online_sale")
    private boolean onlineSale;

    @Column(name = "employee_id")
    private Long employeeId;

}
