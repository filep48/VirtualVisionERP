package com.virtualvision.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

/**
 * Clase que engloba la mayoría de los campos que tendrán en común los usuarios
 * del ERP.
 * No se establece la obligatoriedad en todos los campos,
 * ya que esta se controlará en cada caso específico,
 * pensando principalmente en el registro ágil de clientes.
 * 
 * Se establece la pk diferente al dni, para mejor funcionamiento de la bbdd.
 * Se deja fuera del toString el password, por seguridad.
 */

@MappedSuperclass
@Data
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @NotBlank(message = "username is required")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "password is required")
    @Column(nullable = false)
    @ToString.Exclude
    private String password;

    @Column(name = "dni_nif", nullable = false, unique = true)
    private String dniNif;

    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "email is required")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String address;

}
