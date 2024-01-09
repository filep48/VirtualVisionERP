package com.virtualvision.erp.domain;
import java.io.Serializable;
import java.math.BigDecimal;
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
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "events")
public class CompanyEvent implements Serializable{

     // Relación ManyToMany con Employee
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "event_employee",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> attendingEmployees = new HashSet<>();

    // Relación ManyToMany con Customer
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "event_customer",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> registeredCustomers = new HashSet<>();

    // Relación ManyToMany con Sale
    @ManyToMany(mappedBy = "events")
    private Set<Sale> sales = new HashSet<>();



    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; 

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime; 

    private String description; 

    private Boolean isPaid; // se paga o es gratuita?
    
    private BigDecimal price;

    private String location; 
    private int capacity; // asistentes
    private String organizer; // Organizador del evento

}