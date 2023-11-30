package com.virtualvision.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "rols")
public class Rol {

    private static final long serialVersionUID = 1L;

    @Id // L'atribut idRol és la clau primària de la BBDD
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generació autonumèrica de l'id
    private long idRol;

    @NotEmpty // Validació perquè l'usuari afegeixi contingut al camp nom
    @Column(name = "nom", nullable = false, unique = false)
    private String nom;
}