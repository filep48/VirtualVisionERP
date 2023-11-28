package com.virtualvision.erp.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Customer extends User {

    // Relación uno a muchos con Evento
    // cascade = CascadeType.ALL: Especifica que las operaciones de persistencia, como guardar y eliminar, deben propagarse a las entidades relacionadas.
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events;


    // Relación uno a muchos con Venta
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sale> sales;

    
}
