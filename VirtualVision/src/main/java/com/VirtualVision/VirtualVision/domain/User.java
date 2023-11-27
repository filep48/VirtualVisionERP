package com.VirtualVision.VirtualVision.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "email")
    protected String email;
    @Column(name = "name")
    protected String name;
    @Column(name = "surname")
    protected String surname;
    @Column(name = "phone")
    protected String phone;
    @Column(name = "username")
    protected String username;
    @Column(name = "password")
    protected String password;

    // Relación muchos a muchos con Chat
    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Chat> chats;

    // Constructores, getters y setters
    public User() {
        // Constructor vacío necesario para JPA
    }

    public User(String email, String name, String surname, String phone, String username, String password,
            Set<Chat> chats) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.chats = chats;
    }

    public User(String email, String name, String surname, String phone, String username, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    // Aquí agregar getters y setters para todos los campos, incluyendo chats
}