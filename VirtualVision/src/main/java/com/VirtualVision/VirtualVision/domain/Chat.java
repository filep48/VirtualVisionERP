package com.VirtualVision.VirtualVision.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;
import java.util.Set;
import jakarta.persistence.JoinColumn;

@Entity
@Data
@Table(name = "Chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name; // Nombre del chat, opcional

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt; // Fecha de creación del chat

    // Relación muchos a muchos con User
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "chat_users", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;
    // Relación uno a muchos con Message
    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Message> messages;

    // Constructores, getters y setters
    public Chat() {
        // Constructor vacío necesario para JPA
    }
}
